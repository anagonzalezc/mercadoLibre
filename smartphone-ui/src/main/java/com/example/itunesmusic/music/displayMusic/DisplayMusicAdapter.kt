package com.example.itunesmusic.music.displayMusic

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.itunesmusic.databinding.ItemMusicBinding
import com.example.itunesmusic.music.model.MusicView
import javax.inject.Inject

class DisplayMusicAdapter @Inject constructor(): RecyclerView.Adapter<DisplayMusicAdapter.ViewHolder>() {

    var musics: List<MusicView> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemMusicBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return musics.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val music = musics[position]
        holder.apply {
            bind(createOnClickListener(music.urlMusic), music)
            setImage(music.photo)
            itemView.tag = music
        }

    }

    fun createOnClickListener(musicID: String): View.OnClickListener {
        return View.OnClickListener {
        }
    }

    fun setData(musics: List<MusicView>) {
        this.musics = musics
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val binding: ItemMusicBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(listener: View.OnClickListener, item: MusicView) {
            binding.apply {
                music = item
                executePendingBindings()
            }
        }

        fun setImage(poster: String?) {
            try {
                Glide.with(binding.root)
                    .load(poster)
    //                .apply(RequestOptions.circleCropTransform())
                    .into(binding.acivMusicAvatar)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }




    }

}