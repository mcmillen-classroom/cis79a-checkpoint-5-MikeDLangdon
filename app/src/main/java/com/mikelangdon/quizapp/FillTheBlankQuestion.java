package com.mikelangdon.quizapp;

import android.content.Context;

import java.util.Arrays;

public class FillTheBlankQuestion extends Question {
    private String[] mFillAnswers;

    public FillTheBlankQuestion(int textResId, int hintTextResId, String[] fillAnswers) {
        super(textResId, hintTextResId);
        mFillAnswers = fillAnswers;
    }

    // fill the blank question check
    @Override
    public boolean checkAnswer(String userAnswer)
    {
        for (String ans : mFillAnswers)
        {
            if (ans.equalsIgnoreCase(userAnswer))
            {
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean isFillTheBlankQuestion() {
        return true;
    }

    @Override
    public String getAnswerText(Context ctx) {
        return Arrays.toString(mFillAnswers);
    }
}
