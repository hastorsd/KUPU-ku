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
import com.project.kupu_kuapps.databinding.FragmentSoalSejarahIndonesia3Binding
import com.project.kupu_kuapps.kuis_handlers.Question

class SoalSejarahIndonesia3 : Fragment() {
    private var _binding: FragmentSoalSejarahIndonesia3Binding? = null
    private val binding get() = _binding!!

    private var currentQuestionIndex = 0
    private lateinit var questionList: List<Question>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSoalSejarahIndonesia3Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        questionList = listOf(
            Question(R.mipmap.indonesia_raya, "Pencipta lagu Indonesia Raya adalah Sayuti Melik", false, "Lagu Indonesia Raya adalah lagu nasional diciptakan oleh Wage Rudolf Soepratman atau W.R Supratman pada 1924. Sedangkan Sayuti Melik adalah Pengetik Naskah Proklamasi"),
            // Tambahkan 8 soal lainnya di halaman lain aja
        )

        displayQuestion()

        binding.benarButtonSejIndo3.setOnClickListener {
            it.setBackgroundResource(R.drawable.button_benar_salah_pressed)
            checkAnswer(true)
            disableAnswerButtons()
        }

        binding.salahButtonSejIndo3.setOnClickListener {
            it.setBackgroundResource(R.drawable.button_benar_salah_pressed)
            checkAnswer(false)
            disableAnswerButtons()
        }

        binding.menyerahButtonSejIndo3.setOnClickListener {
            findNavController().navigate(R.id.action_soalSejarahIndonesia3_to_semuaKuis2)
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
        binding.imagePertanyaanKuisSejIndo3.setImageResource(question.imagePertanyaan)
        binding.teksPertanyaanSejIndo3.text = question.pertanyaan
        binding.feedbackPertanyaanSejIndo3.text = ""
    }

    private fun checkAnswer(answer: Boolean) {
        val question = questionList[currentQuestionIndex]
        if (question.correctAnswer == answer) {
            binding.feedbackPertanyaanSejIndo3.text = "Yey, benar!\n${question.explanation}"
//            binding.nextPertanyaanSejIndo3.setOnClickListener {
//
//                // ke soal selanjutnya
//            }
        } else {
            binding.feedbackPertanyaanSejIndo3.text = "Yah, salah :(\n${question.explanation}"
//            binding.nextPertanyaanSejIndo3.setOnClickListener {
//
//                // ke soal selanjutnya
//            }

        }
        Handler(Looper.getMainLooper()).postDelayed({
            findNavController().navigate(R.id.action_soalSejarahIndonesia3_to_soalSejarahIndonesia4)
        }, 4000) // Delay 4 detik
    }

    private fun disableAnswerButtons() {
        binding.benarButtonSejIndo3.isEnabled = false
        binding.salahButtonSejIndo3.isEnabled = false
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}