package eu.raffprta.rockfall.core.entity;


import eu.raffprta.rockfall.core.sprite.Sprite;
import eu.raffprta.rockfall.core.sprite.SpriteFactory;

public class EntityFactory {

    private SpriteFactory spr;


    public EntityFactory(SpriteFactory spr){
        this.spr = spr;
    }

    public Entity getMiner(int startX, int startY, int velX, int velY){
        return  new Protagonist(this.spr.getMiner(), "Miner", 1, startX, startY, velX, velY);
    }

    public Entity getPointsUp(int startX, int startY, int velX, int velY){
        return  new Powerup(this.spr.getPointsUp(), "Points Up", 101, startX, startY, velX, velY);
    }

    public Entity getPointsDown(int startX, int startY, int velX, int velY){
        return  new Powerup(this.spr.getPointsDown(), "Points Down", 102, startX, startY, velX, velY);
    }

    public Entity getSpeedUp(int startX, int startY, int velX, int velY){
        return  new Powerup(this.spr.getSpeedUp(), "Speed Up", 103, startX, startY, velX, velY);
    }

    public Entity getHeartUp(int startX, int startY, int velX, int velY){
        return  new Powerup(this.spr.getHeartUp(), "Heart Up", 104, startX, startY, velX, velY);
    }

    public Entity getSpeedDown(int startX, int startY, int velX, int velY){
        return  new Powerup(this.spr.getSpeedDown(), "Speed Down", 105, startX, startY, velX, velY);
    }

    public Entity getNormalRock(int startX, int startY, int velX, int velY){
        return new Rock(this.spr.getNormalRock(), "Normal Rock", 201,startX, startY, velX, velY, 1);
    }

    public Entity getIceRock(int startX, int startY, int velX, int velY){
        return new Rock(this.spr.getIceRock(), "Ice Rock", 202, startX, startY, velX, velY, 0.5);
    }

    public Entity getIcePointedRock(int startX, int startY, int velX, int velY){
        return new Rock(this.spr.getIcePointedRock(), "Ice Pointed Rock", 203, startX, startY, velX, velY, 0.5);
    }

    public Entity getNormalPointedRock(int startX, int startY, int velX, int velY){
        return new Rock(this.spr.getNormalPointedRock(), "Normal Pointed Rock", 204, startX, startY, velX, velY, 1);
    }

    public Entity getNormalFatRock(int startX, int startY, int velX, int velY){
        return new Rock(this.spr.getNormalFatRock(), "Normal Fat Rock", 205, startX, startY, velX, velY, 1);
    }

    public Entity getNoobKitty(int startX, int startY, int velX, int velY){
        return new Rock(this.spr.getNoobKitty(), "Noob Kitty", 206, startX, startY, velX, velY, 2);
    }

}
