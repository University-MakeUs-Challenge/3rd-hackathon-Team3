package com.example.team_3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.team_3.databinding.FragmentFriendlistBinding

class FriendListFragment : Fragment() {
    private lateinit var viewBinding : FragmentFriendlistBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding= FragmentFriendlistBinding.inflate(layoutInflater)

        val friendList: ArrayList<Friend> = arrayListOf()

        friendList.apply{
            add(Friend(R.drawable.sample, R.drawable.sample, "aera"))
            add(Friend(R.drawable.sample2, R.drawable.sample, "eddy"))
            add(Friend(R.drawable.sample, R.drawable.sample, "aera"))
            add(Friend(R.drawable.sample2, R.drawable.sample, "eddy"))
            add(Friend(R.drawable.sample, R.drawable.sample, "aera"))
            add(Friend(R.drawable.sample2, R.drawable.sample, "eddy"))
            add(Friend(R.drawable.sample, R.drawable.sample, "aera"))
            add(Friend(R.drawable.sample2, R.drawable.sample, "eddy"))
            add(Friend(R.drawable.sample, R.drawable.sample, "aera"))
            add(Friend(R.drawable.sample2, R.drawable.sample, "eddy"))
            add(Friend(R.drawable.sample, R.drawable.sample, "aera"))
            add(Friend(R.drawable.sample2, R.drawable.sample, "eddy"))
        }

        val friendAdapter = friendRVAdapter(friendList)
        viewBinding.rvFriend.adapter = friendAdapter

//        var gridlayoutManager = GridLayoutManager(context, 3,LinearLayoutManager.VERTICAL,true
        var gridlayoutManager = GridLayoutManager(context, 3)
        viewBinding.rvFriend.layoutManager = gridlayoutManager

//        var recyclerList=recycleGridView.apply{
//            setHasFixedSize(true)
//            layoutManager=gridlayoutManager
//            adapter=friendRVAdapter
//        }

        return viewBinding.root
    }
}