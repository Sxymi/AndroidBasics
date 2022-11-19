package org.sxymi.androidbasics.activities.list;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import org.sxymi.androidbasics.R;
import org.sxymi.androidbasics.activities.BaseActivity;
import org.sxymi.androidbasics.activities.deep.IntentsSecondActivity;
import org.sxymi.androidbasics.classes.Functions;

public class IntentsActivity extends BaseActivity {
    public static final String KEY = "argument";
    private Button button;
    private EditText editText;

    @Override
    protected int getLayout() {
        return R.layout.activity_intents;
    }

    @Override
    protected void initializeControls() {
        this.button = this.findViewById(R.id.intents_button);
        this.editText = this.findViewById(R.id.intents_edit_text);
    }

    @Override
    protected void handleControls() {
        this.button.setOnClickListener(view -> {
            if (Functions.isEditTextEmpty(this.editText)) {
                Functions.sendToast(this, R.string.error_empty_edit_text);
                return;
            }

            Intent intent = new Intent(this, IntentsSecondActivity.class);
            intent.putExtra(IntentsActivity.KEY, this.editText.getText().toString());
            this.startActivity(intent);
        });
    }

    @Override
    protected void readBundle(Bundle bundle) {
        super.readBundle(bundle);

        if (bundle.containsKey(IntentsActivity.KEY)) {
            this.editText.setText(bundle.getString(IntentsActivity.KEY));
        }
    }
}