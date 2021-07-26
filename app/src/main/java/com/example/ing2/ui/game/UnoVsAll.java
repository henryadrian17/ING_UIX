package com.example.ing2.ui.game;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


import com.example.ing2.R;
import com.example.ing2.ui.game.entities.Answer;
import com.example.ing2.ui.game.entities.Question;
import com.example.ing2.ui.game.utilities.OptionsAdapter;

import java.util.ArrayList;
import java.util.List;

public class UnoVsAll extends AppCompatActivity {
    private List<Question> questions = new ArrayList<>();
    private List<Answer> answerList;
    private ListView opciones;
    private TextView txtquestion,txtprogreequiz;
    private int progres = 0;
    private int maxProgres = 5;
    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uno_vs_all);
        iniciarControles();
        cargaInicial();
        actualizarPregunta(progres);
        progressBar.setMax(maxProgres);
    }
    private void iniciarControles() {
        opciones = (ListView)findViewById(R.id.options);
        progressBar = (ProgressBar)findViewById(R.id.progreequiz);
        txtquestion = (TextView)findViewById(R.id.txtquestion);
        txtprogreequiz = (TextView)findViewById(R.id.txtprogreequiz);
    }
    private void cargaInicial(){
        answerList = new ArrayList<>();
        answerList.add(new Answer(1,"1 Lorem Ipsum is simply dummy te Lorem Ipsum is simply dummy t","1orem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has su"));
        answerList.add(new Answer(2,"2 Lorem Ipsum is simply dummy te Lorem Ipsum is simply dummy t","2orem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has su"));
        answerList.add(new Answer(3,"3 Lorem Ipsum is simply dummy te Lorem Ipsum is simply dummy t","3orem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has su"));
        answerList.add(new Answer(4,"4 Lorem Ipsum is simply dummy te Lorem Ipsum is simply dummy t","4orem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has su"));
        questions.add(new Question(1,"1Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text",answerList.get(2),answerList,8));
        questions.add(new Question(2,"2Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text",answerList.get(3),answerList,8));
        questions.add(new Question(3,"1Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text",answerList.get(2),answerList,8));
        questions.add(new Question(4,"2Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text",answerList.get(3),answerList,8));
        questions.add(new Question(5,"2Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text",answerList.get(3),answerList,8));

    }

    private void actualizarPregunta(int i) {
        opciones.setAdapter(new OptionsAdapter(this,questions.get(i).getOptions()));
        txtquestion.setText(questions.get(i).getQuestion());
        actualizarProgreso();
    }
    private void actualizarProgreso(){
        progressBar.setProgress(progres);
        txtprogreequiz.setText(Float.toString((progres + 0.00f)/maxProgres*100)+"%");
    }
    private Intent chargeFinalResult(Intent intent){
        for(int i = 0; i < 5; i++)
            intent.putExtra(Integer.toString(i+1),questions.get(i).getPoints());
        return intent;
    }
    private void goToNextQuestion(){
        if(progres < maxProgres-1)
            actualizarPregunta(++progres);
        else{
            ++progres;
            actualizarProgreso();
            startActivity(chargeFinalResult(new Intent(this,Resultado.class)));
            finish();
        }
    }


    public void selectOptionOfAnswer(View view){
        final Dialog dialog = new Dialog(this);
        final Answer answer = (Answer)opciones.getAdapter().getItem(opciones.getPositionForView(view));
        questions.get(progres).setUserAnswer(answer);
        if(questions.get(progres).getPoints() == 0) {
            dialog.setContentView(R.layout.retroalimentacion);
            TextView txtremenber = (TextView) dialog.findViewById(R.id.txtremenber);
            txtremenber.setText(answer.getRemember());
            Button buttonokey = (Button) dialog.findViewById(R.id.bttnokey);
            buttonokey.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                    goToNextQuestion();
                }
            });
            dialog.show();
        }else
            goToNextQuestion();

    }
}