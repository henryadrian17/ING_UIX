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

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class UnoVsAll extends AppCompatActivity {
    private List<Question> questions = new ArrayList<>();
    private List<Answer> answerList1,answerList2,answerList3,answerList4,answerList5;
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
        try {
            cargaInicial();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        actualizarPregunta(progres);
        progressBar.setMax(maxProgres);
    }
    private void iniciarControles() {
        opciones = (ListView)findViewById(R.id.options);
        progressBar = (ProgressBar)findViewById(R.id.progreequiz);
        txtquestion = (TextView)findViewById(R.id.txtquestion);
        txtprogreequiz = (TextView)findViewById(R.id.txtprogreequiz);
    }
    private void cargaInicial() throws IOException, JSONException {
        Request request2 = new Request.Builder()
                .url("http://167.71.105.232/api/game/questions")
                //.addHeader("Authorization", "Bearer "+token)
                .build();
        OkHttpClient client = new OkHttpClient();
        Response response2 = client.newCall(request2).execute();
        System.out.println("Paso la conversion 0");
//        System.out.println(response2.body().string());
        JSONObject obj2 = new JSONObject(response2.body().string());
//        System.out.println(response2.body().string());
        answerList1 = new ArrayList();
        answerList1.add(new Answer(1,"Desechable","1orem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has su"));
        answerList1.add(new Answer(2,"Revolucionario","2orem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has su"));
        answerList1.add(new Answer(3,"Prototipos estructurales","3orem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has su"));

        answerList2 = new ArrayList();
        answerList2.add(new Answer(1,"Modelado.","1orem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has su"));
        answerList2.add(new Answer(2,"Diseño rápido. ","2orem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has su"));
        answerList2.add(new Answer(3,"Madurez.","3orem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has su"));

        answerList3 = new ArrayList();
        answerList3.add(new Answer(1,"Reduce costo.","1orem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has su"));
        answerList3.add(new Answer(2,"Aumenta la probabilidad de éxito. ","2orem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has su"));
        answerList3.add(new Answer(3,"Poco recurso humano.","3orem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has su"));

        answerList4 = new ArrayList();
        answerList4.add(new Answer(1,"Modelo de Prototipos rápido","1orem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has su"));
        answerList4.add(new Answer(2,"Ciclo de vida","2orem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has su"));
        answerList4.add(new Answer(3,"Scrum","3orem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has su"));

        answerList5 = new ArrayList();
        answerList5.add(new Answer(1,"Modelo de Prototipos rápido","1orem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has su"));
        answerList5.add(new Answer(2,"Ciclo de vida","2orem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has su"));
        answerList5.add(new Answer(3,"Scrum","3orem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has su"));


        questions.add(new Question(1,"¿Cuáles son las clases del tipo de prototipos?",answerList1.get(1),answerList1,8));
        questions.add(new Question(2,"Forma parte de las etapas del modelo de prototipos. ",answerList2.get(0),answerList2,8));
        questions.add(new Question(3,"¿Cuál sería una de las ventajas de usar el modelo basado en prototipos? ",answerList3.get(1),answerList3,8));
        questions.add(new Question(4,"Metodología que desarrolla rápidamente nuevos diseños. ",answerList4.get(0),answerList4,8));
        questions.add(new Question(5,"Es un modelo que resulta muy útil para evaluar el alcance del producto, pero no su uso real. ",answerList5.get(0),answerList5,8));
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