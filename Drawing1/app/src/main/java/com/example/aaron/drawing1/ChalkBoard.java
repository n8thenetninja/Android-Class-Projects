//View in which to draw to demonstrate various animations
//Written by Aaron Gordon - September, 2016

package com.example.aaron.drawing1;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;

/**
 * Created by aaron on 9/20/16.
 */
public class ChalkBoard extends View {

    public static final int RAW          =  0;  //Constant to indicate no animation - jumps to new location
    public static final int ANIMATOR     =  1;  //Constant to indicate default movement animation
    public static final int ACCELERATOR  =  2;  //Constant to indicate accelerate-at-end movement animation
    public static final int DECELERATE   =  3;  //Constant to indicate decelerate-at-end movement animation
    public static final int BOUNCE       =  4;  //Constant to indicate bounce-at-end movement animation
    public static final int ROTATE       =  5;  //Constant to indicate rotate around View center animation
    public static final int MOVE_ROTATE  =  9;  //Constant to indicate move and rotate simultaneously animation
    public static final int COLOR_ACC    = 11;  //Constant to indicate transition color animation
    public static final int MOVE_RECOLOR = 12;  //Constant to indicate move and change color simultaneously
    public static final int MOVE_ROTATE_RECOLOR = 23;  //Constant to indicate move and rotate simultaneously then recolor animation
    int displayWidth;       //width of screen - initialized in constructor
    int displayHeight;      //height of screen - initialized in constructor

    //values to define rectangle placed on screen
    float startX =  55.0f;  //left-most x-coordinate
    float width  = 300.0f;  //rectangle width
    float stopX  = startX + width;  //right-most x-coordinate
    float height = 400.0f;  //rectangle height
    float top    = 100.0f;  //y-coordinate of rectangle's top
    float bottom = top + height;  //y-coordinate of rectangle's bottom
    float deltaX = 40.0f;   //change in x to next rectangle
    float deltaY = 40.0f;   //change in y to next rectangle
    float oldX   = 0.0f;    //previous x-coordinate of rectangle NW corner
    float oldY   = 0.0f;    //previous y-coordinate of rectangle NW corner
    float x1    = startX;   //x-coordinate of rectangle NW corner used for animation
    float y1    = top;      //y-coordinate of rectangle NW corner used for animation
    float x2    = x1 + width;   //x-coordinate of rectangle SE corner used for animation
    float y2    = y1 + height;  //y-coordinate of rectangle SE corner used for animation
    float fraction = 1.0f;      //fraction of distance from old rectangle to new one at each step of animation
    float color_fraction = 1.0f;    //fraction of distance from old color to new one at each step of animation
    float angle     = 0.0f;        //angle of rotation used to animate rotations
    int curr_color  = ChalkColor.randomChalkColor().getColor();  //current color to use
    ChalkColor next_color;  //if animating color change, new color we are heading for
    ChalkColor old_color;   //last color we used
    Paint paint = new Paint();  //to hold color for rendering
    int style   = RAW;  //style holds current type of animation
    boolean color_flag = false;     //set when animating color
    boolean move_flag  = true;      //set when animation involves motion

    //Constructor - initialize this View
    public ChalkBoard(Context context) {
        super(context);
        next_color = new ChalkColor(curr_color);
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display screen = wm.getDefaultDisplay();
        Point size = new Point();
        screen.getSize(size);
        displayWidth  = size.x;
        displayHeight = size.y;
    }

    //Called from Activity when animation type is selected from menu
    public void setStyle(int s) {
        style = s;
        color_flag = s == COLOR_ACC || s == MOVE_RECOLOR || s == MOVE_ROTATE_RECOLOR;
        move_flag  = (s != ROTATE) && (s!= COLOR_ACC);
    }

    //called from main when button clicked
    //starts the animation process

    /**
     * Called from main when button clicked.
     * This method starts the animation process.
     */
    public void wander() {
        ObjectAnimator anim;    //used in may cases below
        if (move_flag) {
            oldX = startX;
            oldY = top;
            startX = (float) ((0.90 * displayWidth) * Math.random());
            deltaX = startX - oldX;
            stopX = startX + width;
            top = (float) ((0.80 * displayHeight) * Math.random());
            deltaY = top - oldY;
            bottom = top + height;
        }
        if (color_flag){
            old_color = next_color;
            next_color = ChalkColor.randomChalkColor();
        }
        switch (style) {
            case ANIMATOR:      // ObjectAnimator
                getObjectAnimator(500,"fraction", 0.0f, 1.0f).start(); //local method
                break;
            case RAW:           //no animation - just jump to spot
                fraction = 1.0f;
                step();
                break;
            case ACCELERATOR:   //Accelerate in using AccelerateInterpolator
                anim = getObjectAnimator(500,"fraction", 0.0f, 1.0f); //local method
                anim.setInterpolator(new AccelerateInterpolator(1.5f)); //try 1.5f or 0.8f
                anim.start();
                break;
            case DECELERATE:   //Deaccelerate  using AccelerateInterpolator
                anim = getObjectAnimator(500,"fraction", 0.0f, 1.0f); //local method
                anim.setInterpolator(new DecelerateInterpolator(1.5f));
                anim.start();
                break;
            case BOUNCE:   //Accelerate in using AccelerateInterpolator
                anim = getObjectAnimator(500,"fraction", 0.0f, 1.0f); //local method
                anim.setInterpolator(new BounceInterpolator());
                anim.start();
                break;
            case ROTATE:
//                anim = ObjectAnimator.ofFloat(this, "angle", 0f, 360f);
//                anim.setDuration(700);
                anim = getObjectAnimator(700, "angle", 0.0f, 360.0f);
                anim.start();
                break;
            case MOVE_ROTATE:
                ObjectAnimator moving   = getObjectAnimator(500,"fraction", 0.0f, 1.0f);
                ObjectAnimator spinner  = getObjectAnimator(700, "angle", 0.0f, 360.0f);
                moving.setDuration(800);
                spinner.setDuration(800);
                AnimatorSet spin_move    = new AnimatorSet();
                spin_move.play(moving).with(spinner);
                spin_move.start();
                break;
            case COLOR_ACC:     //Animate color change
                getObjectAnimator(800,"curr_color", 0.0f, 1.0f).start(); //local method
                break;
            case MOVE_RECOLOR:
                ObjectAnimator mover    = getObjectAnimator(500,"fraction", 0.0f, 1.0f);
                ObjectAnimator recolor  = getObjectAnimator(500,"curr_color", 0.0f, 1.0f);
                AnimatorSet together    = new AnimatorSet();
                together.play(mover).with(recolor);
                together.start();
                break;
            case MOVE_ROTATE_RECOLOR:
                ObjectAnimator moveguy      = getObjectAnimator(500,"fraction", 0.0f, 1.0f);
                ObjectAnimator recolorguy   = getObjectAnimator(500,"curr_color", 0.0f, 1.0f);
                ObjectAnimator spinguy      = getObjectAnimator(700, "angle", 0.0f, 360.0f);
                moveguy.setDuration(800);
                recolorguy.setDuration(800);
                spinguy.setDuration(800);
                AnimatorSet at_once    = new AnimatorSet();
                at_once.play(moveguy).with(spinguy);
                at_once.play(recolorguy).after(moveguy);
                at_once.start();
                break;
            default: break;
        }
    }

    /**
     * getObjectAnimator is called to build the object that controls the animation
     *
     * @param duration  milliseconds the animation should take
     * @param variable  variable to change at each step of animation
     * @param initialValue starting value for the variable
     * @param finalValue final value for the variable
     * @return the ObjectAnimator that controls the variable's changes
     */
    private ObjectAnimator getObjectAnimator(int duration, String variable, float initialValue, float finalValue) {
        ObjectAnimator animation = ObjectAnimator.ofFloat(this, variable, initialValue, finalValue);
        animation.setDuration(duration);
        //animation.setInterpolator(new AccelerateInterpolator(0.8f)); //try 1.5f
        return animation;
    }

    //

    /**
     * setFraction sets the fraction of the complete distance at each step in the animation
     * This method is called by the ObjectAnimator
     *
     * @param val the current value to use
     */
    public void setFraction(float val) {
        fraction = val;
        step();
    }

    /**
     * setCurr_color sets the fraction of the complete distance at each step in the animation
     * This method is called by the ObjectAnimator
     *
     * @param val the current value to use
     */
    public void setCurr_color(float val) {
        color_fraction = val;
        curr_color     = old_color.blend(next_color,val);
        invalidate();
    }

    //
    /**
     * setAngle sets the current angle to use for a rotation at each step in the animation
     * This method is called by the ObjectAnimator
     *
     * @param val the current value to use
     */
    public void setAngle(float val) {
        angle = val;
        this.setRotation(angle);
        invalidate();
    }

    //compute values for one step in the animation
    private void step() {
        x1    = oldX + fraction * deltaX;
        y1    = oldY + fraction * deltaY;
        x2    = x1 + width;
        y2    = y1 + height;
        invalidate();
    }

    /**
     * Renders the View
     *
     * @param canvas Where to do the rendering
     */
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(curr_color);
        canvas.drawRect(x1, y1, x2, y2, paint);
    }
}

