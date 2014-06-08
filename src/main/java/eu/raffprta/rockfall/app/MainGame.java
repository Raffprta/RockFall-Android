package eu.raffprta.rockfall.app;

import android.app.*;
import android.os.Bundle;
import android.view.*;
import android.content.*;
import android.content.pm.ActivityInfo;

public class MainGame extends Activity {

    private GameCanvas game;
    private MenuCanvas menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Context ctx = getApplicationContext();
        // Remove title bar, as it is of no use in the game.
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        // Set mode to fullscreen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        // Set game and menu canvas
        game = new GameCanvas(ctx, this, new GameScreen(ctx.getResources().getDisplayMetrics().widthPixels, ctx.getResources().getDisplayMetrics().heightPixels));
        menu = new MenuCanvas(ctx, this, new GameScreen(ctx.getResources().getDisplayMetrics().widthPixels, ctx.getResources().getDisplayMetrics().heightPixels));
        setContentView(game);
    }


}
