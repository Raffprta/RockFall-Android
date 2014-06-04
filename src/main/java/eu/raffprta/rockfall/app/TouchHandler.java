package eu.raffprta.rockfall.app;


import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class TouchHandler implements View.OnTouchListener {

    private int x,y;

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        this.x = Math.round(motionEvent.getX());
        this.y = Math.round(motionEvent.getY());
        return false;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }
}
