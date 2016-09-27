/******
 * **
 * Description: This class will be used to create an image in the text edit
 * Reference: http://stackoverflow.com/questions/19788386/set-unchangeable-some-part-of-edittext-android
 */
package calc.uplift.com.fueluplift;

import android.graphics.drawable.Drawable;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Color;
import android.graphics.PixelFormat;

/**
 * Created by User on 2016-09-26.
 */
public class Drawable_int extends Drawable {

    private final String text;
    private final Paint paint;
    private final int font_size;

    public Drawable_int(String text, float font_size) {
        this.text = text;
        this.paint = new Paint();
        this.font_size = (int)font_size;
        paint.setColor(Color.BLACK);
        paint.setTextSize(font_size);
        paint.setAntiAlias(true);
        paint.setTextAlign(Paint.Align.LEFT);
    }
    public void draw(Canvas canvas) {
        canvas.drawText(text, 0, 20, paint);
    }

    @Override
    public void setAlpha(int alpha) {
        paint.setAlpha(alpha);
    }

    @Override
    public void setColorFilter(ColorFilter cf) {
        paint.setColorFilter(cf);
    }

    @Override
    public int getOpacity() {
        return PixelFormat.TRANSLUCENT;
    }
}