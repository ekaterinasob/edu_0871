package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button trueBtn;
    private Button falseBtn;
    private Button showAnswer;
    private TextView textView;
    private Question[] questions = {
            new Question(R.string.question1,true),
            new Question(R.string.question2,false),
            new Question(R.string.question3,true),
            new Question(R.string.question4,false),
            new Question(R.string.question5,true)
    };
    private int currentIndex=0;

    private String TAG = "Информация о запуске метода: ";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG,"Метод onCreate() запущен!");
        setContentView(R.layout.activity_main);
        if (savedInstanceState != null){
            currentIndex = savedInstanceState.getInt("index");
        }
        trueBtn = findViewById(R.id.trueBtn);
        falseBtn= findViewById(R.id.falseBtn);
        showAnswer=findViewById(R.id.showAnswer);
        textView= findViewById(R.id.textView);

        int question = questions[currentIndex].getQuestionTextId();
        textView.setText(question);
	
	String textViewFinal = "";
		for (int i = 0; i<questions.length; i++){
		textViewFinal = textViewFinal+getString(questions[i].getQuestionTextId())+": "+"\n";
		}

	textView.setText(textViewFinal);
		

	

        trueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(true);
                updateQuestion();
            }
        });
        falseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(false);
                updateQuestion();
            }
        });

        showAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AnswerActivity.class);
                intent.putExtra("answer",questions[currentIndex].isAnswerTrue());
                startActivity(intent);
            }
        });
    }
    private void updateQuestion(){
        currentIndex=(currentIndex+1)%questions.length;
        textView.setText(questions[currentIndex].getQuestionTextId());
    }

    private  void checkAnswer(boolean userAnswer){
        if (questions[currentIndex].isAnswerTrue() == userAnswer)
            Toast.makeText(MainActivity.this, R.string.correct_toast,Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(MainActivity.this, R.string.incorrect_toast,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        Log.d(TAG,"Метод onSaveInstanceState() запущен!!!");
        savedInstanceState.putInt("index",currentIndex);
    }

    @Override
    public void onStart(){
        super.onStart();
        Log.d(TAG,"Метод onStart() запущен");
    }

    @Override
    public void onResume(){
        super.onResume();
        Log.d(TAG,"Метод onResume() запущен");
    }

    @Override
    public void onPause(){
        super.onPause();
        Log.d(TAG,"Метод onPause() запущен");
    }

    @Override
    public void onStop(){
        super.onStop();
        Log.d(TAG,"Метод onStop() запущен");
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.d(TAG,"Метод onDestroy() запущен");
    }

    @Override
    public void onRestart(){
        super.onRestart();
        Log.d(TAG,"Метод onRestart() запущен");
    }
}
