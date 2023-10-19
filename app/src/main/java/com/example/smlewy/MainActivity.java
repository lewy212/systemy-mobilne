package com.example.smlewy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private Button trueButton;
    private Button falseButton;
    private Button nextButton;
    private TextView questionTextView;

    private int Wynik = 0;

    private Question[] questions = new Question[]{
            new Question(R.string.q_activity,true),
            new Question(R.string.q_version,false),
            new Question(R.string.q_find_resources,true),
            new Question(R.string.q_listener,true),
            new Question(R.string.q_resources,true),
            new Question(R.string.q_chrzest,true),
            new Question(R.string.q_messi,true),
            new Question(R.string.q_ronaldo,false)
    };
    private int currentIndex=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        trueButton = findViewById(R.id.true_button);
        falseButton = findViewById(R.id.false_button);
        nextButton = findViewById(R.id.next_button);
        questionTextView = findViewById(R.id.question_text_view);

        trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                trueButton.setEnabled(false);
                falseButton.setEnabled(false);
                checkAnswerCorrectness(true);
            }
        });
        falseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                trueButton.setEnabled(false);
                falseButton.setEnabled(false);
                checkAnswerCorrectness(false);
            }
        });
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(currentIndex==questions.length-1)
                {
                    trueButton.setVisibility(View.GONE);
                    falseButton.setVisibility(View.GONE);
                    nextButton.setVisibility(View.GONE);
                    questionTextView.setText("Twój wynik to: " + Integer.toString(Wynik) + "/"+ Integer.toString(questions.length));
                }else {
                    currentIndex = (currentIndex + 1)%questions.length;
                    setNextQuestion();
                }
            }
        });
        setNextQuestion();
    }
    private void checkAnswerCorrectness(boolean userAnswer){
        boolean correctAnswer = questions[currentIndex].isTrue();
        int resultMessageId = 0;
        if(userAnswer == correctAnswer)
        {
            resultMessageId = R.string.correct_answer;
            Wynik++;
        } else {
            resultMessageId = R.string.incorrect_answer;
        }
        Toast.makeText(this,resultMessageId, Toast.LENGTH_SHORT).show();
    }
    private void setNextQuestion(){
        trueButton.setEnabled(true);
        falseButton.setEnabled(true);
        questionTextView.setText(questions[currentIndex].getQuestionId());
    }
}