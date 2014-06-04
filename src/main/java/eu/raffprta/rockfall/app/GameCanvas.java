package eu.raffprta.rockfall.app;

import android.view.*;
import android.content.*;
import android.app.*;
import android.graphics.*;
import android.util.Log;

import eu.raffprta.rockfall.core.entity.*;
import eu.raffprta.rockfall.core.entity.Entity;
import eu.raffprta.rockfall.core.sprite.SpriteFactory;

/**
 * This class represents the main game canvas, where resources like levels, menus
 * and such are controlled.
 */

public class GameCanvas extends SurfaceView implements SurfaceHolder.Callback{

    private Activity parent;
    private Canvas canvas;
    private SurfaceHolder surface;
    private Context context;
    private SpriteFactory s;
    private EntityFactory e;
    private GameScreen screen;
    private TouchHandler touchMonitor = new TouchHandler();
    private boolean gameActive = true;

    private final int MOVE_FACTOR = 2;
    private Entity miner;

    public GameCanvas(Context context, Activity parent){
        super(context);
        // pass the resources to our sprite factory.
        s = new SpriteFactory(getResources());
        // pass the sprite factory to our entity factory
        e = new EntityFactory(s);
        // Set up a surface holder, and callback
        this.context = context;
        surface = this.getHolder();
        surface.addCallback(this);
        this.parent = parent;
        this.screen = new GameScreen(this.getWidth(), this.getHeight());
        // Add touch listener
        this.setOnTouchListener(touchMonitor);
    }

    public void surfaceCreated(SurfaceHolder holder){
        // TODO : Remove magic
        miner = e.getMiner(getWidth() / 2, getHeight() - 135);
        // Start rendering thread.
        (new Thread(new GameThread())).start();
    }

    public void surfaceDestroyed(SurfaceHolder holder){

    }

    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height){

    }

    private void drawAll(Canvas c){
        screen.render(miner.getX(), miner.getY(), c, miner);
    }

    private void updateProtagonist(Protagonist e){
        if(touchMonitor.getX() < miner.getX() && touchMonitor.isActivated()){
            miner.update(miner.getX() - MOVE_FACTOR, miner.getY());
        }else if (touchMonitor.getX() > miner.getX() && touchMonitor.isActivated()){
            miner.update(miner.getX() + MOVE_FACTOR, miner.getY());
        }else{
            miner.update(miner.getX(), miner.getY());
        }
    }

    private class GameThread implements Runnable {
        @Override
        public void run() {
            final int TICKSET = 60;
            // Sets the timing variables.
            long lastTime = System.nanoTime();
            long timer = System.currentTimeMillis();
            // Delta regulates the distribution of ticks per second (for the updates)
            double delta = 0;

            // Frames, updates store information
            int frames = 0;
            int updates = 0;

            while (gameActive) {

                // Nanoseconds act as 1*10^9 / TICKSET
                double ns = 1000000000.0 / TICKSET;
                // Get the current time
                long now = System.nanoTime();
                // Delta gets the temporal difference and divides through by the the tick set, resulting in a fraction of 1
                delta += (now-lastTime) / ns;
                // Resets the timer.
                lastTime = now;

                // Update specific code is ran in here
                while(delta >= 1){
                    updates++;
                    delta--;
                    updateProtagonist((Protagonist)miner);
                }

                // Render specific code is ran in here
                canvas = surface.lockCanvas(null);
                screen.render(0, 0, canvas, s.getBackground());
                drawAll(canvas);
                frames++;

                // This is called when the second has passed
                if(System.currentTimeMillis() - timer > 1000){
                    // Adds one more second
                    timer += 1000;
                    // Solely for debug reasons.
                    Log.w(updates + " : UPS | " , frames + " : FPS");
                    // Reset updates & frames
                    updates = 0;
                    frames = 0;
                }

                surface.unlockCanvasAndPost(canvas);
            }
        }

    }
}
