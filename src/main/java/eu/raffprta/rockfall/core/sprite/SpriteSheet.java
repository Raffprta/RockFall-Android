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

    // This is the value used in the grid of our spritesheet - so it is to be ignored when loading
    private final int MAGIC_IGNORE = -20791;

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

        for(int i = 0; i < cellWidth; i++){
            for(int j = 0; j < cellHeight; j++){
                if(subImg.getPixel(i, j) == MAGIC_IGNORE){
                    subImg.setPixel(i, j, 0);
                }
            }
        }

        return subImg;

    }



}
