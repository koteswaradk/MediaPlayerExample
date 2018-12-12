package newapp.koteswara.com.mediaplayerexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button startPlaybackButton, stopPlaybackButton;
    Intent playbackServiceIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startPlaybackButton = (Button) this.findViewById(R.id.StartPlaybackButton);
        stopPlaybackButton = (Button) this.findViewById(R.id.StopPlaybackButton);

        startPlaybackButton.setOnClickListener(this);
        stopPlaybackButton.setOnClickListener(this);

        playbackServiceIntent = new Intent(this, BackgroundAudioService.class);
    }

    @Override
    public void onClick(View v) {
        if (v == startPlaybackButton) {
            startService(playbackServiceIntent);
           // finish();
        } else if (v == stopPlaybackButton) {
            stopService(playbackServiceIntent);
           // finish();
        }


}
}
