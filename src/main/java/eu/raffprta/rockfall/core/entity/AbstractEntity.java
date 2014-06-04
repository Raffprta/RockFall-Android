package eu.raffprta.rockfall.core.entity;

import android.graphics.Bitmap;

import eu.raffprta.rockfall.app.SpriteContainer;
import eu.raffprta.rockfall.core.sprite.*;

/**
 * Class to provide partial implementation of the Entity interface.
 */
public abstract class AbstractEntity implements Entity{

    private Sprite s;
    private int id;
    private String name;

    public AbstractEntity(Sprite s, String name, int id){
        this.s = s;
        this.name = name;
        this.id = id;
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

}
