package com.example.team_3

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
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
            add(Friend(R.drawable.sample, R.drawable.eiffel, "aera"))
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



//        friendAdapter.setItemClickListener(object: friendRVAdapter.OnItemClickListener{
//            fun onClick(v: View, data:Friend, position: Int) {
//                // 클릭 시 이벤트 작성
////                Intent(this@FriendListFragment).apply{
//   //                 putExtra("name",name)
// //                   putExtra("front",front)
//
////                }
//
//                Toast.makeText(context,
//                    "${friendList[position].name}의 명함입니다.}",
//                    Toast.LENGTH_SHORT).show()
//            }

//            override fun onItemClick(v: View, data: Friend, position: Int) {
//                TODO("Not yet implemented")
//            }
//
//            override fun onItemClick(
//                parent: AdapterView<*>?,
//                view: View?,
//                position: Int,
//                id: Long
//            ) {
//                TODO("Not yet implemented")
//            }
//        })
/*
        profileAdapter.setOnItemClickListener(object : ProfileAdapter.OnItemClickListener{
            override fun onItemClick(v: View, data: ProfileData, pos : Int) {
                Intent(this@MainActivity, ProfileDetailActivity::class.java).apply {
                    putExtra("data", data)
                    addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                }.run { startActivity(this) }
            }

        })
*/



//        var recyclerList=recycleGridView.apply{
//            setHasFixedSize(true)
//            layoutManager=gridlayoutManager
//            adapter=friendRVAdapter
//        }

        return viewBinding.root
    }
}