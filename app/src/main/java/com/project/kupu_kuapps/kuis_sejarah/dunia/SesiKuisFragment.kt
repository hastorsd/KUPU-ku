package com.project.kupu_kuapps.kuis_sejarah.dunia

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.navigation.fragment.findNavController
import com.project.kupu_kuapps.R
import com.project.kupu_kuapps.databinding.FragmentSesiKuisBinding
import com.project.kupu_kuapps.kuis_handlers.Question

class SesiKuisFragment : Fragment() {
    private var _binding: FragmentSesiKuisBinding? = null
    private val binding get() = _binding!!

    private var currentQuestionIndex = 0
    private lateinit var questionList: List<Question>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSesiKuisBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        questionList = listOf(
            Question(R.mipmap.vietnam, "Mata Uang Negara Vietnam adalah Baht.", false, "Mata uang negara Vietnam adalah Dong Vietnam (VND). Nilai 1 Dong Vietnam (VND) adalah 0.000042 atau 1 dolar AS sama dengan 24.005,00 Dong Vietnam (VND)."),
            // Tambahkan 8 soal lainnya di halaman lain aja
        )

        displayQuestion()

        binding.benarButton.setOnClickListener {
            it.setBackgroundResource(R.drawable.button_benar_salah_pressed)
            checkAnswer(true)
            disableAnswerButtons()
        }

        binding.salahButton.setOnClickListener {
            it.setBackgroundResource(R.drawable.button_benar_salah_pressed)
            checkAnswer(false)
            disableAnswerButtons()
        }

        binding.menyerahButton.setOnClickListener {
            findNavController().navigate(R.id.action_sesiKuisFragment_to_semuaKuis2)
        }

        // Disable back button
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                // Do nothing to disable back button
            }
        })
    }

    private fun displayQuestion() {
        val question = questionList[currentQuestionIndex]
        binding.imagePertanyaanKuis.setImageResource(question.imagePertanyaan)
        binding.teksPertanyaan.text = question.pertanyaan
        binding.feedbackPertanyaan.text = ""
    }

    private fun checkAnswer(answer: Boolean) {
        val question = questionList[currentQuestionIndex]
        if (question.correctAnswer == answer) {
            binding.feedbackPertanyaan.text = "Yey, benar!\n${question.explanation}"
//            binding.nextPertanyaan.setOnClickListener {
//
//                // ke soal selanjutnya
//            }
        } else {
            binding.feedbackPertanyaan.text = "Yah, salah :(\n${question.explanation}"
//            binding.nextPertanyaan.setOnClickListener {
//
//                // ke soal selanjutnya
//            }

        }
        Handler(Looper.getMainLooper()).postDelayed({
            findNavController().navigate(R.id.action_sesiKuisFragment_to_soalSejarahDunia2)
        }, 4000) // Delay 4 detik
    }

    private fun disableAnswerButtons() {
        binding.benarButton.isEnabled = false
        binding.salahButton.isEnabled = false
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}