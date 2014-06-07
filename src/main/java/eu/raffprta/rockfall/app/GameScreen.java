package eu.raffprta.rockfall.app;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;


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

    Paint p = new Paint(Paint.ANTI_ALIAS_FLAG);

    public void renderText(int x, int y, Canvas c, String text){
        p.setColor(Color.TRANSPARENT);
        c.drawPaint(p);
        p.setColor(Color.GRAY);
        p.setStyle(Paint.Style.FILL);
        final int FONT_SIZE = 36;
        p.setTextSize(FONT_SIZE);
        c.drawText(text, x+2, y+FONT_SIZE, p);
    }
}
