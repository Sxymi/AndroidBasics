package org.sxymi.androidbasics.activities.list;

import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;

import org.sxymi.androidbasics.R;
import org.sxymi.androidbasics.activities.BaseActivity;

public class PictureActivity extends BaseActivity {
    private static final String KEY = "picture";
    private Button button;
    private ImageView image;
    private ActivityResultLauncher<String> activityResultLauncher;
    private Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (this.uri != null) {
            this.image.setImageURI(this.uri);
        }
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_picture;
    }

    @Override
    protected void initializeControls() {
        this.button = this.findViewById(R.id.picture_button);
        this.image = this.findViewById(R.id.picture_image_view);
        this.activityResultLauncher = registerForActivityResult(new ActivityResultContracts.GetContent(), uri -> {
            this.uri = uri;
            this.image.setImageURI(uri);
        });
    }

    @Override
    protected void handleControls() {
        this.button.setOnClickListener(view -> {
            this.activityResultLauncher.launch("image/*");
        });
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(KEY, this.uri);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        this.uri = savedInstanceState.getParcelable(KEY, Uri.class);
        this.image.setImageURI(this.uri);
    }
}
