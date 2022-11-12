package com.example.team_3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.team_3.databinding.FragmentMakecardBinding
import com.google.android.material.tabs.TabLayoutMediator

class MakeCardFragment : Fragment() {
    private lateinit var viewBinding: FragmentMakecardBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentMakecardBinding.inflate(layoutInflater)

        val makeCardAdapter = MakeCardAdapter(requireActivity())
        viewBinding.vpMain.adapter = makeCardAdapter

        val tabTitleArray = arrayOf("1.선택", "2.앞면", "3.뒷면", "4.완료")

        TabLayoutMediator(viewBinding.tabMain, viewBinding.vpMain) {tab, position ->
            tab.text = tabTitleArray[position]
        }.attach()

//        childFragmentManager
//            .beginTransaction()
//            .replace(viewBinding.frameFragment.id, MakeCardOneFragment())
//            .commitAllowingStateLoss()
//
//        viewBinding.btnFragment1.setOnClickListener {
//            childFragmentManager
//                .beginTransaction()
//                .replace(viewBinding.frameFragment.id, MakeCardOneFragment())
//                .commitAllowingStateLoss()
//        }
//        viewBinding.btnFragment2.setOnClickListener {
//            childFragmentManager
//                .beginTransaction()
//                .replace(viewBinding.frameFragment.id, MakeCardTwoFragment())
//                .commitAllowingStateLoss()
//        }

        return viewBinding.root
    }
}