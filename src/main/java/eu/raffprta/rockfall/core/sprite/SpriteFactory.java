package eu.raffprta.rockfall.core.sprite;


import android.content.res.*;
import eu.raffprta.rockfall.app.R;

/**
 * Factory of usable sprites.
 */

public class SpriteFactory {

    private Resources res;
    private SpriteSheet bg;

    private Sprite BACKGROUND;

    public SpriteFactory(Resources res){
        this.res = res;
        this.bg = new SpriteSheet(this.res, R.drawable.background_alpha);
    }

    public Sprite getBackground(){
        if(BACKGROUND == null){
           this.BACKGROUND = new Sprite(bg, "NORMAL_BG");
        }
        return BACKGROUND;
    }


}
