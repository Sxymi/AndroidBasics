package org.sxymi.androidbasics;

import android.widget.Button;

public class StartActivity extends BaseActivity {
    private Button buttonList, buttonAbout, buttonExit;

    @Override
    protected int getLayout() {
        return R.layout.activity_start;
    }

    @Override
    protected void initializeControls() {
        this.buttonList = this.findViewById(R.id.button_start_list);
        this.buttonAbout = this.findViewById(R.id.button_start_about);
        this.buttonExit = this.findViewById(R.id.button_start_exit);
    }

    @Override
    protected void handleControls() {
    }
}