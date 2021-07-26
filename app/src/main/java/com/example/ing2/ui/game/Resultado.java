package com.example.ing2.ui.game;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.example.ing2.R;
import com.example.ing2.ui.game.utilities.ResultadoAdapter;
import com.example.ing2.ui.game.utilities.dataResult;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class Resultado extends AppCompatActivity {
    private TextView totalpoints;
    private ListView listofresults;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);
        Bundle bundle =getIntent().getExtras();
        List <dataResult> dataresult = new ArrayList<>();
        int totalPoints = 0;
        String key = "";
        for( int i = 0; i < 5; i++){
            key = Integer.toString(i+1);
            dataresult.add(new dataResult(key,bundle.getFloat(key)));
            totalPoints += bundle.getFloat(key);
        }
        StrictMode.ThreadPolicy policy =
                new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        OkHttpClient client = new OkHttpClient();
        RequestBody formBody = new FormBody.Builder()
                .add("score", String.valueOf(totalPoints))
                .build();
        Request request = new Request.Builder()
                .url("http://167.71.105.232/api/game/update_score")
                .post(formBody)
                .build();
        try {
            Response response = client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        totalpoints = (TextView)findViewById(R.id.totalpoints);
        totalpoints.setText(Integer.toString(totalPoints));
        listofresults = (ListView)findViewById(R.id.listofresults);
        listofresults.setAdapter(new ResultadoAdapter(this,dataresult));


    }

    public void closeresult(View view) {
        finish();
    }
}