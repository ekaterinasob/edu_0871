package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

public class AnswerActivity extends AppCompatActivity {

    private boolean isAnswerTrue;
    private TextView answerTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);

        isAnswerTrue = getIntent().getBooleanExtra("answer",false);
        answerTextView = findViewById(R.id.answerTextView);

        // answerTextView.setText("Ответ на вопрос: "+(isAnswerTrue?"Да":"Нет"));

        if (isAnswerTrue)
            answerTextView.setText("Ответ на вопрос Да");
        else
            answerTextView.setText("Ответ на вопрос Нет");
    }
}
