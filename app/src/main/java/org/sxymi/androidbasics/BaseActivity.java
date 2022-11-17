package org.sxymi.androidbasics;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(this.getLayout());
        this.initializeControls();
        this.handleControls();
    }

    protected abstract int getLayout();

    protected abstract void initializeControls();

    protected abstract void handleControls();
}
