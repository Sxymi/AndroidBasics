package org.sxymi.androidbasics.classes;

import android.content.Context;
import android.content.Intent;

public class Functions {
    public static void goToActivity(Context context, Class<?> target) {
        if (context == null || target == null) {
            return;
        }

        Intent intent = new Intent(context, target);
        context.startActivity(intent);
    }
}
