package com.example.mercado.item.displayItem

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mercado.databinding.ItemBinding
import com.example.mercado.item.model.ItemView
import javax.inject.Inject

class DisplayItemAdapter @Inject constructor(): RecyclerView.Adapter<DisplayItemAdapter.ViewHolder>() {

    var items: List<ItemView> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.apply {
            bind(createOnClickListener(item.id), item, position)
            setImage(item.thumbnail)
            itemView.tag = item
        }

    }

    fun createOnClickListener(itemId: String?): View.OnClickListener {
        return View.OnClickListener {
               //navigator.showDetailItem(it,itemId)
        }
    }

    fun setData(items: List<ItemView>) {
        this.items = items
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val binding: ItemBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(listener: View.OnClickListener, item: ItemView, position: Int) {
            binding.apply {
                clickListener = listener
                items = item
                item.price = "$ "+ item.price
                binding.tvInterest.visibility = View.GONE

                if(item.content!=null) {
                    if (item.content.equals("new")) {
                        item.content = "Nuevo"
                    } else {
                        item.content = "Usado"
                    }
                }
                if(item.rate!= null){
                    binding.tvInterest.visibility = View.VISIBLE
                    if(item.rate == 0){
                        item.interest = "en " + item.quantity + " x " + item.amount + " sin interés"
                    }else{
                        item.interest = "en " + item.quantity + " x " + item.amount
                    }
                }

                executePendingBindings()
            }
        }

        fun setImage(poster: String?) {
            try {
                Glide.with(binding.root)
                    .load(poster)
                    .into(binding.acivItemAvatar)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }





    }

}