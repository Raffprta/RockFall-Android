package eu.raffprta.rockfall.core.sprite;

import android.util.Log;
import android.content.res.*;
import android.graphics.*;

/**
 * This class resembles a SpriteSheet object -
 * though, a small misnomer as we also have methods
 * that concern itself with loading the full image
 * where it's more plausible to do so!
 * @author Raffaello Perrotta
 *
 */

public class SpriteSheet{

    private Resources res;
    private int id;


    public SpriteSheet(Resources res, int id){
        this.res = res;
        this.id = id;
    }

    /**
     *
     * @return the whole image, relating to an image file
     */

    protected Bitmap getWhole(){
        Bitmap img = BitmapFactory.decodeResource(this.res, this.id);
        return img;
    }


    /**
     * Gets a tranche of the SpriteSheet based on the parameters.
     */

    protected Bitmap getCell(int col, int row, int cellWidth, int cellHeight){
        Bitmap img = BitmapFactory.decodeResource(this.res, this.id);
        Bitmap subImg = img.createBitmap(img, col*cellWidth, row*cellHeight, cellWidth, cellHeight);
        return subImg;

    }



}
