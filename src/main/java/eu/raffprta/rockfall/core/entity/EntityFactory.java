package eu.raffprta.rockfall.core.entity;


import eu.raffprta.rockfall.core.sprite.Sprite;
import eu.raffprta.rockfall.core.sprite.SpriteFactory;

public class EntityFactory {

    private SpriteFactory spr;


    public EntityFactory(SpriteFactory spr){
        this.spr = spr;
    }

    public Entity getMiner(int startX, int startY, int velX, int velY){
        return  new Protagonist(this.spr.getMiner(), "Miner", FallableType.OTHER, startX, startY, velX, velY);
    }

    public Entity getPointsUp(int startX, int startY, int velX, int velY){
        return  new Powerup(this.spr.getPointsUp(), "Points Up", FallableType.POINTS_UP, startX, startY, velX, velY);
    }

    public Entity getPointsDown(int startX, int startY, int velX, int velY){
        return  new Powerup(this.spr.getPointsDown(), "Points Down", FallableType.POINTS_DOWN, startX, startY, velX, velY);
    }

    public Entity getSpeedUp(int startX, int startY, int velX, int velY){
        return  new Powerup(this.spr.getSpeedUp(), "Speed Up", FallableType.SPEED_UP, startX, startY, velX, velY);
    }

    public Entity getHeartUp(int startX, int startY, int velX, int velY){
        return  new Powerup(this.spr.getHeartUp(), "Heart Up", FallableType.HEART_UP, startX, startY, velX, velY);
    }

    public Entity getSpeedDown(int startX, int startY, int velX, int velY){
        return  new Powerup(this.spr.getSpeedDown(), "Speed Down", FallableType.SPEED_DOWN, startX, startY, velX, velY);
    }

    public Entity getNormalRock(int startX, int startY, int velX, int velY){
        return new Rock(this.spr.getNormalRock(), "Normal Rock", FallableType.NORMAL_ROCK,startX, startY, velX, velY, 1);
    }

    public Entity getIceRock(int startX, int startY, int velX, int velY){
        return new Rock(this.spr.getIceRock(), "Ice Rock", FallableType.ICE_ROCK, startX, startY, velX, velY, 0.5);
    }

    public Entity getIcePointedRock(int startX, int startY, int velX, int velY){
        return new Rock(this.spr.getIcePointedRock(), "Ice Pointed Rock", FallableType.ICE_POINTED_ROCK, startX, startY, velX, velY, 0.5);
    }

    public Entity getNormalPointedRock(int startX, int startY, int velX, int velY){
        return new Rock(this.spr.getNormalPointedRock(), "Normal Pointed Rock", FallableType.NORMAL_POINTED_ROCK, startX, startY, velX, velY, 1);
    }

    public Entity getNormalFatRock(int startX, int startY, int velX, int velY){
        return new Rock(this.spr.getNormalFatRock(), "Normal Fat Rock", FallableType.NORMAL_FAT_ROCK, startX, startY, velX, velY, 1);
    }

    public Entity getNoobKitty(int startX, int startY, int velX, int velY){
        return new Rock(this.spr.getNoobKitty(), "Noob Kitty", FallableType.NOOB_KITTY, startX, startY, velX, velY, 2);
    }

}
