package com.example.team_3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.team_3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var viewBinding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        supportFragmentManager
            .beginTransaction()
            .replace(viewBinding.containerFragment.id, HomeFragment())
            .commitAllowingStateLoss()

        viewBinding.navBottom.run {
            setOnItemSelectedListener {
                when (it.itemId) {
                    R.id.menu_home -> {
                        supportFragmentManager
                            .beginTransaction()
                            .replace(viewBinding.containerFragment.id, HomeFragment())
                            .commitAllowingStateLoss()
                    }
                    R.id.menu_make -> {
                        // 누르면 SettingFragment로 교체
                        supportFragmentManager
                            .beginTransaction()
                            .replace(viewBinding.containerFragment.id, MakeCardFragment())
                            .commitAllowingStateLoss()
                    }
                    R.id.menu_friend -> {
                        supportFragmentManager
                            .beginTransaction()
                            .replace(viewBinding.containerFragment.id, FriendListFragment())
                            .commitAllowingStateLoss()
                    }
                    R.id.menu_mypage -> {
                        supportFragmentManager
                            .beginTransaction()
                            .replace(viewBinding.containerFragment.id, MyPageFragment())
                            .commitAllowingStateLoss()
                    }
                }
                true
            }

            selectedItemId = R.id.menu_home
        }
    }
}