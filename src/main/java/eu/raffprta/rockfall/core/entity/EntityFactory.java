package eu.raffprta.rockfall.core.entity;


import eu.raffprta.rockfall.core.sprite.Sprite;
import eu.raffprta.rockfall.core.sprite.SpriteFactory;

public class EntityFactory {

    private SpriteFactory spr;

    private Entity MINER;
    private Entity POINTS_UP, POINTS_DOWN, SPEED_UP, HEART_UP, SPEED_DOWN;

    public EntityFactory(SpriteFactory spr){
        this.spr = spr;
    }

    public Entity getMiner(int startX, int startY){
        if(this.MINER == null){
            this.MINER = new Protagonist(this.spr.getMiner(), "Miner", 1, startX, startY);
        }
        return MINER;
    }

    public Entity getPointsUp(){
        if(this.POINTS_UP == null){
            this.POINTS_UP = new Powerup(this.spr.getPointsUp(), "Points Up", 101);
        }
        return POINTS_UP;
    }

    public Entity getPointsDown(){
        if(this.POINTS_DOWN == null){
            this.POINTS_DOWN = new Powerup(this.spr.getPointsDown(), "Points Down", 102);
        }
        return this.POINTS_DOWN;
    }

    public Entity getSpeedUp(){
        if(this.SPEED_UP == null){
            this.SPEED_UP = new Powerup(this.spr.getSpeedUp(), "Speed Up", 103);
        }
        return this.getPointsDown();
    }

    public Entity getHeartUp(){
        if(this.HEART_UP == null){
            this.HEART_UP = new Powerup(this.spr.getHeartUp(), "Heart Up", 104);
        }
        return this.HEART_UP;
    }

    public Entity getSpeedDown(){
        if(this.SPEED_DOWN == null){
            this.SPEED_DOWN = new Powerup(this.spr.getSpeedDown(), "Speed Down", 105);
        }
        return this.SPEED_DOWN;
    }

}
