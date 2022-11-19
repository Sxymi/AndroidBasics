package org.sxymi.androidbasics.classes;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class Functions {
    public static void goToActivity(Context context, Class<?> target) {
        if (context == null || target == null) {
            return;
        }

        Intent intent = new Intent(context, target);
        context.startActivity(intent);
    }

    public static void sendToast(Context context, String message) {
        if (context == null || message == null) {
            return;
        }

        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
}
