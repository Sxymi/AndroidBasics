package org.sxymi.androidbasics.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(this.getLayout());
        this.initializeControls();
        this.handleControls();

        Bundle bundle = this.getIntent().getExtras();
        if (bundle != null && !bundle.isEmpty()) {
            this.readBundle(bundle);
        }
    }

    protected abstract int getLayout();

    protected abstract void initializeControls();

    protected abstract void handleControls();

    protected void readBundle(Bundle bundle) {
    }
}
