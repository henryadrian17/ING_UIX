package com.example.ing2.ui.game.utilities;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.ing2.R;
import com.example.ing2.ui.game.entities.Answer;

import java.util.List;

public class OptionsAdapter extends ArrayAdapter <Answer> {
    private List<Answer> opciones;
    public OptionsAdapter(@NonNull Context context, List<Answer> opciones) {
        super(context, R.layout.optiones,opciones);
        this.opciones = opciones;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.optiones,null);
        Button bttnOption = (Button)item.findViewById(R.id.bttnOpcion);
        bttnOption.setText(opciones.get(position).getAnswer());
        return item;
    }

    @Nullable
    @Override
    public Answer getItem(int position) {
        return opciones.get(position);
    }

}
