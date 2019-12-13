package com.ithub.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private int mScoreCounter;                  // variable to hold current score

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Method checks for the correct answer in Question 1 and updates the current score appropriately
    private void checkQuestionOneAnswer(){
        RadioButton rightAnswer = findViewById(R.id.questionOne_OptionOne);
        if(rightAnswer.isChecked()){
            updateScore();
        }
    }

    // Method checks for the correct answer in Question 2 and updates the current score appropriately
    private void checkQuestionTwoAnswer(){
        RadioButton rightAnswer = findViewById(R.id.questionTwo_OptionThree);
        if(rightAnswer.isChecked()){
            updateScore();
        }
    }

    // Method checks for the correct answer in Question 3 and updates the current score appropriately
    private void checkQuestionThreeAnswer(){
        RadioButton rightAnswer = findViewById(R.id.questionThree_OptionOne);
        if(rightAnswer.isChecked()){
            updateScore();
        }
    }

    // Method checks for the correct answer in Question 4 and updates the current score appropriately
    private void checkQuestionFourAnswer(){
        RadioButton rightAnswer = findViewById(R.id.questionFour_OptionTwo);
        if(rightAnswer.isChecked()){
            updateScore();
        }
    }

    // Method checks for the correct answer in Question 5 and updates the current score appropriately
    private void checkQuestionFiveAnswer(){
        CheckBox optionOne = findViewById(R.id.chkbox_question_optionOne);
        CheckBox optionTwo = findViewById(R.id.chkbox_question_optionTwo);
        CheckBox optionThree = findViewById(R.id.chkbox_question_optionThree);
        if(optionOne.isChecked() && !optionTwo.isChecked() && optionThree.isChecked()){
            updateScore();
        }
    }

    // Method checks for the correct answer in Question 6 and updates the current score appropriately
    private void checkQuestionSixAnswer(){
        EditText userInput = findViewById(R.id.questionSix_txt);
        String rightAnswer = "drawable";
        String getUserInput = userInput.getText().toString();
        if(rightAnswer.equals(getUserInput)){
            updateScore();
        }
    }

    // Method calls the methods on all questions answered
    private void getAllAnswers(){
        checkQuestionOneAnswer();
        checkQuestionTwoAnswer();
        checkQuestionThreeAnswer();
        checkQuestionFourAnswer();
        checkQuestionFiveAnswer();
        checkQuestionSixAnswer();
    }

    //Displays the score of the user in a toast
    public void displayQuizScore(View view) {
        EditText editName = findViewById(R.id.txt_name);
        String getName = editName.getText().toString();
        if (getName.isEmpty()){
            getName = "";
        }
        int mTotalScore = 6;
        getAllAnswers();
        if (mScoreCounter==6) {
            Toast.makeText(this, getName + "\n***CONGRATULATIONS***\n\nYou scored:  " + mScoreCounter + "\n   out of     :  " + mTotalScore, Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this, getName + "\n***ALMOST THERE***\n\nYou scored:  " + mScoreCounter + "\n   out of     :  " + mTotalScore, Toast.LENGTH_LONG).show();
        }
        resetScore();
        clearCheckedOptions();
    }

    //Adds and update the current score of the user if the answer is correct
    private void updateScore() {
        mScoreCounter++;
    }

    //Resets the current score to 0 after the results have been displayed on screen
    private void resetScore() {
        mScoreCounter = 0;
    }

    //Clears the options checked for the user to restart the quiz
    private void clearCheckedOptions(){
        RadioGroup uncheckOne = findViewById(R.id.rbtn_question_one);
        RadioGroup uncheckTwo = findViewById(R.id.rbtn_question_two);
        RadioGroup uncheckThree = findViewById(R.id.rbtn_question_three);
        RadioGroup uncheckFour = findViewById(R.id.rbtn_question_four);
        CheckBox uncheckFive = findViewById(R.id.chkbox_question_optionOne);
        CheckBox uncheckFiveTwo = findViewById(R.id.chkbox_question_optionTwo);
        CheckBox uncheckFiveThree = findViewById(R.id.chkbox_question_optionThree);
        EditText uncheckSix = findViewById(R.id.questionSix_txt);
        uncheckOne.clearCheck();
        uncheckTwo.clearCheck();
        uncheckThree.clearCheck();
        uncheckFour.clearCheck();
        uncheckFive.setChecked(false);
        uncheckFiveTwo.setChecked(false);
        uncheckFiveThree.setChecked(false);
        uncheckSix.setText("");
    }

}
