package eu.raffprta.rockfall.core.entity;


import android.graphics.Canvas;

import eu.raffprta.rockfall.core.sprite.Sprite;

public class Rock extends AbstractEntity{

    private int damageLevel;
    private int x,y;

    public Rock(Sprite s, String name, int id, int damageLevel){
        super(s, name, id);
        this.damageLevel = damageLevel;
    }

    @Override
    public void update(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }
}
