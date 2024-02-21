package com.example.quizmania

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.quizmania.databinding.QuizItemRecyclerRowBinding

class QuizListAdapter(private val quizmodellist:List<QuizModel>):RecyclerView.Adapter<QuizListAdapter.MyViewHolder>() {
    class MyViewHolder(private val binding: QuizItemRecyclerRowBinding):RecyclerView.ViewHolder(binding.root)
    {
        fun bind(model: QuizModel){
            // bind all the views
            binding.apply {
                quizTitleText.text=model.title
                quizSubtitleText.text = model.subtitle
                quizTimeText.text=model.time + "min"
                root.setOnClickListener{
                    val intent = Intent(root.context,QuizActivity::class.java)
                    QuizActivity.questionModelList =model.questionList
                    QuizActivity.time = model.time
                    root.context.startActivity(intent)

                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
      val binding =QuizItemRecyclerRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
     return quizmodellist.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
      holder.bind(quizmodellist[position])
    }
}