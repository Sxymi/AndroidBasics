package org.sxymi.androidbasics.activities.list;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.Button;

import androidx.core.app.NotificationCompat;

import org.sxymi.androidbasics.R;
import org.sxymi.androidbasics.activities.BaseActivity;
import org.sxymi.androidbasics.classes.Functions;

public class NotificationsActivity extends BaseActivity {
    private final String idNotification = "notification";
    private Button buttonToast, buttonNotification;
    private NotificationManager notificationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.initializeNotificationManager();
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_notifications;
    }

    private void initializeNotificationManager() {
        NotificationChannel channel = new NotificationChannel(this.idNotification, this.idNotification, NotificationManager.IMPORTANCE_DEFAULT);
        this.notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        this.notificationManager.createNotificationChannel(channel);
    }

    @Override
    protected void initializeControls() {
        this.buttonToast = this.findViewById(R.id.notifications_button_toast);
        this.buttonNotification = this.findViewById(R.id.notifications_button_notification);
    }

    @Override
    protected void handleControls() {
        this.buttonToast.setOnClickListener(view -> {
            Functions.sendToast(this, R.string.notifications_example_toast_content);
        });

        this.buttonNotification.setOnClickListener(view -> {
            this.sendNotification();
        });
    }

    private void sendNotification() {
        Resources resources = this.getResources();
        NotificationCompat.Builder notification = new NotificationCompat.Builder(this, this.idNotification);
        notification.setSmallIcon(R.drawable.ic_launcher_foreground);
        notification.setContentTitle(resources.getString(R.string.notifications_example_notification_title));
        notification.setContentText(resources.getString(R.string.notifications_example_notification_content));

        this.notificationManager.notify(1, notification.build());
    }
}