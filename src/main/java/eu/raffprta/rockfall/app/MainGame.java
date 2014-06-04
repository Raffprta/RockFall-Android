package eu.raffprta.rockfall.app;

import android.app.*;
import android.os.Bundle;
import android.view.*;
import android.content.*;
import android.content.pm.ActivityInfo;

public class MainGame extends Activity {

    private GameCanvas game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Context ctx = getApplicationContext();
        // Remove title bar, as it is of no use in the game.
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        // Set mode to fullscreen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        // Set game canvas
        game = new GameCanvas(ctx, this);
        setContentView(game);
    }

}
