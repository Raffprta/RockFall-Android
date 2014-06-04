package eu.raffprta.rockfall.core.entity;


import android.graphics.Canvas;

import eu.raffprta.rockfall.core.sprite.Sprite;

public class Rock extends AbstractEntity implements Fallable{

    private int damageLevel;
    private int x,y, velX, velY;

    public Rock(Sprite s, String name, int id, int damageLevel){
        super(s, name, id);
        this.damageLevel = damageLevel;
    }

    @Override
    public void update(int x, int y, int velX, int velY) {
        this.x = x;
        this.y = y;
        this.velX = velX;
        this.velY = velY;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    @Override
    public int getVelX() {
        return this.velX;
    }

    @Override
    public int getVelY() {
        return this.velY;
    }
}
