package com.example.funi

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_end.*

class EndActivity : AppCompatActivity() {
    private var myQuizScreen = QuizScreen()
    private var name : String? = null
    private var subject : CharSequence? = null
    private var gradeLevel : String? = null
    private var numIncorrect : Int? = null
    private var time : Double? = null
    private var selectedGradePosition = 0
    private var leaderboard: Leaderboard? = null
    private var listView: ListView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_end)

        name = intent.getStringExtra("playerName")
        subject = intent.getCharSequenceExtra("subject")
        gradeLevel = intent.getStringExtra("gradeLevel")
        numIncorrect = intent.getIntExtra("numIncorrect", 0)
        time = intent.getDoubleExtra("time", 0.0)

        gameOverTextview.text = "Game Over, $name"

        if(numIncorrect!! < 3) {
            showAlert()
        }
        displayLeaderBoard()
        //try again event listener
        tryAgainButton.setOnClickListener{
            when(gradeLevel) {
                "pre-school" -> selectedGradePosition = 0
                "kindergarten" -> selectedGradePosition = 1
                "1st grade" -> selectedGradePosition = 2
                "2nd grade" -> selectedGradePosition = 3
                "3rd grade" -> selectedGradePosition = 4
            }
            name?.let { it1 -> subject?.let { it2 ->
                myQuizScreen.quiz(selectedGradePosition, it1,
                    it2
                )
            } }
            val intent = Intent(this, QuizActivity::class.java)
            intent.putExtra("playerName", myQuizScreen.name)
            intent.putExtra("subject", myQuizScreen.subject)
            intent.putExtra("gradeLevel", myQuizScreen.gradeLevel)
            startActivity(intent)
        }

        //switch subject event listener
        switchSubjectButton.setOnClickListener {
            when(gradeLevel) {
                "pre-school" -> selectedGradePosition = 0
                "kindergarten" -> selectedGradePosition = 1
                "1st grade" -> selectedGradePosition = 2
                "2nd grade" -> selectedGradePosition = 3
                "3rd grade" -> selectedGradePosition = 4
            }
            when(subject) {
                "Reading" -> subject = "Math"
                "Math" -> subject = "Reading"
            }
            println(name + " " + subject + " " + gradeLevel)
            name?.let { it1 -> subject?.let { it2 -> myQuizScreen.quiz(selectedGradePosition, it1, it2) } }
            println("myQuizScreenName"+ myQuizScreen.name)
            val intent = Intent(this, QuizActivity::class.java)
            intent.putExtra("playerName", myQuizScreen.name)
            intent.putExtra("subject", myQuizScreen.subject)
            intent.putExtra("gradeLevel", myQuizScreen.gradeLevel)
            startActivity(intent)
        }

        //start over event listener
        startOverrButton.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun showAlert() {
        val alertDialogBuilder = AlertDialog.Builder(this)
        alertDialogBuilder.setTitle("Congratulations, $name!")
        alertDialogBuilder.setMessage("Would you like to add your name to the Funi leader board?")
        //alertDialogBuilder.setIcon(R.drawable)
        alertDialogBuilder.setPositiveButton("Yes") { dialog, _ ->  dialog.dismiss()
        addToLeaderBoard()
        }
        alertDialogBuilder.setNegativeButton("No") { dialog, _ ->  dialog.dismiss()
        }
        val alert: AlertDialog = alertDialogBuilder.create()
        alert.show()

    }

    private fun displayLeaderBoard() {
        listView = leaderboardListView
        when(gradeLevel) {
            "pre-school" -> leaderBoardTextview.text = "Pre-School $subject Leader Board"
        }
        val test = Array(5){
            "blah"
        }

        val adapter : ArrayAdapter<String> = ArrayAdapter<String>(
            this,
            android.R.layout.simple_list_item_1,
            test
        )
        listView?.adapter = adapter
    }

    private fun addToLeaderBoard() {
        println("Added $name to leader board")
        val player = numIncorrect?.let { Player(name, gradeLevel, subject.toString(), time, it) }
    }

}