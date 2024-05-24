package com.project.kupu_kuapps.unused_files//package com.project.kupu_kuapps
//
//import android.view.LayoutInflater
//import android.view.ViewGroup
//import androidx.recyclerview.widget.RecyclerView
//import com.project.kupu_kuapps.databinding.ItemKuisBinding
//
//class QuestionAdapter(
//    private val questions: List<Question>,
//    private val onMainClick: () -> Unit
//) : RecyclerView.Adapter<QuestionAdapter.QuestionViewHolder>() {
//
//    inner class QuestionViewHolder(val binding: ItemKuisBinding) : RecyclerView.ViewHolder(binding.root) {
//        fun bind(question: Question) {
//            binding.itemImage.setImageResource(question.imageResId)
//            binding.itemTitle.text = question.questionText
//            binding.mainButton.setOnClickListener {
//                onMainClick()
//            }
//        }
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionViewHolder {
//        val binding = ItemKuisBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//        return QuestionViewHolder(binding)
//    }
//
//    override fun onBindViewHolder(holder: QuestionViewHolder, position: Int) {
//        holder.bind(questions[position])
//    }
//
//    override fun getItemCount() = questions.size
//}
