package com.example.runpossiblegoal.ranking;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.runpossiblegoal.R;
import com.example.runpossiblegoal.sqlite.Pedometer;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.converter.gson.GsonConverterFactory;

public class Retrofit extends AppCompatActivity {
    String TAG = "Retrofit";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);

        //Retrofit 인스턴스 생성
        retrofit2.Retrofit retrofit = new retrofit2.Retrofit.Builder()
                .baseUrl("https://my-json-server.typicode.com/gagip/JsonServer/")    // baseUrl 등록
                .addConverterFactory(GsonConverterFactory.create())  // Gson 변환기 등록
                .build();

        RetrofitInterface service = retrofit.create(RetrofitInterface.class);   // 레트로핏 인터페이스 객체 구현

        Button btn_sendIdx = findViewById(R.id.btn_sendIdx);    // 전송 버튼
        btn_sendIdx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.e(TAG, "버튼 클릭");

                // edittext로부터 유저가 입력한 idx값을 가져온다
                EditText editText_idx = findViewById(R.id.editText);
                int rank = Integer.parseInt(editText_idx.getText().toString()); // 서버로 보낼 idx

                Call<Rank> call = service.getRank(rank);

                call.enqueue(new Callback<Rank>() {
                    @Override
                    public void onResponse(Call<Rank> call, Response<Rank> response) {
                        Log.e(TAG, "onResponse");
                        if(response.isSuccessful()){
                            Log.e(TAG, "onResponse success");
                            Rank result = response.body();

                            // 서버에서 응답받은 데이터를 TextView에 넣어준다.
                            TextView name = findViewById(R.id.name);
                            TextView stepCount = findViewById(R.id.stepCount);

                            name.setText(result.name);
                            stepCount.setText(result.stepCount);

                        }
                        else{
                            // 실패
                            Log.e(TAG, "onResponse fail");
                        }
                    }

                    @Override
                    public void onFailure(Call<Rank> call, Throwable t) {
                        // 통신 실패
                        Log.e(TAG, "onFailure: " + t.getMessage());
                    }
                });
            }
        });
    }
}