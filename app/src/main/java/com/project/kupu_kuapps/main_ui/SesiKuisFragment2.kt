package com.project.kupu_kuapps.main_ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.project.kupu_kuapps.R
import com.project.kupu_kuapps.databinding.FragmentSesiKuis2Binding
import com.project.kupu_kuapps.kuis_handlers.Question


class SesiKuisFragment2 : Fragment() {
    private var _binding: FragmentSesiKuis2Binding? = null
    private val binding get() = _binding!!

    private var currentQuestionIndex = 0
    private lateinit var questionList: List<Question>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSesiKuis2Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        questionList = listOf(
//            Question(R.mipmap.vietnam, "Mata Uang Negara Vietnam adalah Baht.", false, "Mata uang negara Vietnam adalah Dong Vietnam (VND). Nilai 1 Dong Vietnam (VND) adalah 0.000042 atau 1 dolar AS sama dengan 24.005,00 Dong Vietnam (VND)."),
//            // Tambahkan 8 soal lainnya di halaman lain aja
//        )
//
//        displayQuestion()

//        binding.benarButton.setOnClickListener {
//            checkAnswer(true)
//        }
//
//        binding.salahButton.setOnClickListener {
//            checkAnswer(false)
//        }

        binding.menyerahButtonOlahraga.setOnClickListener {
            findNavController().navigate(R.id.action_sesiKuisFragment2_to_semuaKuis2)
        }
    }

//    private fun displayQuestion() {
//        val question = questionList[currentQuestionIndex]
//        binding.imagePertanyaanKuis.setImageResource(question.imagePertanyaan)
//        binding.teksPertanyaan.text = question.pertanyaan
//        binding.feedbackPertanyaan.text = ""
//    }

//    private fun checkAnswer(answer: Boolean) {
//        val question = questionList[currentQuestionIndex]
//        if (question.correctAnswer == answer) {
//            binding.feedbackPertanyaan.text = "Yey, benar!\n${question.explanation}"
//            binding.nextPertanyaan.setOnClickListener {
//
//                // ke soal selanjutnya
//            }
//        } else {
//            binding.feedbackPertanyaan.text = "Yah, salah :(\n${question.explanation}"
//            binding.nextPertanyaan.setOnClickListener {
//
//                // ke soal selanjutnya
//            }
//        }
//    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}