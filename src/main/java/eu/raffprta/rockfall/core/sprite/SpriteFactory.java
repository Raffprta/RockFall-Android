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
    private SpriteSheet minerSheet;
    private SpriteSheet powerSheet;
    private SpriteSheet icoSheet;

    private Sprite BACKGROUND;
    private Sprite MINER_STANCE_NORMAL;
    private Sprite POINTS_UP,POINTS_DOWN,SPEED_UP,HEART_UP,SPEED_DOWN;
    private Sprite ICO_HEART_FULL, ICO_HEART_HALF, ICO_HEART_NONE;

    public SpriteFactory(Resources res){
        this.res = res;
        this.bg = new SpriteSheet(this.res, R.drawable.background_alpha);
        this.minerSheet = new SpriteSheet(this.res, R.drawable.miner);
        this.powerSheet = new SpriteSheet(this.res, R.drawable.powers);
        this.icoSheet = new SpriteSheet(this.res, R.drawable.icos);
    }

    public Sprite getBackground(){
        if(this.BACKGROUND == null){
           this.BACKGROUND = new Sprite(bg, "NORMAL_BG");
        }
        return this.BACKGROUND;
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

}
