package tw.com.changchinghsiang.sunday_classno_08_soundpool;

import android.media.AudioAttributes;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private SoundPool soundPool;
    private int soundID01, soundID02;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //設定 SoundPool
        setSoundPool();
    }

    private void setSoundPool() {
        /* === 設定音頻屬性集合 === */
        //建立 AudioAttributes Builder 物件
        AudioAttributes.Builder attriBuilder = new AudioAttributes.Builder();
        //設定音效用途（鬧鐘或鈴聲）
        attriBuilder.setUsage(AudioAttributes.USAGE_MEDIA);
        //設定音效內容類型（語音或音樂）
        attriBuilder.setContentType(AudioAttributes.CONTENT_TYPE_MUSIC);
        //建立 AudioAttributes 物件
        AudioAttributes attributes = attriBuilder.build();

        //建立SoundPool Builder物件
        SoundPool.Builder spoolBuilder = new SoundPool.Builder();
        //設定 pool 上限
        spoolBuilder.setMaxStreams(6);
        //設定音頻屬性
        spoolBuilder.setAudioAttributes(attributes);
        //建立SoundPool物件
        soundPool = spoolBuilder.build();

        //讀取音效檔案（畫面，資源檔，聲音的優先級。目前沒有任何效果。使用值1以備將來兼容）
        soundID01 = soundPool.load(this, R.raw.hangouts_message, 1);
        soundID02 = soundPool.load(this, R.raw.hangouts_video_call, 1);
    }

    //Play 1
    public void PlayOneOnClick(View view) {
        //播放（音效檔編號，左聲道音量，右聲道音量，優先權，循環播放，播放速度）
        soundPool.play(soundID01, 1.0F, 1.0F, 0, 0, 1.0F);
    }

    //Play 2
    public void PlayTwoOnClick(View view) {
        //播放（音效檔編號，左聲道音量，右聲道音量，優先權，循環播放，播放速度）
        soundPool.play(soundID02, 1.0F, 1.0F, 0, 0, 1.0F);
    }
}
