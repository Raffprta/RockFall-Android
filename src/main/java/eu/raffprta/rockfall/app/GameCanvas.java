package eu.raffprta.rockfall.app;

import android.view.*;
import android.content.*;
import android.app.*;
import android.graphics.*;
import android.util.Log;

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

    public GameCanvas(Context context, Activity parent){
        super(context);
        // pass the resources to our sprite factory.
        s = new SpriteFactory(getResources());
        // Set up a surface holder, and callback
        this.context = context;
        surface = this.getHolder();
        surface.addCallback(this);
        this.parent = parent;
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
        c.drawBitmap(s.getBackground().getSprite(), 0, 0, null);
    }

}
