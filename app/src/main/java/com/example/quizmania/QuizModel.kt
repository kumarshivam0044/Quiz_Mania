package com.example.quizmania

data class QuizModel(
    val id :String,
    val title:String,
    val subtitle:String,
    val time: String,
    val questionList:List<QuestionModel>
)
{
    // empty constructor....
    constructor():this("","","","", emptyList())
}
data class QuestionModel(
    val question: String,
    val options:List<String>,
    val correct: String,
){
    constructor():this("", emptyList(),"")
}
