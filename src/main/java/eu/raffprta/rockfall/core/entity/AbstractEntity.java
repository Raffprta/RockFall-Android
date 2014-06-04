package eu.raffprta.rockfall.core.entity;

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

    public Sprite getSprite(){
        return this.s;
    }

    public int getId(){
        return this.id;
    }

    public String toString(){
        return this.name;
    }

}
