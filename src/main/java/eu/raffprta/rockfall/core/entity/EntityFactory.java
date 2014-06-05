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

    public Entity getPointsUp(int startX, int startY){
        if(this.POINTS_UP == null){
            this.POINTS_UP = new Powerup(this.spr.getPointsUp(), "Points Up", 101, startX, startY);
        }
        return POINTS_UP;
    }

    public Entity getPointsDown(int startX, int startY){
        if(this.POINTS_DOWN == null){
            this.POINTS_DOWN = new Powerup(this.spr.getPointsDown(), "Points Down", 102, startX, startY);
        }
        return this.POINTS_DOWN;
    }

    public Entity getSpeedUp(int startX, int startY){
        if(this.SPEED_UP == null){
            this.SPEED_UP = new Powerup(this.spr.getSpeedUp(), "Speed Up", 103, startX, startY);
        }
        return this.SPEED_UP;
    }

    public Entity getHeartUp(int startX, int startY){
        if(this.HEART_UP == null){
            this.HEART_UP = new Powerup(this.spr.getHeartUp(), "Heart Up", 104, startX, startY);
        }
        return this.HEART_UP;
    }

    public Entity getSpeedDown(int startX, int startY){
        if(this.SPEED_DOWN == null){
            this.SPEED_DOWN = new Powerup(this.spr.getSpeedDown(), "Speed Down", 105, startX, startY);
        }
        return this.SPEED_DOWN;
    }

    public Entity getNormalRock(int startX, int startY){
        if(this.NORMAL_ROCK == null){
            this.NORMAL_ROCK = new Rock(this.spr.getNormalRock(), "Normal Rock", 201,startX, startY, 1);
        }
        return this.NORMAL_ROCK;
    }

    public Entity getIceRock(int startX, int startY){
        if(this.ICE_ROCK == null){
            this.ICE_ROCK = new Rock(this.spr.getIceRock(), "Ice Rock", 202, startX, startY, 0.5);
        }
        return this.ICE_ROCK;
    }

    public Entity getIcePointedRock(int startX, int startY){
        if(this.ICE_POINTED_ROCK == null){
            this.ICE_POINTED_ROCK = new Rock(this.spr.getIcePointedRock(), "Ice Pointed Rock", 203, startX, startY, 0.5);
        }
        return this.ICE_POINTED_ROCK;
    }

    public Entity getNormalPointedRock(int startX, int startY){
        if(this.NORMAL_POINTED_ROCK == null){
            this.NORMAL_POINTED_ROCK = new Rock(this.spr.getNormalPointedRock(), "Normal Pointed Rock", 204, startX, startY, 1);
        }
        return this.NORMAL_POINTED_ROCK;
    }

    public Entity getNormalFatRock(int startX, int startY){
        if(this.NORMAL_FAT_ROCK == null){
            this.NORMAL_FAT_ROCK = new Rock(this.spr.getNormalFatRock(), "Normal Fat Rock", 205, startX, startY, 1);
        }
        return this.NORMAL_FAT_ROCK;
    }

}
