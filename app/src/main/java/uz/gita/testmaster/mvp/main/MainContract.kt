package uz.gita.testmaster.mvp.main

import uz.gita.testmaster.data.QuestionData

interface MainContract {

    interface Model {
        fun getElementarTest(): List<QuestionData>
        fun getPreIntermediateTest(): List<QuestionData>
        fun getIntermediateTest(): List<QuestionData>
        fun getUpperIntermediateTest(): List<QuestionData>
    }

    interface View {
        fun showTest(data: QuestionData)
        fun shoeResult(currentTestCount: Int, wrongTestCount: Int)
    }

    interface Presenter {
        fun showTestByPosition()

        fun checkUserAnswer(userAnswer: String)
    }
}