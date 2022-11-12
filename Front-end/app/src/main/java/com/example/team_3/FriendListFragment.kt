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
            add(Friend(R.drawable.card2_front, R.drawable.card2_back, "애라"))
            add(Friend(R.drawable.card3_front, R.drawable.card3_back, "찹도"))
            add(Friend(R.drawable.card4_front, R.drawable.card4_back, "에이치"))
            add(Friend(R.drawable.card5_front, R.drawable.card5_back, "에디"))
            add(Friend(R.drawable.card6_front, R.drawable.card6_back, "제이"))
            add(Friend(R.drawable.card7_front, R.drawable.card7_back, "잉퓨"))
            add(Friend(R.drawable.card8_front, R.drawable.card8_back, "이안"))
            add(Friend(R.drawable.card9_front, R.drawable.card9_back, "준"))
            add(Friend(R.drawable.card10_front, R.drawable.card10_back, "바켠"))
            add(Friend(R.drawable.card11_front, R.drawable.card11_back, "니니"))
            add(Friend(R.drawable.card12_front, R.drawable.card12_back, "명명이"))
            add(Friend(R.drawable.card13_front, R.drawable.card13_back, "명명이"))
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