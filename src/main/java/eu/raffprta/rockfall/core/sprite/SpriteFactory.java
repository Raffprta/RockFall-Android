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

    private Sprite BACKGROUND;
    private Sprite MINER_STANCE_NORMAL;

    public SpriteFactory(Resources res){
        this.res = res;
        this.bg = new SpriteSheet(this.res, R.drawable.background_alpha);
        this.minerSheet = new SpriteSheet(this.res, R.drawable.miner);
    }

    public Sprite getBackground(){
        if(this.BACKGROUND == null){
           this.BACKGROUND = new Sprite(bg, "NORMAL_BG");
        }
        return this.BACKGROUND;
    }

    public Sprite getMiner(){
        if(this.MINER_STANCE_NORMAL == null){
            this.MINER_STANCE_NORMAL = new Sprite(minerSheet, 0, 0, 65, 135, "Miner Normal Stance");
        }
        return this.MINER_STANCE_NORMAL;
    }


}
