package org.sxymi.androidbasics.activities.list;

import android.util.Log;
import android.widget.Button;

import org.sxymi.androidbasics.R;
import org.sxymi.androidbasics.activities.BaseActivity;

public class LogcatActivity extends BaseActivity {
    private Button buttonVerbose, buttonDebug, buttonInformation, buttonWarning, buttonError, buttonAssert;
    private String title, log;

    @Override
    protected int getLayout() {
        return R.layout.activity_logcat;
    }

    @Override
    protected void initializeControls() {
        this.buttonVerbose = this.findViewById(R.id.logcat_button_verbose);
        this.buttonDebug = this.findViewById(R.id.logcat_button_debug);
        this.buttonInformation = this.findViewById(R.id.logcat_button_information);
        this.buttonWarning = this.findViewById(R.id.logcat_button_warning);
        this.buttonError = this.findViewById(R.id.logcat_button_error);
        this.buttonAssert = this.findViewById(R.id.logcat_button_assert);
        this.title = this.getResources().getString(R.string.label_activity_logcat);
        this.log = this.getResources().getString(R.string.logcat_log);
    }

    @Override
    protected void handleControls() {
        this.buttonVerbose.setOnClickListener(view -> {
            this.sendLog(Log.VERBOSE, this.buttonVerbose);
        });

        this.buttonDebug.setOnClickListener(view -> {
            this.sendLog(Log.DEBUG, this.buttonDebug);
        });

        this.buttonInformation.setOnClickListener(view -> {
            this.sendLog(Log.INFO, this.buttonInformation);
        });

        this.buttonWarning.setOnClickListener(view -> {
            this.sendLog(Log.WARN, this.buttonWarning);
        });

        this.buttonError.setOnClickListener(view -> {
            this.sendLog(Log.ERROR, this.buttonError);
        });

        this.buttonAssert.setOnClickListener(view -> {
            this.sendLog(Log.ASSERT, this.buttonAssert);
        });
    }

    private void sendLog(int type, Button button) {
        String label = button.getText().toString();
        Log.println(type, this.title, label + " " + this.log);
    }
}
