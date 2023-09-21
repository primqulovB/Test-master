package uz.gita.testmaster.mvp.main

class MainPresenter constructor(private val view: MainContract.View) : MainContract.Presenter {
    private val model: MainContract.Model
    private var testPosition = 0
    private var currectTestCount = 0
    private var wrongTestCount = 0

    init {
        model = MainModel()
    }

    override fun showTestByPosition() {
        if (testPosition < model.getElementarTest().size - 1) {
            view.showTest(model.getElementarTest()[testPosition])
        } else {
            view.shoeResult(currectTestCount, wrongTestCount)
        }
    }

    override fun checkUserAnswer(userAnswer: String) {
        if (model.getElementarTest().get(testPosition).answer.equals(userAnswer)) {
            currectTestCount++
        } else {
            wrongTestCount++
        }
        showTestByPosition()
        testPosition++
    }
}