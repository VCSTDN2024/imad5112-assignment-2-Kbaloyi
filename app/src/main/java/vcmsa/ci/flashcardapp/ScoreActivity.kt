package vcmsa.ci.flashcardapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import vcmsa.ci.flashcardapp.R

class ScoreActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score)

        val score = intent.getIntExtra("SCORE", 0)
        val scoreTextView = findViewById<TextView>(R.id.scoreTextView)
        val exitButton = findViewById<Button>(R.id.exitButton)

        scoreTextView.text = "Score: $score/3"

        exitButton.setOnClickListener {
            finish()
        }
    }
}