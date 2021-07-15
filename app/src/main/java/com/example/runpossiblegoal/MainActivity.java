 package com.example.runpossiblegoal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.runpossiblegoal.ranking.Retrofit;
import com.example.runpossiblegoal.run.RunActivity;

 public class MainActivity extends AppCompatActivity {

    Button runBtn;
    Button rankBtn;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        runBtn = (Button) findViewById(R.id.runBtn);
        rankBtn = (Button) findViewById(R.id.rankBtn);

        runBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RunActivity.class);
                startActivity(intent);
            }
        });

        rankBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Retrofit.class);
                startActivity(intent);
            }
        });
    }
}