package com.mikelangdon.quizapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class QuizOverActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String EXTRA_QUIZ_SCORE = "quiz_score";

    private TextView mFinalScoreTextView;

    private Button mQuitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_over);

        mFinalScoreTextView = (TextView) findViewById(R.id.final_score_text_view);
        mQuitButton = (Button) findViewById(R.id.end_of_quiz_quit_button);

        mQuitButton.setOnClickListener(this);

        Intent launchIntent = getIntent();
        String quizScore = launchIntent.getStringExtra(EXTRA_QUIZ_SCORE);

        mFinalScoreTextView.setText("Your Final Score: " + quizScore);

    }

    public static Intent newIntent(Context ctx) {
        Intent ret = new Intent(ctx, QuizOverActivity.class);
        ret.putExtra(EXTRA_QUIZ_SCORE, Question.getScore());
        return ret;

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.end_of_quiz_quit_button) {
            System.exit(0);
        }
    }
}
