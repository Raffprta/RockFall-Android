package eu.raffprta.rockfall.core.entity;


import eu.raffprta.rockfall.core.sprite.Sprite;
import eu.raffprta.rockfall.core.sprite.SpriteFactory;

public class EntityFactory {

    private SpriteFactory spr;

    private Entity MINER;
    private Entity POINTS_UP, POINTS_DOWN, SPEED_UP, HEART_UP, SPEED_DOWN;
    private Entity ICE_ROCK, NORMAL_ROCK, ICE_POINTED_ROCK, NORMAL_POINTED_ROCK, NORMAL_FAT_ROCK;

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

    public Entity getNormalRock(){
        if(this.NORMAL_ROCK == null){
            this.NORMAL_ROCK = new Rock(this.spr.getNormalRock(), "Normal Rock", 201, 1);
        }
        return this.NORMAL_ROCK;
    }

    public Entity getIceRock(){
        if(this.ICE_ROCK == null){
            this.ICE_ROCK = new Rock(this.spr.getIceRock(), "Ice Rock", 202, 0.5);
        }
        return this.ICE_ROCK;
    }

    public Entity getIcePointedRock(){
        if(this.ICE_POINTED_ROCK == null){
            this.ICE_POINTED_ROCK = new Rock(this.spr.getIcePointedRock(), "Ice Pointed Rock", 203, 0.5);
        }
        return this.ICE_POINTED_ROCK;
    }

    public Entity getNormalPointedRock(){
        if(this.NORMAL_POINTED_ROCK == null){
            this.NORMAL_POINTED_ROCK = new Rock(this.spr.getNormalPointedRock(), "Normal Pointed Rock", 204, 1);
        }
        return this.NORMAL_POINTED_ROCK;
    }

    public Entity getNormalFatRock(){
        if(this.NORMAL_FAT_ROCK == null){
            this.NORMAL_FAT_ROCK = new Rock(this.spr.getNormalFatRock(), "Normal Fat Rock", 205, 1);
        }
        return this.NORMAL_FAT_ROCK;
    }

}
