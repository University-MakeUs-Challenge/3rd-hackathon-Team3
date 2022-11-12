package com.example.team_3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.team_3.databinding.FragmentHomeBinding
import com.example.team_3.databinding.FragmentMakecardBinding
import com.example.team_3.databinding.FragmentMakecardoneBinding

class MakeCardFragment : Fragment() {
    private lateinit var viewBinding: FragmentMakecardBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentMakecardBinding.inflate(layoutInflater)

        childFragmentManager
            .beginTransaction()
            .replace(viewBinding.frameFragment.id, MakeCardOneFragment())
            .commitAllowingStateLoss()

        viewBinding.btnFragment1.setOnClickListener {
            childFragmentManager
                .beginTransaction()
                .replace(viewBinding.frameFragment.id, MakeCardOneFragment())
                .commitAllowingStateLoss()
        }
        viewBinding.btnFragment2.setOnClickListener {
            childFragmentManager
                .beginTransaction()
                .replace(viewBinding.frameFragment.id, MakeCardTwoFragment())
                .commitAllowingStateLoss()
        }

        return viewBinding.root
    }
}