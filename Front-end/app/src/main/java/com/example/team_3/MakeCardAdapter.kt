package com.example.team_3

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class MakeCardAdapter(fragmentActivity: FragmentActivity): FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int = 4

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> MakeCardZeroFragment()
            1 -> MakeCardOneFragment()
            2 -> MakeCardTwoFragment()
            3 -> MakeCardThreeFragment()
            else -> MakeCardZeroFragment()
        }
    }
}