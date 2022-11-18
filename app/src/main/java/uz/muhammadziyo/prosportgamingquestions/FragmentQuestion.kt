package uz.muhammadziyo.prosportgamingquestions

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import uz.muhammadziyo.prosportgamingquestions.Mydata.correct
import uz.muhammadziyo.prosportgamingquestions.Mydata.incorrect
import uz.muhammadziyo.prosportgamingquestions.databinding.FragmentQuestionBinding
import uz.muhammadziyo.prosportgamingquestions.databinding.ItemDialogBinding
import uz.muhammadziyo.sportgametask6.models.Question


class FragmentQuestion : Fragment() {

    private lateinit var list: ArrayList<Question>
    private var position = 0
    var answer = true
    private lateinit var listviews: ArrayList<View>
    private lateinit var listchekk: ArrayList<ImageView>
    private lateinit var binding: FragmentQuestionBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentQuestionBinding.inflate(layoutInflater)
        correct = 0
        incorrect = 0
        listviews = ArrayList()
        list = ArrayList()
        listviews.add(binding.answer1contratint)
        listviews.add(binding.answer2contratint)
        listviews.add(binding.answer3contratint)
        listviews.add(binding.answer4contratint)

        listchekk = ArrayList()
        listchekk.add(binding.answer1check)
        listchekk.add(binding.answer2check)
        listchekk.add(binding.answer3check)
        listchekk.add(binding.answer4check)

        loadList()
        loadQuestion()


        binding.answer1.setOnClickListener {
            if (answer) {
                chekAnswer(1)
                answer = false
            } else {

            }


        }


        binding.answer2.setOnClickListener {
            if (answer) {
                chekAnswer(2)
                answer = false
            } else {

            }

        }

        binding.answer3.setOnClickListener {
            if (answer) {
                chekAnswer(3)
                answer = false
            } else {

            }


        }

        binding.answer4.setOnClickListener {
            if (answer) {
                chekAnswer(4)
                answer = false
            } else {

            }

        }

        binding.right.setOnClickListener {
            if (position + 1 == list.size) {
                Toast.makeText(binding.root.context, "Full!", Toast.LENGTH_SHORT).show()
                alertdialog()
            } else {
                if (!answer) {
                    answer = true
                    position += 1
                    loadQuestion()
                } else {
                    Snackbar.make(it, "answer the question!", 2000).show()
                }

            }


        }
        binding.left.setOnClickListener {

            if (position == 0) {
                Toast.makeText(binding.root.context, "Full!", Toast.LENGTH_SHORT).show()
                Mydata.incorrect = 0
                Mydata.correct = 0
            } else {
                position -= 1
                val son = correct
                correct = son!! - 1

                val son1 = incorrect
                incorrect = son1!! - 1
                loadQuestion()
            }
        }

        binding.imgClose.setOnClickListener {
            findNavController().popBackStack()
        }




        return binding.root
    }

    private fun loadList() {
//shunchaki Question clasini to'ldiring o'zi hamma ishni qiladi.
        //correct answerga to'g'ri javopni raqami bilan yozing 4 gacha

        list.add(Question("How many players are there on a baseball team?",
            "8",
            "9",
            "10",
            "11",
            2))

        list.add(Question("In which year did Amir Khan win his Olympic boxing medal?",
            "2020",
            "2018",
            "2008",
            "2004",
            4))


        list.add(Question("What year did boxing become a legal sport? ",
            "1921",
            "1901",
            "1931",
            "1911",
            2))

        list.add(Question(" How many times did Efren Reyes win the World Pool League championship?",
            "1",
            "2",
            "3",
            "4",
            2))

        list.add(Question("How many players are there in a futsal (indoor soccer) team?",
            "5",
            "6",
            "7",
            "8",
            1))

        list.add(Question("How many paddles are used in a kayak?",
            "1",
            "2",
            "3",
            "4",
            1))

        list.add(Question("How many balls are there in snooker? ",
            "19",
            "16",
            "56",
            "22",
            4))

        list.add(Question(" In what year was the Football World Cup first held? ",
            "1855",
            "1990",
            "1920",
            "1930",
            4))

        list.add(Question("How old was Pele when he scored in his first Football World Cup final?",
            "17",
            "18",
            "19",
            "20",
            1))

        list.add(Question("The United States men’s Olympic basketball team, nicknamed the “Dream Team”, competed in which year at the Olympics?",
            "2008",
            "1990",
            "1992",
            "1993",
            3))

//        list.add(Question("When New Zealand won the firt Rugby World Cup?",
//            "1990",
//            "1987",
//            "1995",
//            "1994",
//            2))

    }


    private fun loadQuestion() {

        binding.txtQuestion.text = list[position].question
        binding.txtAnswer1.text = list[position].answer1
        binding.txtAnswer2.text = list[position].answer2
        binding.txtAnswer3.text = list[position].answer3
        binding.txtAnswer4.text = list[position].answer4

        binding.answer1contratint.setBackgroundResource(R.color.myColorBlue)
        binding.answer2contratint.setBackgroundResource(R.color.myColorBlue)
        binding.answer3contratint.setBackgroundResource(R.color.myColorBlue)
        binding.answer4contratint.setBackgroundResource(R.color.myColorBlue)

        binding.answer1check.setImageResource(R.drawable.ic_tick)
        binding.answer2check.setImageResource(R.drawable.ic_tick)
        binding.answer3check.setImageResource(R.drawable.ic_tick)
        binding.answer4check.setImageResource(R.drawable.ic_tick)

        binding.answer1check.visibility = View.INVISIBLE
        binding.answer2check.visibility = View.INVISIBLE
        binding.answer3check.visibility = View.INVISIBLE
        binding.answer4check.visibility = View.INVISIBLE

    }


    @SuppressLint("WrongConstant")
    fun chekAnswer(answer: Int) {


        if (list[position].correctAnswer == answer) {
            listviews[answer - 1].setBackgroundResource(R.color.myColorBlue)
            listchekk[answer - 1].visibility = View.VISIBLE
            val son = correct
            correct = son!! + 1
            Toast.makeText(binding.root.context, "Correct!", 1000).show()
        } else {
            listviews[answer - 1].setBackgroundResource(R.color.myColorPink)
            listchekk[answer - 1].setImageResource(R.drawable.ic_cross)
            listchekk[answer - 1].visibility = View.VISIBLE
            listviews[list[position].correctAnswer - 1].setBackgroundResource(R.color.myColorBlue)
            listchekk[list[position].correctAnswer - 1].setImageResource(R.drawable.ic_tick)
            listchekk[list[position].correctAnswer - 1].visibility = View.VISIBLE
            val son = incorrect
            incorrect = son!! + 1

        }


    }

    @SuppressLint("SetTextI18n")
    private fun alertdialog() {
        val alertDialog = AlertDialog.Builder(binding.root.context).create()
        val itemDialogBinding = ItemDialogBinding.inflate(LayoutInflater.from(binding.root.context))
        itemDialogBinding.correct.text = "correct answer: $correct"
        itemDialogBinding.incorrect.text = "incorrect answer: $incorrect"
        itemDialogBinding.btnNewstart.setOnClickListener {
            position = 0
            loadQuestion()
            alertDialog.cancel()
            Mydata.incorrect = 0
            Mydata.correct = 0
        }
        alertDialog.setView(itemDialogBinding.root)
        alertDialog.show()
    }


}