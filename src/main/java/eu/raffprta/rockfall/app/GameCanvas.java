package eu.raffprta.rockfall.app;

import android.view.*;
import android.content.*;
import android.app.*;
import android.graphics.*;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Timer;

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
        // This enables the capture of ACTION_DOWN (i.e. release)
        this.setLongClickable(true);
        // Add touch listener
        this.setOnTouchListener(touchMonitor);
    }

    public void surfaceCreated(SurfaceHolder holder){
        final int OFF = 135;
        miner = e.getMiner(getWidth() / 2, getHeight() - OFF, 2, 0);
        // Start timer and spawn initial rocks
        stopWatch.start();
        spawnRocks();
        // Start rendering thread.
        (new Thread(new GameThread())).start();
    }

    public void surfaceDestroyed(SurfaceHolder holder){

    }

    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height){

    }

    private List<Fallable> fallables = new ArrayList<Fallable>();
    private StopWatch stopWatch = new StopWatch();
    /**
     * This handles temporal logic in the game.
     */
    private void checkTimerAndReset(StopWatch timer, long timeToElapseNano){
        if(timer.getElapsedTime() > timeToElapseNano){
            spawnRocks();
            timer.reset();
            timer.start();
        }
    }
    /**
     * This method initiates the start of the game, when the surface is drawn.
     */
    private void spawnRocks(){
        Random r = new Random();
        int initialRocks = r.nextInt(getWidth()>>4);
        for(int i = 0 ; i < initialRocks; i++){
            fallables.add(getRandomFallable(r.nextInt(getWidth()), -1*r.nextInt(getHeight())));
        }
    }

    private Fallable getRandomFallable(int x, int y){
        final int FALLABLES_AVAILABLE = 6;
        int theRandomNumber = (new Random()).nextInt(FALLABLES_AVAILABLE);

        switch(theRandomNumber){
            case 0:
                return (Fallable)e.getNoobKitty(x, y, 0, 2);
            case 1:
                return (Fallable)e.getIcePointedRock(x, y, 0, 4);
            case 2:
                return (Fallable)e.getIceRock(x, y, 0, 3);
            case 3:
                return (Fallable)e.getNormalRock(x, y, 0, 3);
            case 4:
                return (Fallable)e.getNormalPointedRock(x,y,0,4);
            case 5:
                return (Fallable)e.getNormalFatRock(x,y,0,2);
        }

        throw new RuntimeException("Unresolved error with random generation");

    }


    private void drawAll(Canvas c){
        screen.render(miner.getX(), miner.getY(), c, miner);
        drawFallables(fallables, c);
        drawHearts(c);
    }

    private void drawHearts(Canvas c){
        double lives = ((Protagonist)miner).getLives();
        for(double i = 0 ; i < lives; i++){
            SpriteContainer toRender;
            if(lives - 0.5 == Math.floor(lives) && i == 0){
                toRender = s.getHeartHalf();
            }else{
                toRender = s.getHeartFull();
            }
            screen.render(getWidth() - ((int)(Math.round(i+1)) * s.getHeartFull().getSprite().getWidth() + 2), 0, c, toRender);
        }
    }

    private void drawFallables(List<Fallable> fallables, Canvas c){
        for(Fallable f : fallables)
            screen.render(f.getX(), f.getY(),c,f);

    }


    private void updateFallables(List<Fallable> fallables){
        for(Fallable f : fallables){
            f.update(f.getX(), f.getY(), 0, f.getVelY());
        }
    }

    private void updateProtagonist(Protagonist e){
        if(touchMonitor.getX() < miner.getX() && touchMonitor.isActivated()){
            miner.update(miner.getX(), miner.getY(), -MOVE_FACTOR, 0);
        }else if (touchMonitor.getX() > miner.getX() && touchMonitor.isActivated()){
            miner.update(miner.getX(), miner.getY(), +MOVE_FACTOR, 0);
        }else{
            miner.update(miner.getX(), miner.getY(), 0, 0);
        }
    }

    /**
     * This private class is a thread that executes the main game loop. The loop updates
     * 60 times per seconds whilst attempting to update the graphics as fast as possible
     * though this limit is capped at 60 FPS anyways on Android devices. The game thread
     * is fed methods from its parent public class (GameCanvas) which cater to updating the
     * game logic or the rendering to the canvas.
     */

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
                    updateFallables(fallables);
                    checkTimerAndReset(stopWatch, new Long("5000000000"));
                }

                // Render specific code is ran in here
                canvas = surface.lockCanvas(null);
                screen.render(0, 0, canvas, s.getBackground());
                drawAll(canvas);
                surface.unlockCanvasAndPost(canvas);
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


            }
        }

    }
}
