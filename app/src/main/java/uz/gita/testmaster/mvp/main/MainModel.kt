package uz.gita.testmaster.mvp.main

import uz.gita.testmaster.data.QuestionData
import uz.gita.testmaster.repository.AppRepository

class MainModel : MainContract.Model {
    private val repository = AppRepository.getInstance()

    override fun getElementarTest(): List<QuestionData> {
        return repository.elementarTest
    }

    override fun getPreIntermediateTest(): List<QuestionData> {
        return repository.preIntermediateTest
    }

    override fun getIntermediateTest(): List<QuestionData> {
        return repository.intermediateTest
    }

    override fun getUpperIntermediateTest(): List<QuestionData> {
        return repository.upperIntermediateTest
    }
}