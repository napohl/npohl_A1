package com.csci448.npohl.npohl_a1;

/**
 * Created by Nate on 1/13/2017.
 */

enum QuestionType {
    TF, MC, FR
}

public class Question {
    private int mTextResId;
    private int mAnswerResId;
    private QuestionType mType;

    /**
     * Question class holds the questions to be asked and the answers to those questions.
     *
     * The Question class can be either True/false, multiple choice, or free response.
     * All answers are in the form of a string in the strings.xml file, which means that
     * regardless of type, the Question class can still function the same. Depending on
     * what kind of question is asked, the controller will update the view to show the
     * correct buttons/textbox necessary for the question.
     *
     * @param textResId string id of the question
     * @param answerResId string id of the answer
     * @param type type of question: TF (true/false), MC (multiple choice), FR (free response)
     */
    public Question(int textResId, int answerResId, QuestionType type) {
        mTextResId = textResId;
        mAnswerResId = answerResId;
        mType = type;
    }

    public int getTextResId() {
        return mTextResId;
    }

    public void setTextResId(int textResId) {
        mTextResId = textResId;
    }

    public int getAnswerResId() {
        return mAnswerResId;
    }

    public void setAnswerResId(int answerResId) {
        mAnswerResId = answerResId;
    }

    public QuestionType getQuestionType() {
        return mType;
    }

    public void setQuestionType(QuestionType type) {
        mType = type;
    }
}
