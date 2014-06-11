package eu.raffprta.rockfall.app;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;


public class GameIntent extends Activity {

    private GameCanvas game;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Context ctx = getApplicationContext();
        // Remove title bar, as it is of no use in the game.
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        // Set mode to fullscreen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        // Set game and menu canvas
        game = new GameCanvas(ctx, this, new GameScreen(ctx.getResources().getDisplayMetrics().widthPixels, ctx.getResources().getDisplayMetrics().heightPixels));
        setContentView(game);


    }

}
