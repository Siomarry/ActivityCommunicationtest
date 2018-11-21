package com.example.siomarry.activitycommunicationtest;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    final static int Subactivity1 = 1;
    final static int Subactivity2 = 2;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainactivitylayout);
        textView = (TextView)findViewById(R.id.textview);
        final Button button1 = (Button)findViewById(R.id.mainbutton1);
        final Button button2 = (Button)findViewById(R.id.mainbutton2);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, com.example.siomarry.activitycommunicationtest.Subactivity1.class);
                startActivityForResult(intent,Subactivity1);
            }
        });

        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, com.example.siomarry.activitycommunicationtest.Subactivity2.class);
                startActivityForResult(intent,Subactivity2);
            }

        });
    }

    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent data)
    {
        super.onActivityResult(requestCode,resultCode,data);

        switch (requestCode){
            case Subactivity1:
                if(resultCode==RESULT_OK)
                {
                    Log.i("A","s");
                    Uri uriData = data.getData();
                    textView.setText(uriData.toString());
                }
            case Subactivity2:
                break;
        }
    }
}
