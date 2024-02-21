package com.example.quizmania

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quizmania.databinding.ActivityMainBinding
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var quizmodellist:MutableList<QuizModel>
    lateinit var adapter: QuizListAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        installSplashScreen()
        Thread.sleep(1000)
        // intialize the quizmodel
        quizmodellist = mutableListOf()
        getDataFromFirebase()
        //Change 1 here
    }

    private fun setupRecyclerView() {
        binding.ProgressBar.visibility =View.GONE

       adapter = QuizListAdapter(quizmodellist)
        // layout Manager
        binding.recyclerView.layoutManager=LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter
    }
    private fun getDataFromFirebase()

    {
        binding.ProgressBar.visibility =View.VISIBLE
        FirebaseDatabase.getInstance().reference
            .get()
            .addOnSuccessListener { dataSnapshot->
                if (dataSnapshot.exists())
                {
                    for (snapshot in dataSnapshot.children)
                    {
                        val quizModel =snapshot.getValue(QuizModel::class.java)
                        if (quizModel != null) {
                            quizmodellist.add(quizModel)
                        }
                    }

            }
                setupRecyclerView()
    }


















//        // dummy data
//        val listQuestionModel = mutableListOf<QuestionModel>()
//        listQuestionModel.add(QuestionModel("What is Android?", mutableListOf("Language","Os","Product","None"),"Os"))
//        listQuestionModel.add(QuestionModel("What owns Android?", mutableListOf("Apple","Google","Samsung","Microsoft"),"Google"))
//        listQuestionModel.add(QuestionModel("Which Assistant android Uses?", mutableListOf("Siri","Cortana","Google Assistant","Alexa"),"Google Assistant"))
//      quizmodellist.add(QuizModel("1","Programming","All the basic programmimg","10",listQuestionModel))
//




//        quizmodellist.add(QuizModel("2","Computer","All the computer question","10"))
//        quizmodellist.add(QuizModel("3","Android","All the basic fundamentals","10"))



    }

}