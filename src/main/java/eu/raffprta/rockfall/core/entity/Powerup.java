package eu.raffprta.rockfall.core.entity;

import eu.raffprta.rockfall.core.sprite.Sprite;


public class Powerup extends AbstractEntity implements Fallable{

    private int x,y;

    public Powerup(Sprite s, String name, int id){
        super(s, name, id);
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
