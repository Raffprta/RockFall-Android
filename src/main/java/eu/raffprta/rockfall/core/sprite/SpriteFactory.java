package eu.raffprta.rockfall.core.sprite;


import android.content.res.*;
import android.util.Log;

import eu.raffprta.rockfall.app.R;

/**
 * Factory of usable sprites.
 */

public class SpriteFactory {

    private Resources res;
    private SpriteSheet bg;
    private SpriteSheet kitty;
    private SpriteSheet minerSheet;
    private SpriteSheet powerSheet;
    private SpriteSheet icoSheet;
    private SpriteSheet basicRocks;
    private SpriteSheet pointedRocks;
    private SpriteSheet fatRocks;

    private Sprite BACKGROUND, NOOB_KITTY;
    private Sprite MINER_STANCE_NORMAL;
    private Sprite POINTS_UP,POINTS_DOWN,SPEED_UP,HEART_UP,SPEED_DOWN;
    private Sprite ICO_HEART_FULL, ICO_HEART_HALF, ICO_HEART_NONE;
    private Sprite ICE_ROCK, NORMAL_ROCK, ICE_POINTED_ROCK, NORMAL_POINTED_ROCK, NORMAL_FAT_ROCK;

    public SpriteFactory(Resources res){
        this.res = res;
        this.bg = new SpriteSheet(this.res, R.drawable.background_alpha);
        this.minerSheet = new SpriteSheet(this.res, R.drawable.miner);
        this.powerSheet = new SpriteSheet(this.res, R.drawable.powers);
        this.icoSheet = new SpriteSheet(this.res, R.drawable.icos);
        this.basicRocks = new SpriteSheet(this.res, R.drawable.basic_rocks);
        this.pointedRocks = new SpriteSheet(this.res, R.drawable.pointed_rocks);
        this.fatRocks = new SpriteSheet(this.res, R.drawable.fat_rocks);
        this.kitty = new SpriteSheet(this.res, R.drawable.noob_kitty);
    }

    public Sprite getBackground(){
        if(this.BACKGROUND == null){
           this.BACKGROUND = new Sprite(bg, "Normal Background");
        }
        return this.BACKGROUND;
    }

    public Sprite getNoobKitty(){
        if(this.NOOB_KITTY == null){
            this.NOOB_KITTY = new Sprite(kitty, "Noob Kitty");
        }
        return this.NOOB_KITTY;
    }

    public Sprite getMiner(){
        if(this.MINER_STANCE_NORMAL == null){
            this.MINER_STANCE_NORMAL = new Sprite(minerSheet, 0, 0, 65, 133, "Miner Normal Stance");
        }
        return this.MINER_STANCE_NORMAL;
    }

    public Sprite getPointsUp(){
        if(this.POINTS_UP == null){
            this.POINTS_UP = new Sprite(powerSheet, 0, 0, 71, 71, "Points Up");
        }
        return this.POINTS_UP;
    }
    public Sprite getPointsDown(){
        if(this.POINTS_DOWN == null){
            this.POINTS_DOWN = new Sprite(powerSheet, 1, 0, 71, 71, "Points Down");
        }
        return this.POINTS_DOWN;
    }

    public Sprite getSpeedUp(){
        if(this.SPEED_UP == null){
            this.SPEED_UP = new Sprite(powerSheet, 2, 0, 71, 71, "Speed Up");
        }
        return this.SPEED_UP;
    }

    public Sprite getSpeedDown(){
        if(this.SPEED_DOWN == null){
            this.SPEED_DOWN = new Sprite(powerSheet, 4, 0, 71, 71, "Speed Down");
        }
        return this.SPEED_DOWN;
    }

    public Sprite getHeartUp(){
        if(this.HEART_UP == null){
            this.HEART_UP = new Sprite(powerSheet, 3, 0 , 71, 71, "Heart Up");
        }
        return this.HEART_UP;
    }

    public Sprite getHeartFull(){
        if(this.ICO_HEART_FULL == null){
            this.ICO_HEART_FULL = new Sprite(icoSheet, 2, 0, 35, 35, "Full Heart");
        }
        return this.ICO_HEART_FULL;
    }

    public Sprite getHeartHalf(){
        if(this.ICO_HEART_HALF == null){
            this.ICO_HEART_HALF = new Sprite(icoSheet, 1, 0, 35, 35, "Half Heart");
        }
        return this.ICO_HEART_HALF;
    }

    public Sprite getHeartNone(){
        if(this.ICO_HEART_NONE == null){
            this.ICO_HEART_NONE = new Sprite(icoSheet, 0, 0, 35, 35, "No Heart");
        }
        return this.ICO_HEART_NONE;
    }

    public Sprite getIceRock(){
        if(this.ICE_ROCK == null){
            this.ICE_ROCK = new Sprite(basicRocks, 0, 0, 82, 82, "Ice Rock");
        }
        return this.ICE_ROCK;
    }

    public Sprite getNormalRock(){
        if(this.NORMAL_ROCK == null){
            this.NORMAL_ROCK = new Sprite(basicRocks, 1, 0, 82, 82, "Normal Rock");
        }
        return this.NORMAL_ROCK;
    }

    public Sprite getNormalPointedRock(){
        if(this.NORMAL_POINTED_ROCK == null){
            this.NORMAL_POINTED_ROCK = new Sprite(pointedRocks, 0, 0, 58, 90, "Normal Pointed Rock");
        }
        return this.NORMAL_POINTED_ROCK;
    }

    public Sprite getIcePointedRock(){
        if(this.ICE_POINTED_ROCK == null){
            this.ICE_POINTED_ROCK = new Sprite(pointedRocks, 1, 0, 58, 90, "Ice Pointed Rock");
        }
        return this.ICE_POINTED_ROCK;
    }

    public Sprite getNormalFatRock(){
        if(this.NORMAL_FAT_ROCK == null){
            this.NORMAL_FAT_ROCK = new Sprite(fatRocks, 0, 0, 175, 90, "Fat Normal Rock");
        }
        return this.NORMAL_FAT_ROCK;
    }

}
