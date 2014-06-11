package eu.raffprta.rockfall.app;


import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import eu.raffprta.rockfall.core.sprite.SpriteFactory;

public class MenuCanvas extends SurfaceView implements SurfaceHolder.Callback{

    private Context context;
    private Activity parent;
    private GameScreen s;

    private Rect startGame;
    private Rect highScore;
    private Rect exitGame;
    private Canvas canvas;
    private SurfaceHolder surface;
    private SpriteFactory spr;
    private TouchHandler touchHandler;


    public MenuCanvas(Context context, Activity parent, GameScreen s) {
        super(context);
        this.context = context;
        this.parent = parent;
        this.s = s;
        surface = this.getHolder();
        surface.addCallback(this);
        final int BUTTON_WIDTH = 400;
        final int BUTTON_HEIGHT = 70;
        final int OFFSET_Y = 30;
        this.startGame = new Rect(s.getWidth()/3, s.getHeight()/3, s.getWidth()/3 +  BUTTON_WIDTH, s.getHeight()/3+BUTTON_HEIGHT);
        this.highScore = new Rect(s.getWidth()/3, s.getHeight()/3 + BUTTON_HEIGHT + OFFSET_Y, s.getWidth()/3 +  BUTTON_WIDTH, s.getHeight()/3+(2*BUTTON_HEIGHT)+OFFSET_Y);
        this.exitGame =  new Rect(s.getWidth()/3, s.getHeight()/3 + (2*BUTTON_HEIGHT) + (2*OFFSET_Y), s.getWidth()/3 +  BUTTON_WIDTH, s.getHeight()/3+(3*BUTTON_HEIGHT) + (2*OFFSET_Y));
        spr = new SpriteFactory(getResources());
        this.touchHandler = new TouchHandler();
        this.setOnTouchListener(touchHandler);
    }

    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        canvas = surface.lockCanvas(null);
        drawAll(canvas);
        surface.unlockCanvasAndPost(canvas);
        (new Thread(new MenuThread())).start();
    }


    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {

    }

    private void drawAll(Canvas canvas) {
        Paint p = new Paint();
        p.setColor(Color.GREEN);
        s.render(0, 0, canvas, spr.getBackground());
        canvas.drawRect(startGame, p);
        s.renderText(startGame.left, startGame.top, canvas, this.context.getString(R.string.start_game));
        canvas.drawRect(highScore, p);
        s.renderText(highScore.left, highScore.top, canvas, this.context.getString(R.string.view_score));
        canvas.drawRect(exitGame, p);
        s.renderText(exitGame.left, exitGame.top, canvas, this.context.getString(R.string.exit_game));
    }

    private void wrapThread(){
        ((MainGame)parent).switchTo(1);
    }

    private class MenuThread implements Runnable {

        @Override
        public void run() {
            boolean isStartClicked = false;
            while(!isStartClicked){
                isStartClicked = startGame.contains(touchHandler.getX(), touchHandler.getY());
            }

            wrapThread();

        }

    }



}
