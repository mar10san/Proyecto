package com.example.proyecto.retrofit

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.proyecto.databinding.VistaPropiaRetroBinding
import com.squareup.picasso.Picasso

class ViewHolderRetro (view: View): RecyclerView.ViewHolder(view) {

    private val binding = VistaPropiaRetroBinding.bind(view)

    fun bind(image:String){
        Picasso.get().load(image).into(binding.ivJorge)
    }
}