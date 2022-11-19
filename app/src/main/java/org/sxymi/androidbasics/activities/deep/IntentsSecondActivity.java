package org.sxymi.androidbasics.activities.deep;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import org.sxymi.androidbasics.R;
import org.sxymi.androidbasics.activities.BaseActivity;
import org.sxymi.androidbasics.activities.list.IntentsActivity;

public class IntentsSecondActivity extends BaseActivity {
    private Button button;
    private EditText editText;

    @Override
    protected int getLayout() {
        return R.layout.activity_intents_second;
    }

    @Override
    protected void initializeControls() {
        this.button = this.findViewById(R.id.intents_second_button);
        this.editText = this.findViewById(R.id.intents_second_edit_text);
    }

    @Override
    protected void handleControls() {
        this.button.setOnClickListener(view -> {
            Intent intent = new Intent(this, IntentsActivity.class);
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