package com.example.team_3

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.team_3.databinding.FragmentHomeBinding
import java.time.OffsetDateTime

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
            add(MyCardData(R.drawable.card1_front, R.drawable.card1_back))
            add(MyCardData(R.drawable.card1_front, R.drawable.card1_back))
            add(MyCardData(R.drawable.card1_front, R.drawable.card1_back))
            add(MyCardData(R.drawable.card1_front, R.drawable.card1_back))
        }

        val mycardsAdapter = MyCardsVPAdapter(myCardList)
        viewBinding.vpMycards.adapter = mycardsAdapter
        viewBinding.vpMycards.offscreenPageLimit = 3
        val pageMargin = resources.getDimensionPixelOffset(R.dimen.pageMargin).toFloat()
        val pageOffset = resources.getDimensionPixelOffset(R.dimen.offset).toFloat()

        viewBinding.vpMycards.setPageTransformer({page, position ->
            val myOffset = position * -(2*pageOffset + pageMargin)
            if(position < -1){
                page.translationX = -myOffset
            } else if(position <= 1){
                val scaleFactor = Math.max(0.7f, 1-Math.abs(position - 0.14285715f))
                page.translationX = myOffset
                page.scaleY = scaleFactor
                page.alpha = scaleFactor
            } else {
                page.alpha = 0f
                page.translationX = myOffset
            }
        })

        return viewBinding.root
    }
}