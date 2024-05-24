package com.project.kupu_kuapps.unused_files//package com.project.kupu_kuapps
//
//import android.os.Bundle
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.fragment.app.Fragment
//import androidx.navigation.fragment.findNavController
//import com.project.kupu_kuapps.databinding.FragmentQuizBinding
//
//class QuizFragment : Fragment() {
//
//    private var _binding: FragmentQuizBinding? = null
//    private val binding get() = _binding!!
//
//    private var currentQuestionIndex = 0
//    private lateinit var questionList: List<Question>
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        _binding = FragmentQuizBinding.inflate(inflater, container, false)
//        return binding.root
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        questionList = listOf(
//            Question(R.mipmap.sejarah_indonesia, "Candi Borobudur adalah candi Buddha terbesar di Indonesia dan di dunia.", true, "Candi Borobudur adalah candi Buddha terbesar di Indonesia dan di dunia."),
//            Question(R.mipmap.sejarah_dunia, "Mata Uang Negara Vietnam adalah Baht.", false, "Mata uang negara Vietnam adalah Dong Vietnam (VND). Nilai 1 Dong Vietnam (VND) adalah 0.000042 atau 1 dolar AS sama dengan 24.005,00 Dong Vietnam (VND)."),
//            // Tambahkan 8 soal lainnya
//        )
//
//        displayQuestion()
//
//        binding.trueButton.setOnClickListener {
//            checkAnswer(true)
//        }
//
//        binding.falseButton.setOnClickListener {
//            checkAnswer(false)
//        }
//
//        binding.giveUpButton.setOnClickListener {
//            findNavController().navigate(R.id.action_quizFragment_to_quizListFragment)
//        }
//    }
//
//    private fun displayQuestion() {
//        val question = questionList[currentQuestionIndex]
//        binding.questionImage.setImageResource(question.imageResId)
//        binding.questionText.text = question.questionText
//        binding.feedbackText.text = ""
//    }
//
//    private fun checkAnswer(answer: Boolean) {
//        val question = questionList[currentQuestionIndex]
//        if (question.correctAnswer == answer) {
//            binding.feedbackText.text = "Yey, benar!\n${question.explanation}"
//        } else {
//            binding.feedbackText.text = "Yah, salah :(\n${question.explanation}"
//        }
//    }
//
//    override fun onDestroyView() {
//        super.onDestroyView()
//        _binding = null
//    }
//}
