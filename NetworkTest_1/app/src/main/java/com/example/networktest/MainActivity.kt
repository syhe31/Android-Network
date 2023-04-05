package com.example.networktest

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.Navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.viewpager2.widget.ViewPager2
import com.example.networktest.net.ApiRequest
import com.example.networktest.net.ApiUtil
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.coroutines.launch
import com.example.networktest.net.Result


class MainActivity : AppCompatActivity() {

    lateinit var btn1: Button
    lateinit var tvContent: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val bottomNavigation : BottomNavigationView = findViewById(R.id.bottom_navigation)
//        //获取navController
//        val navController: NavController = Navigation.findNavController(this, R.id.nav_host_fragment)
//        //通过setupWithNavController将底部导航和导航控制器进行绑定
//        NavigationUI.setupWithNavController(bottomNavigation, navController)


        initViewPager()


//        btn1 = findViewById(R.id.btn1)
//        tvContent = findViewById(R.id.tv_content)
//
//        btn1.setOnClickListener {
//
//            lifecycleScope.launch {
//                val ret = ApiRequest.safeApiCall { ApiUtil.getUser("1") }
//                when (ret) {
//                    is Result.Success -> {
//                        Toast.makeText(this@MainActivity, "Success", Toast.LENGTH_SHORT).show()
//                        tvContent.text =
//                            "userId = ${ret.data.userId}, \nid = ${ret.data.id}, \ntitle = ${ret.data.title}, \ncompleted = ${ret.data.completed}"
//
//                    }
//                    is Result.Failure -> {
//                        Toast.makeText(this@MainActivity, "Failure", Toast.LENGTH_SHORT).show()
//                    }
//
//                    is Result.Complete -> {
//                        Toast.makeText(this@MainActivity, "Complete", Toast.LENGTH_SHORT).show()
//                    }
//                }
//
//            }
//
//        }


    }

    private lateinit var fragmentList: ArrayList<Fragment>
    private fun initViewPager() {
        val bottomNavigation : BottomNavigationView = findViewById(R.id.bottom_navigation)
        val viewPager2 : ViewPager2 = findViewById(R.id.view_pager_2)

        fragmentList = ArrayList()
        fragmentList.add(FragmentA())
        fragmentList.add(FragmentB())
        fragmentList.add(FragmentC())

        val fragmentManager : FragmentManager = supportFragmentManager
        viewPager2.adapter = FragmentPagerAdapter(fragmentManager, lifecycle, fragmentList )


        bottomNavigation.setOnItemSelectedListener { item ->
            when(item.itemId) {
                R.id.fragment_a -> {
                    viewPager2.currentItem = 0
                    true
                }
                R.id.fragment_b -> {
                    viewPager2.currentItem = 1
                    true
                }
                R.id.fragment_c -> {
                    viewPager2.currentItem = 2
                    true
                }
                else -> false
            }
        }


//        bottomNavigation.setOnNavigationItemSelectedListener { item: MenuItem ->
//            when (item.itemId) {
//                R.id.fragment_a -> {
//                    viewPager2.currentItem = 0
//                    true
//                }
//                R.id.fragment_b -> {
//                    viewPager2.currentItem = 1
//                    true
//                }
//                R.id.fragment_c -> {
//                    viewPager2.currentItem = 2
//                    true
//                }
//                else -> false
//            }
//        }

        // synchronize view pager and bottom navigation view
        viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                when (position) {
                    0 -> bottomNavigation.selectedItemId = R.id.fragment_a
                    1 -> bottomNavigation.selectedItemId = R.id.fragment_b
                    2 -> bottomNavigation.selectedItemId = R.id.fragment_c
                }
            }
        })
    }
}