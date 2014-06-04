package eu.raffprta.rockfall.app;

import android.view.*;
import android.content.*;
import android.app.*;
import android.graphics.*;
import android.util.Log;

import eu.raffprta.rockfall.core.entity.EntityFactory;
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
        canvas = surface.lockCanvas(null);
        drawAll(canvas);
        surface.unlockCanvasAndPost(canvas);
    }

    public void surfaceDestroyed(SurfaceHolder holder){

    }

    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height){

    }

    private void drawAll(Canvas c){
        screen.render(0, 0, c, s.getBackground());
        screen.render(this.getWidth()/2, this.getHeight()-e.getMiner().getSprite().getHeight(), c, e.getMiner());
    }

}
