package com.project.kupu_kuapps.unused_files//package com.project.kupu_kuapps
//
//import android.os.Bundle
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.fragment.app.Fragment
//import androidx.navigation.fragment.findNavController
//import androidx.recyclerview.widget.LinearLayoutManager
//import com.project.kupu_kuapps.databinding.FragmentQuizListBinding
//
//class QuizListFragment : Fragment() {
//
//    private var _binding: FragmentQuizListBinding? = null
//    private val binding get() = _binding!!
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        _binding = FragmentQuizListBinding.inflate(inflater, container, false)
//        return binding.root
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        val questionList = listOf(
//            Question(R.mipmap.sejarah_indonesia, "Candi Borobudur adalah candi Buddha terbesar di Indonesia dan di dunia.", true, "Candi Borobudur adalah candi Buddha terbesar di Indonesia dan di dunia."),
//            Question(R.mipmap.sejarah_dunia, "Mata Uang Negara Vietnam adalah Baht.", false, "Mata uang negara Vietnam adalah Dong Vietnam (VND). Nilai 1 Dong Vietnam (VND) adalah 0.000042 atau 1 dolar AS sama dengan 24.005,00 Dong Vietnam (VND)."),
//            // Tambahkan 8 soal lainnya
//        )
//
//        binding.rvQuizList.layoutManager = LinearLayoutManager(requireContext())
//        binding.rvQuizList.adapter = QuestionAdapter(questionList) {
//            findNavController().navigate(R.id.action_quizListFragment_to_quizFragment)
//        }
//    }
//
//    override fun onDestroyView() {
//        super.onDestroyView()
//        _binding = null
//    }
//}
