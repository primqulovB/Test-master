package uz.gita.testmaster.mvp.main

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import uz.gita.testmaster.R
import uz.gita.testmaster.data.QuestionData
import uz.gita.testmaster.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), MainContract.View {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!
    private lateinit var presenter: MainContract.Presenter
    private val variantTexts = ArrayList<TextView>(4)
    private val variants = ArrayList<LinearLayout>(4)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter = MainPresenter(this)
        variantTexts.add(binding.textVariant1)
        variantTexts.add(binding.textVariant2)
        variantTexts.add(binding.textVariant3)
        variantTexts.add(binding.textVariant4)
        variants.add(binding.variant1)
        variants.add(binding.variant2)
        variants.add(binding.variant3)
        variants.add(binding.variant4)
        clickEvents()
        presenter.showTestByPosition()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun showTest(data: QuestionData) {
        binding.textQuestion.text = data.question
        variantTexts[0].text = data.variant1
        variantTexts[1].text = data.variant2
        variantTexts[2].text = data.variant3
        variantTexts[3].text = data.variant4

        clearOldState()
    }

    override fun shoeResult(currentTestCount: Int, wrongTestCount: Int) {
        clearOldState()
        //Toast.makeText(this, correctCount + " / " + wrongCount, Toast.LENGTH_SHORT).show();
        //Toast.makeText(this, correctCount + " / " + wrongCount, Toast.LENGTH_SHORT).show();
        val v = LayoutInflater.from(this).inflate(R.layout.activity_dialog, null)
        val dialog = AlertDialog.Builder(this)
            .setView(v)
            .setCancelable(false)
            .create()
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.show()

        val currect1 = v.findViewById<TextView>(R.id.currect1)
        val currect2 = v.findViewById<TextView>(R.id.currect2)
        val wrong = v.findViewById<TextView>(R.id.wrong)
        currect2.setText(currentTestCount.toString())
        currect1.setText(currentTestCount.toString())
        wrong.setText((wrongTestCount + 1).toString())

        val exit = v.findViewById<AppCompatButton>(R.id.btnExit)
        val again = v.findViewById<AppCompatButton>(R.id.btnAgain)
        exit.setOnClickListener { V: View? -> finish() }
        again.setOnClickListener { V: View? ->
            presenter.showTestByPosition()
            dialog.dismiss()
        }
    }

    private fun clearOldState() {
        for (i in 0 until variants.size) {
            variants[i].setBackgroundResource(R.drawable.bg_variant_on)
        }
        binding.btnNext.setBackgroundResource(R.drawable.bg_next_on)
    }

    private fun clickEvents() {
        var ansewer = ""

        for (i in 0 until variants.size) {
            variants[i].setOnClickListener {
                clearOldState()
                it.setBackgroundResource(R.drawable.bg_variant_off)
                binding.btnNext.setBackgroundResource(R.drawable.bg_next_off)
                ansewer = variantTexts[i].text.toString()
            }
        }
        binding.btnNext.setOnClickListener {
            presenter.checkUserAnswer(ansewer)
        }
    }
}