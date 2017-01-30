package com.csci448.npohl.npohl_a1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static com.csci448.npohl.npohl_a1.QuestionType.TF;
import static com.csci448.npohl.npohl_a1.QuestionType.MC;
import static com.csci448.npohl.npohl_a1.QuestionType.FR;

public class QuizActivity extends AppCompatActivity {

    private static final String TAG = "QuizActivity";
    private static final String KEY_INDEX = "index";

    private Button mTrueButton;
    private Button mFalseButton;
    private Button mNextButton;
    private Button mPrevButton;
    private Button mAButton;
    private Button mBButton;
    private Button mCButton;
    private Button mDButton;
    private Button mSubmitButton;
    private TextView mQuestionTextView;
    private EditText mFreeResponseAnswer;

    private Question[] mQuestionBank = new Question[] {
        new Question(R.string.question_americas, R.string.true_button, TF),
        new Question(R.string.question_landmass, R.string.answer_landmass_b, MC),
        new Question(R.string.question_population, R.string.answer_population, FR)
    };

    private int mCurrentIndex = 0;

    private void updateQuestion() {
        int question = mQuestionBank[mCurrentIndex].getTextResId();
        mQuestionTextView.setText(question);

        QuestionType type = mQuestionBank[mCurrentIndex].getQuestionType();

        if (type == TF) {
            mTrueButton.setVisibility(View.VISIBLE);
            mFalseButton.setVisibility(View.VISIBLE);
            mAButton.setVisibility(View.GONE);
            mBButton.setVisibility(View.GONE);
            mCButton.setVisibility(View.GONE);
            mDButton.setVisibility(View.GONE);
            mFreeResponseAnswer.setVisibility(View.GONE);
            mFreeResponseAnswer.setText("");
            mSubmitButton.setVisibility(View.GONE);
        }

        else if (type == MC) {
            mTrueButton.setVisibility(View.GONE);
            mFalseButton.setVisibility(View.GONE);
            mAButton.setVisibility(View.VISIBLE);
            mBButton.setVisibility(View.VISIBLE);
            mCButton.setVisibility(View.VISIBLE);
            mDButton.setVisibility(View.VISIBLE);
            mFreeResponseAnswer.setVisibility(View.GONE);
            mFreeResponseAnswer.setText("");
            mSubmitButton.setVisibility(View.GONE);
        }

        else if (type == FR) {
            mTrueButton.setVisibility(View.GONE);
            mFalseButton.setVisibility(View.GONE);
            mAButton.setVisibility(View.GONE);
            mBButton.setVisibility(View.GONE);
            mCButton.setVisibility(View.GONE);
            mDButton.setVisibility(View.GONE);
            mFreeResponseAnswer.setVisibility(View.VISIBLE);
            mFreeResponseAnswer.setText("");
            mSubmitButton.setVisibility(View.VISIBLE);
        }

    }

    /**
     * This checkAnswer checks for the correct answer of both TF and MC types
     *
     * checkAnswer(int) is used when the TF and MC types of questions are asked. It is called
     * whenever the true, false, a, b, c, and d buttons are hit. It takes the text from the button
     * and checks it against the string for the answer. TF uses the true_button and false_button
     * text, while the MC uses the text on its respective buttons.
     *
     * @param buttonResId the id of the button that has been clicked
     */
    private void checkAnswer(int buttonResId) {

        int answer = mQuestionBank[mCurrentIndex].getAnswerResId();

        int messageResId = 0;

        if (answer == buttonResId) {
            messageResId = R.string.correct_toast;
        }
        else {
            messageResId = R.string.incorrect_toast;
        }

        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show();
    }

    private void checkAnswer(String userAnswer) {

        int answer = mQuestionBank[mCurrentIndex].getAnswerResId();

        int messageResId = 0;
        /*
        TODO: Check how to access the string refrenced by the res id
         */
        if (true) {
            messageResId = R.string.correct_toast;
        }
        else {
            messageResId = R.string.incorrect_toast;
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate(Bundle) called");
        setContentView(R.layout.activity_quiz);

        mQuestionTextView = (TextView) findViewById(R.id.question_text_view);
        mQuestionTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
                updateQuestion();
            }
        });

        mFreeResponseAnswer = (EditText) findViewById(R.id.fr_answer);

        mTrueButton = (Button) findViewById(R.id.true_button);
        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(R.id.true_button);
            }
        });

        mFalseButton = (Button) findViewById(R.id.false_button);
        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(R.id.false_button);
            }
        });

        mNextButton = (Button) findViewById(R.id.next_button);
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
                updateQuestion();
            }
        });

        mPrevButton = (Button) findViewById(R.id.prev_button);
        mPrevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex = (mCurrentIndex - 1);
                if (mCurrentIndex == -1) {
                    mCurrentIndex = mQuestionBank.length - 1;
                }
                updateQuestion();
            }
        });

        mAButton = (Button) findViewById(R.id.a_button);
        mAButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(R.id.a_button);
            }
        });

        mBButton = (Button) findViewById(R.id.b_button);
        mBButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(R.id.b_button);
            }
        });

        mCButton = (Button) findViewById(R.id.c_button);
        mCButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(R.id.c_button);
            }
        });

        mDButton = (Button) findViewById(R.id.d_button);
        mDButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(R.id.d_button);
            }
        });

        mSubmitButton = (Button) findViewById(R.id.submit_button);
        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(R.id.submit_button);
            }
        });

        if (savedInstanceState != null) {
            mCurrentIndex = savedInstanceState.getInt(KEY_INDEX, 0);
        }

        updateQuestion();
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        Log.i(TAG, "onSaveInstanceState");
        savedInstanceState.putInt(KEY_INDEX, mCurrentIndex);
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart() called");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause() called");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume() called");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "onStop() called");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy() called");
    }

}
