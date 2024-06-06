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
import com.project.kupu_kuapps.databinding.FragmentSoalSejarahIndonesia4Binding
import com.project.kupu_kuapps.kuis_handlers.Question

class SoalSejarahIndonesia4 : Fragment() {
    private var _binding: FragmentSoalSejarahIndonesia4Binding? = null
    private val binding get() = _binding!!

    private var currentQuestionIndex = 0
    private lateinit var questionList: List<Question>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSoalSejarahIndonesia4Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        questionList = listOf(
            Question(R.mipmap.belanda_jajah, "Belanda merupakan negara yang paling lama menjajah Indonesia", true, "Belanda berada di Indonesia selama hampir 350 tahun"),
            // Tambahkan 8 soal lainnya di halaman lain aja
        )

        displayQuestion()

        binding.benarButtonSejIndo4.setOnClickListener {
            it.setBackgroundResource(R.drawable.button_benar_salah_pressed)
            checkAnswer(true)
            disableAnswerButtons()
        }

        binding.salahButtonSejIndo4.setOnClickListener {
            it.setBackgroundResource(R.drawable.button_benar_salah_pressed)
            checkAnswer(false)
            disableAnswerButtons()
        }

        binding.menyerahButtonSejIndo4.setOnClickListener {
            findNavController().navigate(R.id.action_soalSejarahIndonesia4_to_semuaKuis2)
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
        binding.imagePertanyaanKuisSejIndo4.setImageResource(question.imagePertanyaan)
        binding.teksPertanyaanSejIndo4.text = question.pertanyaan
        binding.feedbackPertanyaanSejIndo4.text = ""
    }

    private fun checkAnswer(answer: Boolean) {
        val question = questionList[currentQuestionIndex]
        if (question.correctAnswer == answer) {
            binding.feedbackPertanyaanSejIndo4.text = "Yey, benar!\n${question.explanation}"
//            binding.nextPertanyaanSejIndo4.setOnClickListener {
//
//                // ke soal selanjutnya
//            }
        } else {
            binding.feedbackPertanyaanSejIndo4.text = "Yah, salah :(\n${question.explanation}"
//            binding.nextPertanyaanSejIndo4.setOnClickListener {
//
//                // ke soal selanjutnya
//            }
        }
        Handler(Looper.getMainLooper()).postDelayed({
            findNavController().navigate(R.id.action_soalSejarahIndonesia4_to_soalSejarahIndonesia5)
        }, 4000) // Delay 4 detik
    }

    private fun disableAnswerButtons() {
        binding.benarButtonSejIndo4.isEnabled = false
        binding.salahButtonSejIndo4.isEnabled = false
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}