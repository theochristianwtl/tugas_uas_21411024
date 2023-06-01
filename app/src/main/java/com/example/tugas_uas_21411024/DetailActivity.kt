package com.example.tugas_uas_21411024

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tugas_uas_21411024.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
   private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val int = intent
        var name = int.getStringExtra( "name")
        var desc = int.getStringExtra( "description")
        var img = int.getStringExtra( "imageUrl")

        binding.imageTitle.text = name
        binding.imageDesc.text = desc
        img?.let { binding.imageDetail.loadImage (it) }
        }
    }