package com.project.kupu_kuapps.unused_files//package com.project.kupu_kuapps
//
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.recyclerview.widget.RecyclerView
//import com.project.kupu_kuapps.databinding.ItemFunfactBinding
//
//data class funFact (val image: Int, val title: String, val description: String)
//
//class funfactAdapter(private val items: List<funFact>) : RecyclerView.Adapter<funfactAdapter.ViewHolder>() {
//
//    class ViewHolder(val binding: ItemFunfactBinding) : RecyclerView.ViewHolder(binding.root)
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        val binding = ItemFunfactBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//        return ViewHolder(binding)
//    }
//
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        val item = items[position]
//        holder.binding.itemImage.setImageResource(item.image)
//        holder.binding.itemTitle.text = item.title
//        holder.binding.itemDescription.text = item.description
//    }
//
//    override fun getItemCount() = items.size
//}
