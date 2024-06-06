package com.project.kupu_kuapps.kuis_handlers

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.project.kupu_kuapps.R
import com.project.kupu_kuapps.databinding.ItemKuisBinding

class KuisAdapter(
    private val kuisList: List<Kuis>,
    private val itemClickListener: (Kuis) -> Unit,
    private val favoriteClickListener: (Kuis) -> Unit,
    private val mainButtonClickListener: (Kuis) -> Unit // Add a listener for the button
) : RecyclerView.Adapter<KuisAdapter.ViewHolder>() {

    private val colors = listOf(
        R.color.primer,
        R.color.sekunder,
        R.color.sports,
        R.color.musik,
        R.color.orange,
        // Tambahkan warna lainnya jika diperlukan
    )

    inner class ViewHolder(private val binding: ItemKuisBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(kuis: Kuis) {
            binding.imgItemPhoto.setImageResource(kuis.imageKuis)
            binding.tvItemName.text = kuis.nameKuis
            binding.tvItemDescription.text = kuis.descKuis

            // Set background color based on position
            val colorResId = colors[position % colors.size]
            binding.root.setBackgroundColor(ContextCompat.getColor(binding.root.context, colorResId))

            // Set favorite icon
            val favoriteIcon = if (kuis.isFavorited) R.drawable.ic_favorite else R.drawable.ic_favorite_border
            binding.ivFavorite.setImageResource(favoriteIcon)

            binding.ivFavorite.setOnClickListener {
                favoriteClickListener(kuis)
                notifyItemChanged(position)
            }

            binding.root.setOnClickListener {
                itemClickListener(kuis)
            }

            // Set click listener for the button
            binding.buttonMainKuis.setOnClickListener {
                mainButtonClickListener(kuis)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemKuisBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(kuisList[position])
    }

    override fun getItemCount() = kuisList.size
}
