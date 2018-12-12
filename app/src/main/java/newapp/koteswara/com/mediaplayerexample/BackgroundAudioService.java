package newapp.koteswara.com.mediaplayerexample;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class BackgroundAudioService extends Service implements MediaPlayer.OnCompletionListener {
    MediaPlayer mediaPlayer;

    public BackgroundAudioService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
         return null;
    }
    @Override
    public void onCreate() {
        mediaPlayer = MediaPlayer.create(this,R.raw.one);// raw/s.mp3
        mediaPlayer.setOnCompletionListener(this);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (!mediaPlayer.isPlaying()) {
            mediaPlayer.start();
        }
        return START_STICKY;
    }

    public void onDestroy() {
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
        }
        mediaPlayer.release();
    }

    public void onCompletion(MediaPlayer _mediaPlayer) {
        stopSelf();
    }
}
