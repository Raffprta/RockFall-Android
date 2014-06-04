package eu.raffprta.rockfall.core.entity;

import android.graphics.Bitmap;

import java.util.LinkedList;
import java.util.List;

import eu.raffprta.rockfall.core.sprite.*;

/**
 * Class to provide partial implementation of the Entity interface.
 */
public abstract class AbstractEntity implements Entity{

    // For now this List is only for cataloging purposes
    List<Integer> l = new LinkedList<Integer>();

    private Sprite s;
    private int id;
    private String name;

    public AbstractEntity(Sprite s, String name, int id){
        this.s = s;
        this.name = name;
        this.id = id;
        // Catalog the Ids
        l.add(new Integer(id));
    }

    public Bitmap getSprite(){
        return this.s.getSprite();
    }

    public int getId(){
        return this.id;
    }

    public String toString(){
        return this.name;
    }

    public abstract int getX();
    public abstract int getY();
    public abstract int getVelX();
    public abstract int getVelY();

}
