package eu.raffprta.rockfall.core.entity;

import android.graphics.Canvas;

/**
 * Interface to specify all common Entity methods. An Abstract class will be provided
 * to implement the actual programming code in common, as well as to specify a
 * constructor set.
 */
public interface Entity {

    /**
     * This method updates the Entity's position with x/y coordinates.
     * The canvas object is the canvas where said character will be rendered to.
     */
    public void update(Canvas c, int x, int y);

}
