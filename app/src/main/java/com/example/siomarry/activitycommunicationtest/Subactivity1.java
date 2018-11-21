package com.example.siomarry.activitycommunicationtest;

import android.content.Intent;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Subactivity1 extends Activity {

    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity1layout);

        Button button1 = (Button)findViewById(R.id.button1);
        Button button2 = (Button)findViewById(R.id.button2);

        editText = (EditText)findViewById(R.id.edittext);


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uri = editText.getText().toString();
                Uri data = Uri.parse(uri);
                Intent result = new Intent(null,data);
                setResult(RESULT_OK,result);
                finish();
            }
        });

        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                setResult(RESULT_CANCELED,null);
                finish();
            }
        });


    }

}
