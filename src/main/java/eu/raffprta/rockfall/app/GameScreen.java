package eu.raffprta.rockfall.app;

import android.graphics.Canvas;
import android.media.Image;

/**
 * Class that handles what is drawn on the screen - it
 * basically acts as a very simple 2D rendering engine of pixels
 * @author Raffaello Perrotta
 *
 */

public class GameScreen {

    private int width, height;

    public GameScreen(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void render(int x, int y, Canvas c, SpriteContainer s) {
        c.drawBitmap(s.getSprite(), x, y, null);
    }
}
