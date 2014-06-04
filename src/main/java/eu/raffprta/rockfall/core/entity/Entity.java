package eu.raffprta.rockfall.core.entity;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import eu.raffprta.rockfall.app.SpriteContainer;

/**
 * Interface to specify all common Entity methods. An Abstract class will be provided
 * to implement the actual programming code in common, as well as to specify a
 * constructor set.
 */
public interface Entity extends SpriteContainer {

    /**
     * This method updates the Entity's position with x/y coordinates.
     */
    public void update(int x, int y);

    /**
     * Defines a method for retrieving the physical bitmap sprite.
     */
    public Bitmap getSprite();

    /**
     * Defines a getter for the x coordinate.
     */
    public int getX();

    /**
     * defines a getter for the y coordinate.
     */
    public int getY();

}
