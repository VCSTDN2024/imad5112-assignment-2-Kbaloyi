package vcmsa.ci.flashcardapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import vcmsa.ci.flashcardapp.R

class QuizActivity : AppCompatActivity() {
    private val questions = listOf(
        "Nelson Mandela was president in 1994?",
        "The Berlin Wall fell in 1989?",
        "WWII ended in 1945?"
    )
    private val answers = listOf(true, true, true)
    private var currentQuestion = 0
    private var score = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        val questionTextView = findViewById<TextView>(R.id.questionTextView)
        val feedbackTextView = findViewById<TextView>(R.id.feedbackTextView)
        val trueButton = findViewById<Button>(R.id.trueButton)
        val falseButton = findViewById<Button>(R.id.falseButton)
        val nextButton = findViewById<Button>(R.id.nextButton)

        questionTextView.text = questions[currentQuestion]

        trueButton.setOnClickListener {
            checkAnswer(true, feedbackTextView, nextButton)
        }

        falseButton.setOnClickListener {
            checkAnswer(false, feedbackTextView, nextButton)
        }

        nextButton.setOnClickListener {
            currentQuestion++
            if (currentQuestion < questions.size) {
                questionTextView.text = questions[currentQuestion]
                feedbackTextView.text = ""
                nextButton.visibility = View.INVISIBLE
            } else {
                val intent = Intent(this, ScoreActivity::class.java)
                intent.putExtra("SCORE", score)
                startActivity(intent)
            }
        }
    }

    private fun checkAnswer(answer: Boolean, feedback: TextView, nextButton: Button) {
        if (answer == answers[currentQuestion]) {
            score++
            feedback.text = "Correct!"
        } else {
            feedback.text = "Incorrect!"
        }
        nextButton.visibility = View.VISIBLE
    }
}