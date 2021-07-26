package com.example.ing2.ui.game.utilities;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.ing2.R;
import com.example.ing2.ui.game.entities.Answer;

import java.util.List;

public class ResultadoAdapter extends ArrayAdapter <dataResult> {
    private List <dataResult> data;
    public ResultadoAdapter(@NonNull Context context, List<dataResult> data) {
        super(context, R.layout.resultado,data);
        this.data = data;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.resultado,null);
        TextView numofquestion = (TextView) item.findViewById(R.id.numofquestion);
        numofquestion.setText(data.get(position).getData());
        ImageView imgResult = (ImageView)item.findViewById(R.id.iconresult);
        if(data.get(position).getPoints() > 0)
            imgResult.setImageResource(R.drawable.ic_check);
        else
            imgResult.setImageResource(R.drawable.ic_nocheck);
        return item;
    }

}
