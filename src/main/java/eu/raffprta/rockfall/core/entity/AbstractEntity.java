package eu.raffprta.rockfall.core.entity;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.Log;

import java.util.LinkedList;
import java.util.List;

import eu.raffprta.rockfall.core.sprite.*;

/**
 * Class to provide partial implementation of the Entity interface.
 */
public abstract class AbstractEntity implements Entity{

    private Sprite s;
    private FallableType id;
    private String name;
    private int x,y, velX, velY;

    private Rect collisionBox;

    public AbstractEntity(Sprite s, String name, FallableType id, int x, int y, int velX, int velY){
        this.s = s;
        this.name = name;
        this.id = id;
        this.x = x;
        this.y = y;
        this.velX = velX;
        this.velY = velY;
        // Add the collision box
        collisionBox = new Rect(x,y,x+s.getSprite().getWidth(),y+s.getSprite().getHeight());
    }

    public Bitmap getSprite(){
        return this.s.getSprite();
    }

    public FallableType getId(){
        return this.id;
    }

    public String toString(){
        return this.name;
    }

    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }
    public int getVelX(){
        return this.velX;
    }
    public int getVelY(){
        return this.velY;
    }

    public void update(int x, int y, int velX, int velY){
        this.x = x + velX;
        this.y = y + velY;
        this.velX = velX;
        this.velY = velY;
        this.collisionBox.set(x,y,x+s.getSprite().getWidth(),y+s.getSprite().getHeight());
    }

    public Rect getCollisionBox(){
        return this.collisionBox;
    }

    public boolean isCollidedWith(Entity e){
        return this.getCollisionBox().intersect(e.getCollisionBox());
    }

}
