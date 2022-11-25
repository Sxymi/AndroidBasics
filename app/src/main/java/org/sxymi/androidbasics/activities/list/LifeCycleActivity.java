package org.sxymi.androidbasics.activities.list;

import android.os.Bundle;
import android.util.Log;

import org.sxymi.androidbasics.R;
import org.sxymi.androidbasics.activities.BaseActivity;

public class LifeCycleActivity extends BaseActivity {
    private String title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(this.title, "onCreate");
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_lifecycle;
    }

    @Override
    protected void initializeControls() {
        this.title = this.getResources().getString(R.string.label_activity_lifecycle);
    }

    @Override
    protected void handleControls() {
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(this.title, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(this.title, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(this.title, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(this.title, "onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(this.title, "onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(this.title, "onDestroy");
    }
}
