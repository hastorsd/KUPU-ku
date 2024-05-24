package com.project.kupu_kuapps.ui_handlers

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.project.kupu_kuapps.main_ui.Funfact
import com.project.kupu_kuapps.databinding.ItemFunfactBinding

class funfactAdapterUsed (
    private val funfactList: List<Funfact>,
    private val itemClickListener: (Funfact) -> Unit
) : RecyclerView.Adapter<funfactAdapterUsed.ViewHolder>() {

        inner class ViewHolder(private val binding: ItemFunfactBinding) : RecyclerView.ViewHolder(binding.root) {
            fun bind(funfact: Funfact) {
                binding.imgFunfact.setImageResource(funfact.imageFunfact)
                binding.descriptionFunfact.text = funfact.descFunfact

                binding.root.setOnClickListener {
                    itemClickListener(funfact)
                }
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val binding = ItemFunfactBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return ViewHolder(binding)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.bind(funfactList[position])
        }

        override fun getItemCount() = funfactList.size
}