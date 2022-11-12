package com.example.team_3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.team_3.databinding.FragmentHomeBinding
import com.example.team_3.databinding.FragmentMakecardBinding

class MakeCardFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentMakecardBinding.inflate(layoutInflater).root
    }
}