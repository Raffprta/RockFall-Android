package eu.raffprta.rockfall.core.entity;


import eu.raffprta.rockfall.core.sprite.Sprite;
import eu.raffprta.rockfall.core.sprite.SpriteFactory;

public class EntityFactory {

    private SpriteFactory spr;

    private Entity MINER;

    public EntityFactory(SpriteFactory spr){
        this.spr = spr;
    }

    public Entity getMiner(int startX, int startY){
        if(MINER == null){
            this.MINER = new Protagonist(this.spr.getMiner(), "Miner", 1, startX, startY);
        }
        return MINER;
    }

}
