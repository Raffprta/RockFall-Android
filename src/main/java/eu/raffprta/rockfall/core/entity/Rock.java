package eu.raffprta.rockfall.core.entity;


import android.graphics.Canvas;

import eu.raffprta.rockfall.core.sprite.Sprite;

public class Rock extends AbstractEntity{

    private int damageLevel;

    public Rock(Sprite s, String name, int id, int damageLevel){
        super(s, name, id);
        this.damageLevel = damageLevel;
    }

    @Override
    public void update(Canvas c, int x, int y) {
        // TODO
    }
}
