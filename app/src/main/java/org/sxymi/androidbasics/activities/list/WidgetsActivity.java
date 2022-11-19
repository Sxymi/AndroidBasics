package org.sxymi.androidbasics.activities.list;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import org.sxymi.androidbasics.R;
import org.sxymi.androidbasics.activities.BaseActivity;

public class WidgetsActivity extends BaseActivity {
    private Button button;
    private ProgressBar progressBar;
    private CheckBox checkbox;
    private TextView textView;
    private RadioGroup radioGroup;
    private EditText editText;

    @Override
    protected int getLayout() {
        return R.layout.activity_widgets;
    }

    @Override
    protected void initializeControls() {
        this.button = this.findViewById(R.id.widgets_button);
        this.progressBar = this.findViewById(R.id.widgets_progressbar);
        this.checkbox = this.findViewById(R.id.widgets_checkbox);
        this.textView = this.findViewById(R.id.widgets_textview);
        this.radioGroup = this.findViewById(R.id.widgets_radio_group);
        this.editText = this.findViewById(R.id.widgets_edittext);
    }

    @Override
    protected void handleControls() {
        this.button.setOnClickListener(view -> {
            if (this.progressBar.getVisibility() == View.VISIBLE) {
                this.progressBar.setVisibility(View.INVISIBLE);
                this.button.setText(R.string.widgets_button_on);
            } else {
                this.progressBar.setVisibility(View.VISIBLE);
                this.button.setText(R.string.widgets_button_off);
            }
        });

        this.checkbox.setOnCheckedChangeListener((view, isChecked) -> {
            this.textView.setText(isChecked ? R.string.widgets_textview_on : R.string.widgets_textview_off);
        });

        this.radioGroup.setOnCheckedChangeListener((group, idChecked) -> {
            RadioButton radio = this.findViewById(idChecked);
            this.editText.setText(radio.getText());
        });
    }
}