package eu.raffprta.rockfall.core.entity;


import android.graphics.Canvas;

import eu.raffprta.rockfall.core.sprite.Sprite;

public class Rock extends AbstractEntity implements Fallable{

    private double damageLevel;

    public Rock(Sprite s, String name, FallableType id, int x, int y, int velX, int velY ,double damageLevel){
        super(s, name, id, x, y, velX, velY);
        this.damageLevel = damageLevel;
    }

    @Override
    public void update(int x, int y, int velX, int velY) {
        super.update(x, y, velX, velY);
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

    public boolean isCollidedWith(Entity e){
        return false;
    }

    public double getDamageLevel(){
        return this.damageLevel;
    }

}
