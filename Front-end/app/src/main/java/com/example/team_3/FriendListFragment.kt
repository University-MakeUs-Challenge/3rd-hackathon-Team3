package com.example.team_3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.team_3.databinding.FragmentFriendlistBinding
import com.example.team_3.databinding.FragmentHomeBinding

class FriendListFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentFriendlistBinding.inflate(layoutInflater).root
    }
}