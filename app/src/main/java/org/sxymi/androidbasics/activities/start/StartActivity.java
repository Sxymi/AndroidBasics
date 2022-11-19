package org.sxymi.androidbasics.activities.start;

import android.Manifest;
import android.os.Bundle;
import android.widget.Button;

import androidx.core.app.ActivityCompat;

import org.sxymi.androidbasics.R;
import org.sxymi.androidbasics.activities.BaseActivity;
import org.sxymi.androidbasics.classes.Functions;

public class StartActivity extends BaseActivity {
    private Button buttonList, buttonAbout, buttonExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.askForPermissions();
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_start;
    }

    @Override
    protected void initializeControls() {
        this.buttonList = this.findViewById(R.id.start_button_list);
        this.buttonAbout = this.findViewById(R.id.start_button_about);
        this.buttonExit = this.findViewById(R.id.start_button_exit);
    }

    @Override
    protected void handleControls() {
        this.buttonList.setOnClickListener(view -> {
            Functions.goToActivity(this, ListActivity.class);
        });

        this.buttonAbout.setOnClickListener(view -> {
            Functions.goToActivity(this, AboutActivity.class);
        });

        this.buttonExit.setOnClickListener(view -> {
            System.exit(0);
        });
    }

    private void askForPermissions() {
        String[] permissions = new String[]{Manifest.permission.POST_NOTIFICATIONS};
        ActivityCompat.requestPermissions(this, permissions, 1);
    }
}