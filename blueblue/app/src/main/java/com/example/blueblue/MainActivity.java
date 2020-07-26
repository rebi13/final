
package com.example.blueblue;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

import static android.speech.tts.TextToSpeech.ERROR;

public class MainActivity extends AppCompatActivity {
    TextView ReceiveData;
    EditText SendDataline;
    Button SendData;
    Button DeleteData;
    ScrollView scrollView;
    private TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Toast.makeText(this, "앱이 정상적으로 실행 중입니다.", Toast.LENGTH_SHORT).show();

        ReceiveData = (TextView) findViewById(R.id.ReceiveData);
        SendDataline = (EditText) findViewById(R.id.SendDataline);
        SendData = (Button) findViewById(R.id.SendData);
        DeleteData = (Button) findViewById(R.id.DeleteData);
        scrollView = (ScrollView) findViewById(R.id.scrollView);
        //scrollView.fullScroll(ScrollView.FOCUS_DOWN);
        ReceiveData.setMovementMethod(new ScrollingMovementMethod());

        tts = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != ERROR) {
                    // 언어를 선택한다.
                    tts.setLanguage(Locale.KOREAN);
                }
            }
        });

        SendData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = SendDataline.getText().toString();
                ReceiveData.append(str+"\n");
                tts.speak(str, TextToSpeech.QUEUE_FLUSH, null);
                SendDataline.setText(null);
                scrollView.post(new Runnable() {
                    public void run() {
                        // TODO Auto-generated method stub
                        scrollView.scrollTo(0, ReceiveData.getHeight());
                    }
                });
        }
        });

        DeleteData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ReceiveData.setText(null);
            }
        });
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        // TTS 객체가 남아있다면 실행을 중지하고 메모리에서 제거한다.
        if(tts != null){
            tts.stop();
            tts.shutdown();
            tts = null;
        }
    }

}

