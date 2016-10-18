//This class holds colors for the ChalkBoard class
//Written by Aaron Gordon - September, 2016
package com.example.aaron.drawing1;

import android.graphics.Color;

/**
 * Created by aaron on 9/24/16.
 */
public class ChalkColor {
    int blue;    //blue component
    int red;     //red component
    int green;   //green component
    int alpha;   //alpha component
    int color;   //complete color value

    /**
     * Constructor initializes instance values
     * @param c The color used for initialization
     */
    public ChalkColor(int c) {
        color  = c;
        blue   = Color.blue(c);
        red    = Color.red(c);
        green  = Color.green(c);
        alpha  = Color.alpha(c);
    }

    public int getColor() {
        return color;
    }

    //

    /**
     * This method takes another color and returns the int representing
     * the color a fraction of the way from this color to other
     *
     * @param other The color we are heading to
     * @param fraction How far along the way we want to be
     * @return The Color at the desired point
     */
    public int blend(ChalkColor other, float fraction) {
        int r = red + (int)(fraction * (other.red - red));
        int g = green + (int)(fraction * (other.green - green));
        int b = blue + (int)(fraction * (other.blue - blue));
        int a = alpha + (int)(fraction * (other.alpha - alpha));
        return Color.argb(a,r,g,b);
    }

    /**
     * Creates a new ChalkColor object holding a random color
     * @return The created object.
     */
    public static ChalkColor randomChalkColor() {
        int c  = Color.argb(255, (int)(255 * Math.random()),
                (int)(255 * Math.random()),
                (int)(255 * Math.random()));
        return new ChalkColor(c);
    }

}
