package org.sxymi.androidbasics.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {
    public static final String BUNDLE_KEY = "bundle";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(this.getLayout());
        this.initializeControls();
        this.handleControls();

        Bundle bundle = this.getIntent().getExtras();
        if (bundle != null && !bundle.isEmpty() && bundle.containsKey(BUNDLE_KEY)) {
            this.readBundle(bundle.getBundle(BUNDLE_KEY));
        }
    }

    protected abstract int getLayout();

    protected abstract void initializeControls();

    protected abstract void handleControls();

    protected void readBundle(Bundle bundle) {
    }
}
