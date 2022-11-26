package org.sxymi.androidbasics.activities.list;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import org.sxymi.androidbasics.R;
import org.sxymi.androidbasics.activities.BaseActivity;

public class MultimediaActivity extends BaseActivity {
    private Button button;
    private VideoView videoView;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.initializeAudioPlayer();
        this.initializeVideoPlayer();
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_multimedia;
    }

    @Override
    protected void initializeControls() {
        this.button = this.findViewById(R.id.multimedia_button_music);
        this.videoView = this.findViewById(R.id.multimedia_video_view);
    }

    @Override
    protected void handleControls() {
        this.button.setOnClickListener(view -> {
            if (!this.mediaPlayer.isPlaying()) {
                this.mediaPlayer.start();
                this.button.setText(R.string.multimedia_button_audio_off);
            } else {
                this.mediaPlayer.pause();
                this.button.setText(R.string.multimedia_button_audio_on);
            }
        });
    }

    private void initializeAudioPlayer() {
        this.mediaPlayer = MediaPlayer.create(this, R.raw.audio_example);
        this.mediaPlayer.setOnCompletionListener(listener -> {
            this.button.setText(R.string.multimedia_button_audio_on);
        });
    }

    private void initializeVideoPlayer() {
        Uri uri = Uri.parse("android.resource://" + this.getPackageName() + "/" + R.raw.video_example);
        this.videoView.setVideoURI(uri);

        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(this.videoView);
        this.videoView.setMediaController(mediaController);
    }
}
