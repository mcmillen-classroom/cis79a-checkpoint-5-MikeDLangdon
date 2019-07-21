package com.mikelangdon.quizapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CheatActivity extends AppCompatActivity implements View.OnClickListener {


    public static final String EXTRA_QUESTION_TEXT = "question_text";
    public static final String EXTRA_ANSWER_TEXT = "answer_text";
    private TextView mCheatQuestionTextView;
    private TextView mCheatAnswerTextView;

    private Button mCheatShowAnswerButton;

    private String mAnswerText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);

        mCheatQuestionTextView = (TextView) findViewById(R.id.cheat_question_text_view);
        mCheatAnswerTextView = (TextView) findViewById(R.id.cheat_answer_text_view);

        mCheatShowAnswerButton = (Button) findViewById(R.id.cheat_show_answer_button);

        mCheatShowAnswerButton.setOnClickListener(this);

        Intent launchIntent = getIntent();
        String questionText = launchIntent.getStringExtra(EXTRA_QUESTION_TEXT);
        mCheatQuestionTextView.setText(questionText);

        mAnswerText = launchIntent.getStringExtra(EXTRA_ANSWER_TEXT);
    }

    @Override
    public void onClick(View v) {
        mCheatAnswerTextView.setText(mAnswerText);

        Intent resIntent = new Intent();
        resIntent.putExtra("did_cheat", true);
        setResult(RESULT_OK, resIntent);

    }

    public static Intent newIntent(Context ctx, Question question) {
        Intent ret = new Intent(ctx, CheatActivity.class);
        ret.putExtra(EXTRA_QUESTION_TEXT, question.getText(ctx));
        ret.putExtra(EXTRA_ANSWER_TEXT, question.getAnswerText(ctx));
        return ret;

    }

    public static boolean didCheat(Intent resultData) {
        return resultData.getBooleanExtra("did_cheat", false);
    }
}
