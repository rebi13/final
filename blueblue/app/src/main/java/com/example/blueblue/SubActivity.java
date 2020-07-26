package com.example.blueblue;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;

public class SubActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();//초기 화면으로 이동
            }
        });

        Button setbutton = findViewById(R.id.setbutton);
        setbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SubActivity.this, Sub2Activity.class);
                startActivity(intent);
            }
        });
    }

    public class SoundManager {
        private SoundPool mSoundPool;
        private HashMap<Integer, Integer> mSoundPoolMap;
        private AudioManager mAudioManager;
        private Context mContext;

        public SoundManager(Context mContext,SoundPool mSoundPool){
        this.mContext = mContext;
        this.mSoundPool = mSoundPool;
        mSoundPoolMap = new HashMap<Integer, Integer>();
        mAudioManager = (AudioManager)mContext.getSystemService(Context.AUDIO_SERVICE);
        }

        public void addSound(int index,int soundId){ //효과음 추가
            mSoundPoolMap.put(index,mSoundPool.load(mContext,soundId,1));
        }

        public int playSound(int index){ //효과음 재생
            int streamVolume = mAudioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
            return mSoundPool.play(mSoundPoolMap.get(index),streamVolume,streamVolume,1,0,1f);
        }

        public void stopSound(int streamId){
            mSoundPool.stop(streamId);
        } //효과음 정지
        public void pauseSound(int streamId){
            mSoundPool.pause(streamId);
        } //효과음 일시정지
        public void resumeSound(int streamId){
            mSoundPool.resume(streamId);
        } //효과음 재시작
        public boolean volumeDown(){
            mAudioManager.adjustStreamVolume(AudioManager.STREAM_MUSIC,
                    AudioManager.ADJUST_LOWER,
                    AudioManager.FLAG_SHOW_UI);
            return true;
        }
        public boolean volumeUp(){ mAudioManager.adjustStreamVolume(AudioManager.STREAM_MUSIC, AudioManager.ADJUST_RAISE, AudioManager.FLAG_SHOW_UI); return true; }


    }
}