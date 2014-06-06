package eu.raffprta.rockfall.app;


import android.util.Log;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;

public class TouchHandler implements View.OnTouchListener {

    private int x,y;
    private boolean isActivated = false;

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        this.x = Math.round(motionEvent.getX());
        this.y = Math.round(motionEvent.getY());
        if(motionEvent.getAction() == motionEvent.ACTION_DOWN){
            isActivated = true;
        }
        else if(motionEvent.getAction() == motionEvent.ACTION_UP ) {
            isActivated = false;
        }
        return false;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public boolean isActivated(){
        return this.isActivated;
    }


}
