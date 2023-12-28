package net.braniumacademy.exercises1;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;

import java.text.DecimalFormat;

public class Utils {
    public static final String EXTRA_COUNTRY_INDEX = "EXTRA_COUNTRY_INDEX";

    @SuppressLint("UseCompatLoadingForDrawables")
    public static Drawable getDrawable(Context context, String drawableName) {
        int id = context.getResources().getIdentifier(
                drawableName.split("[.]")[0],
                "drawable", context.getPackageName()
        );
        if (id != 0) {
            return context.getResources().getDrawable(id);
        } else {
            return context.getDrawable(R.drawable.vietnam);
        }
    }

    public static String getNumberFormatted(float number) {
        DecimalFormat formatter = new DecimalFormat("#,###.#");
        return formatter.format(number);
    }
}
