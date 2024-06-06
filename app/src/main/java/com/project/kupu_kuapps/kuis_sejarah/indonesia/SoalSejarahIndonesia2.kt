package com.project.kupu_kuapps.kuis_sejarah.indonesia

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
import com.project.kupu_kuapps.databinding.FragmentSoalSejarahIndonesia2Binding
import com.project.kupu_kuapps.kuis_handlers.Question

class SoalSejarahIndonesia2 : Fragment() {
    private var _binding: FragmentSoalSejarahIndonesia2Binding? = null
    private val binding get() = _binding!!

    private var currentQuestionIndex = 0
    private lateinit var questionList: List<Question>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSoalSejarahIndonesia2Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        questionList = listOf(
            Question(R.mipmap.sultanagung, "Sultan Agung adalah seorang sultan di Kerajaan Demak", false, "Sultan Agung dari Mataram adalah sultan Mataram ketiga yang memerintah dari tahun 1613-1645."),
            // Tambahkan 8 soal lainnya di halaman lain aja
        )

        displayQuestion()

        binding.benarButtonSejIndo2.setOnClickListener {
            it.setBackgroundResource(R.drawable.button_benar_salah_pressed)
            checkAnswer(true)
            disableAnswerButtons()
        }

        binding.salahButtonSejIndo2.setOnClickListener {
            it.setBackgroundResource(R.drawable.button_benar_salah_pressed)
            checkAnswer(false)
            disableAnswerButtons()
        }

        binding.menyerahButtonSejIndo2.setOnClickListener {
            findNavController().navigate(R.id.action_soalSejarahIndonesia2_to_semuaKuis2)
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
        binding.imagePertanyaanKuisSejIndo2.setImageResource(question.imagePertanyaan)
        binding.teksPertanyaanSejIndo2.text = question.pertanyaan
        binding.feedbackPertanyaanSejIndo2.text = ""
    }

    private fun checkAnswer(answer: Boolean) {
        val question = questionList[currentQuestionIndex]
        if (question.correctAnswer == answer) {
            binding.feedbackPertanyaanSejIndo2.text = "Yey, benar!\n${question.explanation}"
//            binding.nextPertanyaanSejIndo2.setOnClickListener {
//
//                // ke soal selanjutnya
//            }
        } else {
            binding.feedbackPertanyaanSejIndo2.text = "Yah, salah :(\n${question.explanation}"
//            binding.nextPertanyaanSejIndo2.setOnClickListener {
//
//                // ke soal selanjutnya
//            }

        }
        Handler(Looper.getMainLooper()).postDelayed({
            findNavController().navigate(R.id.action_soalSejarahIndonesia2_to_soalSejarahIndonesia3)
        }, 4000) // Delay 4 detik
    }

    private fun disableAnswerButtons() {
        binding.benarButtonSejIndo2.isEnabled = false
        binding.salahButtonSejIndo2.isEnabled = false
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}