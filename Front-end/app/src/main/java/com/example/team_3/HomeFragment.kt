package com.example.team_3

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

        val myCardsArray = arrayListOf<Int>(
            R.drawable.eiffel,
            R.drawable.mickey,
        )

        val mycardsAdapter = MyCardsVPAdapter(myCardsArray)
        viewBinding.vpMycards.adapter = mycardsAdapter

        return viewBinding.root
    }
}