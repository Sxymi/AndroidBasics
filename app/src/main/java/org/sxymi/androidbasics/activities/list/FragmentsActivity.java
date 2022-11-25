package org.sxymi.androidbasics.activities.list;

import android.os.Bundle;
import android.widget.Button;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import org.sxymi.androidbasics.R;
import org.sxymi.androidbasics.activities.BaseActivity;
import org.sxymi.androidbasics.classes.Functions;
import org.sxymi.androidbasics.fragments.BaseFragment;
import org.sxymi.androidbasics.fragments.FirstFragment;
import org.sxymi.androidbasics.fragments.SecondFragment;

public class FragmentsActivity extends BaseActivity {
    public final static String KEY = "fragments";
    private Button buttonFirst, buttonSecond;
    private BaseFragment currentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.currentFragment = new FirstFragment();
        this.changeFragment();
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_fragments;
    }

    @Override
    protected void initializeControls() {
        this.buttonFirst = this.findViewById(R.id.fragments_button_first_fragment);
        this.buttonSecond = this.findViewById(R.id.fragments_button_second_fragment);
    }

    @Override
    protected void handleControls() {
        this.buttonFirst.setOnClickListener(view -> {
            this.switchButtonsState();
            this.setAndChangeCurrentFragment(new FirstFragment());
        });

        this.buttonSecond.setOnClickListener(view -> {
            String text = this.currentFragment.getBundle().getString(FragmentsActivity.KEY);
            if ("".equals(text)) {
                Functions.sendToast(this, R.string.error_empty_edit_text);
                return;
            }

            this.switchButtonsState();
            this.setAndChangeCurrentFragment(new SecondFragment());
        });
    }

    private void setAndChangeCurrentFragment(BaseFragment fragment) {
        Bundle bundle = this.currentFragment.getBundle();
        this.currentFragment = fragment;
        this.currentFragment.setArguments(bundle);
        this.changeFragment();
    }

    private void changeFragment() {
        FragmentManager manager = this.getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.fragments_layout_frame, this.currentFragment);
        transaction.commit();
    }

    private void switchButtonsState() {
        this.buttonFirst.setEnabled(!this.buttonFirst.isEnabled());
        this.buttonSecond.setEnabled(!this.buttonSecond.isEnabled());
    }
}