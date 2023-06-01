package com.example.tugas_uas_21411024

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tugas_uas_21411024.databinding.ActivityContentBinding
import com.google.firebase.database.*
import com.google.firebase.storage.FirebaseStorage

class ContentActivity : AppCompatActivity() {

    private lateinit var movieRecyclerView: RecyclerView
    private lateinit var movieList: MutableList<Movie>
    private lateinit var movieAdapter: MyAdapter
    private lateinit var binding: ActivityContentBinding
    private var mStorage: FirebaseStorage? = null
    private var mDatabaseRef: DatabaseReference? = null
    private var mDBListener: ValueEventListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        movieRecyclerView = findViewById(R.id.imageRecyclerView)
        movieRecyclerView.setHasFixedSize(true)
        movieRecyclerView.layoutManager = LinearLayoutManager(this@ContentActivity)
        binding.myDataLoaderProgressBar.visibility = View.VISIBLE
        movieList = ArrayList()
        movieAdapter = MyAdapter(this@ContentActivity, movieList)
        movieRecyclerView.adapter = movieAdapter

        mStorage = FirebaseStorage.getInstance()
        mDatabaseRef = FirebaseDatabase.getInstance().getReference("movie")
        mDBListener = mDatabaseRef!!.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@ContentActivity, error.message, Toast.LENGTH_SHORT).show()
                binding.myDataLoaderProgressBar.visibility = View.GONE
            }
        })
    }
}