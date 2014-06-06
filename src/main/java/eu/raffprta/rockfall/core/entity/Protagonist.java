package eu.raffprta.rockfall.core.entity;


import android.graphics.Canvas;
import android.graphics.Rect;

import eu.raffprta.rockfall.core.sprite.Sprite;

public class Protagonist extends AbstractEntity{

    // A default value.
    private double lives = 3.0f;

    public Protagonist(Sprite s, String name, FallableType id, int x, int y, int velX, int velY){
        super(s, name, id, x, y, velX, velY);
    }

    @Override
    public void update(int x, int y, int velX, int velY) {
        super.update(x,y,velX,velY);
    }

    public int getX(){
        return super.getX();
    }

    public int getY(){
        return super.getY();
    }

    @Override
    public int getVelX() {
        return super.getVelX();
    }

    @Override
    public int getVelY() {
        return super.getVelY();
    }

    public double getLives(){ return this.lives; }

    public void setLives(double lives){this.lives = lives;}

    public boolean isCollidedWith(Entity e){
        return super.isCollidedWith(e);
    }

}
