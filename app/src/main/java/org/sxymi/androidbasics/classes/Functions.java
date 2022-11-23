package org.sxymi.androidbasics.classes;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import org.sxymi.androidbasics.activities.BaseActivity;

public class Functions {
    public static void goToActivity(Context context, Class<?> target) {
        Functions.goToActivity(context, target, null);
    }

    public static void goToActivity(Context context, Class<?> target, Bundle bundle) {
        if (context == null || target == null) {
            return;
        }

        Intent intent = new Intent(context, target);
        if (bundle != null && !bundle.isEmpty()) {
            intent.putExtra(BaseActivity.BUNDLE_KEY, bundle);
        }

        context.startActivity(intent);
    }

    public static void sendToast(Context context, int idString) {
        Functions.sendToast(context, context.getResources().getString(idString));
    }

    public static void sendToast(Context context, String message) {
        if (context == null || message == null) {
            return;
        }

        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    public static boolean isEditTextEmpty(EditText editText) {
        if (editText == null) {
            return true;
        }

        return "".equals(editText.getText().toString());
    }

    // TODO: Funkcja walidująca editText z tostem od razu?
}
