package com.example.ing2.ui.game;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.example.ing2.R;
import com.example.ing2.ui.game.utilities.ResultadoAdapter;
import com.example.ing2.ui.game.utilities.dataResult;

import java.util.ArrayList;
import java.util.List;

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
        totalpoints = (TextView)findViewById(R.id.totalpoints);
        totalpoints.setText(Integer.toString(totalPoints));
        listofresults = (ListView)findViewById(R.id.listofresults);
        listofresults.setAdapter(new ResultadoAdapter(this,dataresult));


    }

    public void closeresult(View view) {
        finish();
    }
}