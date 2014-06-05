package eu.raffprta.rockfall.core.entity;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

import eu.raffprta.rockfall.app.SpriteContainer;

/**
 * Interface to specify all common Entity methods. An Abstract class will be provided
 * to implement the actual programming code in common, as well as to specify a
 * constructor set.
 */
public interface Entity extends SpriteContainer {

    /**
     * This method updates the Entity's position with x/y coordinates and respective velocities.
     */
    public void update(int x, int y, int velX, int velY);

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

    /**
     * Defines velocity for x.
     */
    public int getVelX();

    /**
     * Defines velocity for y.
     */
    public int getVelY();

    /**
     * Defines a boolean for accessing whether an object is colliding with another or not.
     */
    public boolean isCollidedWith(Entity e);

    /**
     * Define a getter to get the entity's associated collision rectangle.
     */
    public Rect getCollisionBox();

}
