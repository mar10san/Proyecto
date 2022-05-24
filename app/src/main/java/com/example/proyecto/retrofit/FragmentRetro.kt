package com.example.proyecto.retrofit

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.proyecto.R
import com.example.proyecto.databinding.FragmentRetroBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*


class FragmentRetro : Fragment(), SearchView.OnQueryTextListener {
    private lateinit var binding: FragmentRetroBinding
    private lateinit var adapter: AdapterRetro
    private val images1= mutableListOf<String>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val vista = inflater.inflate(R.layout.fragment_retro, container, false)
        binding = FragmentRetroBinding.inflate(layoutInflater)
        //setContentView(binding.root)
        binding.svdog.setOnQueryTextListener(this)
        initRecyclerView()
        return vista
    }
    private fun initRecyclerView() {
        adapter = AdapterRetro(images1)
        binding.rvdog.layoutManager= LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL, false)
        binding.rvdog.adapter=adapter
    }

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://dog.ceo/api/breed/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun searchByName(query:String){
        CoroutineScope(Dispatchers.IO).launch {
            val call = getRetrofit().create(APIService::class.java).getDogsByBreeds("$query/images")
            val puppies = call.body()
            activity?.runOnUiThread {
                showAccion()
                if(call.isSuccessful){
                    val images = puppies?.images ?: emptyList()
                    images1.clear()
                    images1.addAll(images)
                    adapter.notifyDataSetChanged()
                }else{
                    showError()
                }
            }
        }
    }

    private fun showError() {
        Toast.makeText(requireContext(),"Estamos teniendo  un error", Toast.LENGTH_SHORT).show()
    }

    private fun showAccion() {
        Toast.makeText(requireContext(),"Consulta realizada", Toast.LENGTH_SHORT).show()
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        if (query != null) {
            searchByName(query.lowercase(Locale.getDefault()))
        }
        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean{
        return true
    }

}