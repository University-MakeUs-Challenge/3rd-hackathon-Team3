package com.example.team_3

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.team_3.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private lateinit var viewBinding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentHomeBinding.inflate(layoutInflater)

        val myCardList: ArrayList<MyCardData> = arrayListOf()

        myCardList.apply{
            add(MyCardData(R.drawable.eiffel, R.drawable.mickey))
            add(MyCardData(R.drawable.merci, R.drawable.bookshop))
        }

        val mycardsAdapter = MyCardsVPAdapter(myCardList)
        viewBinding.vpMycards.adapter = mycardsAdapter

        return viewBinding.root
    }
}