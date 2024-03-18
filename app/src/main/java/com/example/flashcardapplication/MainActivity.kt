package com.example.flashcardapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {


    private var answersVisible = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val flashcardQuestion = findViewById<TextView>(R.id.flashcard_question)
        val flashcardAnswer = findViewById<TextView>(R.id.flashcard_answer)
        val flashcardAnswer1 = findViewById<TextView>(R.id.flashcard_answer1)
        val flashcardAnswer2 = findViewById<TextView>(R.id.flashcard_answer2)
        val isShowingAnswers = findViewById<ImageView>(R.id.toggle_choices_visibility)
        val ishow1 = findViewById<ImageView>(R.id.toggle123)

        val correctAnswer = "Barack Obama"

        flashcardAnswer.setOnClickListener {
            handleAnswerClick(flashcardAnswer, correctAnswer)
        }

        flashcardAnswer1.setOnClickListener {
            handleAnswerClick(flashcardAnswer1, correctAnswer)
        }

        flashcardAnswer2.setOnClickListener {
            handleAnswerClick(flashcardAnswer2, correctAnswer)
        }

        isShowingAnswers.setOnClickListener {
            toggleAnswersVisibility(isShowingAnswers, ishow1)
        }

        ishow1.setOnClickListener {
            toggleAnswersVisibility(isShowingAnswers, ishow1)
        }
    }

    private fun handleAnswerClick(answerTextView: TextView, correctAnswer: String) {
        if (answerTextView.text == correctAnswer) {
            answerTextView.setBackgroundResource(R.color.Green)
        } else {
            answerTextView.setBackgroundResource(R.color.Red)
            showCorrectAnswer(correctAnswer)
        }
        findViewById<TextView>(R.id.flashcard_question).visibility = View.VISIBLE
    }

    private fun showCorrectAnswer(correctAnswer: String) {
        val flashcardAnswer = findViewById<TextView>(R.id.flashcard_answer)
        val flashcardAnswer1 = findViewById<TextView>(R.id.flashcard_answer1)
        val flashcardAnswer2 = findViewById<TextView>(R.id.flashcard_answer2)
        when (correctAnswer) {
            flashcardAnswer.text -> flashcardAnswer.setBackgroundResource(R.color.Green)
            flashcardAnswer1.text -> flashcardAnswer1.setBackgroundResource(R.color.Green)
            flashcardAnswer2.text -> flashcardAnswer2.setBackgroundResource(R.color.Green)
        }
    }

    private fun toggleAnswersVisibility(isShowingAnswers: ImageView, ishow1: ImageView) {
        answersVisible = !answersVisible
        if (answersVisible) {
            isShowingAnswers.setImageResource(R.drawable.iconmonstr_eye_thin)
            ishow1.visibility = View.VISIBLE
            isShowingAnswers.visibility = View.INVISIBLE

            val flashcardAnswer = findViewById<TextView>(R.id.flashcard_answer)
            val flashcardAnswer1 = findViewById<TextView>(R.id.flashcard_answer1)
            val flashcardAnswer2 = findViewById<TextView>(R.id.flashcard_answer2)

            flashcardAnswer.visibility = View.VISIBLE
            flashcardAnswer1.visibility = View.VISIBLE
            flashcardAnswer2.visibility = View.VISIBLE
        } else {
            ishow1.setImageResource(R.drawable.iconmonstr_eye_off_thin)
            ishow1.visibility = View.INVISIBLE
            isShowingAnswers.visibility = View.VISIBLE

            val flashcardAnswer = findViewById<TextView>(R.id.flashcard_answer)
            val flashcardAnswer1 = findViewById<TextView>(R.id.flashcard_answer1)
            val flashcardAnswer2 = findViewById<TextView>(R.id.flashcard_answer2)

            flashcardAnswer.visibility = View.INVISIBLE
            flashcardAnswer1.visibility = View.INVISIBLE
            flashcardAnswer2.visibility = View.INVISIBLE
        }
    }
}