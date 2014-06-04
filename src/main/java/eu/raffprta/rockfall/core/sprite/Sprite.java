package eu.raffprta.rockfall.core.sprite;

import android.graphics.Bitmap;

/**
 * A class resembling a Sprite object, which can be affixed to objects
 * that are SpriteContainers (like Entities and Tiles)
 * This class allows Sprite factories to use SpriteSheet objects to load
 * whole or partial images.
 * @author Raffaello Perrotta
 *
 */

public class Sprite {

    private SpriteSheet s;
    private int col;
    private int row;
    private int cellWidth;
    private int cellHeight;
    private final String NAME;
    private boolean isWhole;

    public Sprite(SpriteSheet s, int col, int row, int cellWidth, int cellHeight, final String NAME){
        this.s = s;
        this.col = col;
        this.row = row;
        this.cellWidth = cellWidth;
        this.cellHeight = cellHeight;
        this.NAME = NAME;
        this.isWhole = false;
    }

    public Sprite(SpriteSheet s, final String NAME){
        this.s = s;
        this.NAME = NAME;
        this.isWhole = true;
    }

    public Bitmap getSprite(){
        if(this.isWhole)
            return getWholeImage();
        return getPartialImage();
    }

    public Bitmap getPartialImage(){
        return s.getCell(this.col, this.row, this.cellWidth, this.cellHeight);
    }

    public Bitmap getWholeImage(){
        return s.getWhole();
    }

    public String toString(){
        return this.NAME;
    }

}
