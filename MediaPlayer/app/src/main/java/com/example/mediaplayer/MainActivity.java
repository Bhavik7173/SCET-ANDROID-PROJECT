package com.example.mediaplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, Runnable {

    Spinner spinner;
    TextView st, et;
    LottieAnimationView anim;
    MediaPlayer mediaPlayer;
    Handler handler;
    ImageView rewind, play, forward;
    String way[] = {
            "In App", "Phone Storage", "Live Streaming"
    };
    int i;
    SeekBar seekBar;
    boolean flag = false, proFlag = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setId();

        //set the way on Spinner
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, way);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        setStatus(false);
    }

    private void setId() {
        spinner = findViewById(R.id.music_way);
        st = findViewById(R.id.st);
        et = findViewById(R.id.et);
        play = findViewById(R.id.playBtn);
        rewind = findViewById(R.id.rewindBtn);
        forward = findViewById(R.id.forwardBtn);
        anim = findViewById(R.id.anim);
        seekBar = findViewById(R.id.seekbar);
        handler = new Handler();

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        if (i == 0) {
            Toast.makeText(this, "In App", Toast.LENGTH_SHORT).show();
            inApp();
        } else if (i == 1) {
            Toast.makeText(this, "Phone Storage", Toast.LENGTH_SHORT).show();
        } else if (i == 2) {
            Toast.makeText(this, "Live Streaming", Toast.LENGTH_SHORT).show();
        }
    }

    private void inApp() {
        mediaPlayer = MediaPlayer.create(this, R.raw.realme);
        play(play);
    }

    private void setStatus(boolean b) {
        play.setEnabled(b);
        rewind.setEnabled(b);
        forward.setEnabled(b);
    }


    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void run() {
        st.setText(timeConvert(mediaPlayer.getCurrentPosition()));
        seekBar.setProgress(mediaPlayer.getCurrentPosition());
        if(flag==true)
        {
            handler.postDelayed(this,1000);
        }
    }

    private String timeConvert(int currentPosition) {
        currentPosition = currentPosition / 1000;
        int m = currentPosition / 60;
        currentPosition = currentPosition % 60;
        String time = m + " : " + currentPosition;
        return time;
    }

    public void forward(View view) {
        anim.reverseAnimationSpeed();
        int cur = mediaPlayer.getCurrentPosition();
        cur = cur + 10 * 1000;
        if(cur<=i)
        {
            st.setText(timeConvert(cur));
            mediaPlayer.seekTo(cur);
            seekBar.setProgress(cur);
        }
        else {
            seekBar.setProgress(i);
            mediaPlayer.seekTo(i);
            st.setText(timeConvert(i));
        }
    }

    public void play(View view) {
        mediaPlayer.start();
        anim.playAnimation();
        proFlag = true;
        handler.postDelayed(this, 1000);

        setStatus(true);
        play.setEnabled(false);
        flag = true;
        i = mediaPlayer.getDuration();
        seekBar.setMax(i);
        et.setText(timeConvert(i));
    }

    public void rewind(View view) {
        anim.reverseAnimationSpeed();
        int cur = mediaPlayer.getCurrentPosition();
        cur = cur - 10 * 1000;
        if(cur>=i)
        {
            st.setText(timeConvert(cur));
            mediaPlayer.seekTo(cur);
            seekBar.setProgress(cur);
        }
        else {
            seekBar.setProgress(i);
            mediaPlayer.seekTo(i);
            st.setText(timeConvert(i));
        }
    }

    public void pause(View view) {
        mediaPlayer.pause();
        anim.pauseAnimation();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mediaPlayer.pause();
        flag = false;
    }

    @Override
    protected void onRestart() {
        mediaPlayer.start();
        super.onRestart();
    }
}