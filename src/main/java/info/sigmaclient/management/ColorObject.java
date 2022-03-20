package info.sigmaclient.management;

import info.sigmaclient.management.command.impl.Color;
import info.sigmaclient.util.render.Colors;

/**
 * Created by cool1 on 3/7/2017.
 */
public class ColorObject {

    public int red;
    public int green;
    public int blue;
    public int alpha;

    public ColorObject(int red, int green, int blue, int alpha) {
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.alpha = alpha;
    }

    public int getRed() {
        return red;
    }

    public void setRed(int red) {
        this.red = red;
        Color.saveStatus();
    }

    public int getGreen() {
        return green;
    }

    public void setGreen(int green) {
        this.green = green;
        Color.saveStatus();
    }

    public int getBlue() {
        return blue;
    }

    public void setBlue(int blue) {
        this.blue = blue;
        Color.saveStatus();
    }

    public int getAlpha() {
        return alpha;
    }

    public void setAlpha(int alpha) {
        this.alpha = alpha;
        Color.saveStatus();
    }

    public int getColorInt() {
        return Colors.getColor(red, green, blue, alpha);
    }

    public void updateColors(int red, int green, int blue, int alpha) {
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.alpha = alpha;
        Color.saveStatus();
    }

}
