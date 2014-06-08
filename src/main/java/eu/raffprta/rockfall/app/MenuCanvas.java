package eu.raffprta.rockfall.app;


import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class MenuCanvas extends SurfaceView implements SurfaceHolder.Callback{

    private Context context;
    private Activity parent;
    private GameScreen s;

    private Rect startGame;
    private Rect highScore;

    public MenuCanvas(Context context, Activity parent, GameScreen s) {
        super(context);
        this.context = context;
        this.parent = parent;
        this.s = s;
    }

    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {

    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {

    }
}
