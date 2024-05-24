package com.project.kupu_kuapps.main_ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.project.kupu_kuapps.R
import com.project.kupu_kuapps.databinding.FragmentIndonesiaKuisBinding
import com.project.kupu_kuapps.kuis_handlers.Question

class IndonesiaKuisFragment : Fragment() {

    private var _binding: FragmentIndonesiaKuisBinding? = null
    private val binding get() = _binding!!

    private var currentQuestionIndex = 0
    private lateinit var questionList: List<Question>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentIndonesiaKuisBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        questionList = listOf(
            Question(R.drawable.presiden_soeharto, "Beliau adalah Presiden kedua Republik Indonesia", true, "Beliau adalah Jenderal Besar TNI H. M. Soeharto, adalah Presiden kedua Indonesia yang menjabat dari tahun 1967 hingga 1998."),
            // Tambahkan 8 soal lainnya di halaman lain aja
        )

        displayQuestion()

        binding.benarButtonSejIndo.setOnClickListener {
            checkAnswer(true)
        }

        binding.salahButtonSejIndo.setOnClickListener {
            checkAnswer(false)
        }

        binding.menyerahButtonSejIndo.setOnClickListener {
            findNavController().navigate(R.id.action_indonesiaKuisFragment_to_semuaKuis2)
        }
    }

    private fun displayQuestion() {
        val question = questionList[currentQuestionIndex]
        binding.imagePertanyaanKuisSejIndo.setImageResource(question.imagePertanyaan)
        binding.teksPertanyaanSejIndo.text = question.pertanyaan
        binding.feedbackPertanyaanSejIndo.text = ""
    }

    private fun checkAnswer(answer: Boolean) {
        val question = questionList[currentQuestionIndex]
        if (question.correctAnswer == answer) {
            binding.feedbackPertanyaanSejIndo.text = "Yey, benar!\n${question.explanation}"
            binding.nextPertanyaanSejIndo.setOnClickListener {

                // ke soal selanjutnya
            }
        } else {
            binding.feedbackPertanyaanSejIndo.text = "Yah, salah :(\n${question.explanation}"
            binding.nextPertanyaanSejIndo.setOnClickListener {

                // ke soal selanjutnya
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
