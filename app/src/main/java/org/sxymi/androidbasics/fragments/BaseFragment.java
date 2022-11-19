package org.sxymi.androidbasics.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public abstract class BaseFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(this.getLayout(), container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.initializeControls(view);

        Bundle bundle = this.getArguments();
        if (bundle != null && !bundle.isEmpty()) {
            this.readBundle(bundle);
        }
    }

    protected abstract int getLayout();

    protected abstract void initializeControls(View view);

    public abstract Bundle getBundle();

    protected abstract void readBundle(Bundle bundle);
}
