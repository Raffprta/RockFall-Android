package eu.raffprta.rockfall.core.entity;


import android.graphics.Canvas;

import eu.raffprta.rockfall.core.sprite.Sprite;

public class Protagonist extends AbstractEntity{

    private int x,y;

    public Protagonist(Sprite s, String name, int id, int x, int y){
        super(s, name, id);
        this.x = x;
        this.y = y;
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
