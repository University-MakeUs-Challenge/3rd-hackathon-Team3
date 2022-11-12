package com.example.team_3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.team_3.databinding.ActivityCardDetailBinding

class CardDetailActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityCardDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        viewBinding = ActivityCardDetailBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)
        viewBinding.imgClose.setImageResource(R.drawable.close)
        val bundle = intent.extras

        if(bundle != null){
            viewBinding.imgMycard.setImageResource(bundle["front"] as Int)
            var isfront = true
            viewBinding.imgMycard.setOnClickListener {
                if(isfront){
                    isfront = false
                    viewBinding.imgMycard.setImageResource(bundle["back"] as Int)
                } else {
                    isfront = true
                    viewBinding.imgMycard.setImageResource(bundle["front"] as Int)
                }
            }
            viewBinding.imgClose.setOnClickListener {
                finish()
            }
        }

    }
}