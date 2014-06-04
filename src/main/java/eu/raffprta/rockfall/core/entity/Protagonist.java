package eu.raffprta.rockfall.core.entity;


import android.graphics.Canvas;

import eu.raffprta.rockfall.core.sprite.Sprite;

public class Protagonist extends AbstractEntity{

    private int x,y, velX, velY;
    // A default value.
    private double lives = 3.0f;

    public Protagonist(Sprite s, String name, int id, int x, int y){
        super(s, name, id);
        this.x = x;
        this.y = y;
    }

    @Override
    public void update(int x, int y, int velX, int velY) {
        this.x = x + velX;
        this.y = y + velY;
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

    public double getLives(){ return this.lives; }

    public void setLives(double lives){this.lives = lives;}
}
