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
import com.project.kupu_kuapps.databinding.FragmentSoalSejarahIndonesia5Binding
import com.project.kupu_kuapps.kuis_handlers.Question

class SoalSejarahIndonesia5 : Fragment() {
    private var _binding: FragmentSoalSejarahIndonesia5Binding? = null
    private val binding get() = _binding!!

    private var currentQuestionIndex = 0
    private lateinit var questionList: List<Question>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSoalSejarahIndonesia5Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        questionList = listOf(
            Question(R.mipmap.sumpahpemuda, "Sumpah Pemuda pertama kali dilaksanakan pada tanggal 28 Oktober 1928", false, "Sumpah Pemuda pertama Diselenggarakan pada 30 April–2 Mei 1926 di Lapangan Banteng, Jakarta. Namun Sumpah Pemuda 2 pada tanggal 28 Oktober inilah yang disebut sebagai Sumpah Pemuda"),
            // Tambahkan 8 soal lainnya di halaman lain aja
        )

        displayQuestion()

        binding.benarButtonSejIndo5.setOnClickListener {
            it.setBackgroundResource(R.drawable.button_benar_salah_pressed)
            checkAnswer(true)
            disableAnswerButtons()
        }

        binding.salahButtonSejIndo5.setOnClickListener {
            it.setBackgroundResource(R.drawable.button_benar_salah_pressed)
            checkAnswer(false)
            disableAnswerButtons()
        }

        binding.menyerahButtonSejIndo5.setOnClickListener {
            findNavController().navigate(R.id.action_soalSejarahIndonesia5_to_semuaKuis2)
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
        binding.imagePertanyaanKuisSejIndo5.setImageResource(question.imagePertanyaan)
        binding.teksPertanyaanSejIndo5.text = question.pertanyaan
        binding.feedbackPertanyaanSejIndo5.text = ""
    }

    private fun checkAnswer(answer: Boolean) {
        val question = questionList[currentQuestionIndex]
        if (question.correctAnswer == answer) {
            binding.feedbackPertanyaanSejIndo5.text = "Yey, benar!\n${question.explanation}"
//            binding.nextPertanyaanSejIndo5.setOnClickListener {
//
//                // ke soal selanjutnya
//            }
        } else {
            binding.feedbackPertanyaanSejIndo5.text = "Yah, salah :(\n${question.explanation}"
//            binding.nextPertanyaanSejIndo5.setOnClickListener {
//
//                // ke soal selanjutnya
//            }
        }
    }

    private fun disableAnswerButtons() {
        binding.benarButtonSejIndo5.isEnabled = false
        binding.salahButtonSejIndo5.isEnabled = false
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}