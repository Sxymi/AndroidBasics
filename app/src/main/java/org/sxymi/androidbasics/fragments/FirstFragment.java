package org.sxymi.androidbasics.fragments;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import org.sxymi.androidbasics.R;
import org.sxymi.androidbasics.activities.list.FragmentsActivity;

public class FirstFragment extends BaseFragment {
    private EditText editText;

    @Override
    protected int getLayout() {
        return R.layout.fragment_first;
    }

    @Override
    protected void initializeControls(View view) {
        this.editText = view.findViewById(R.id.first_fragment_edit_text);
    }

    @Override
    public Bundle getBundle() {
        Bundle bundle = new Bundle();
        if (this.editText != null) {
            bundle.putString(FragmentsActivity.KEY, this.editText.getText().toString());
        }

        return bundle;
    }

    @Override
    protected void readBundle(Bundle bundle) {
        if (bundle.containsKey(FragmentsActivity.KEY)) {
            this.editText.setText(bundle.getString(FragmentsActivity.KEY));
        }
    }
}