package com.example.networktest

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.networktest.net.ApiRequest
import com.example.networktest.net.ApiUtil
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.coroutines.launch
import com.example.networktest.net.Result


class FragmentA : Fragment() {


    lateinit var btn1: Button
    lateinit var tvContent: TextView


    override fun onCreateView(
        inflater: LayoutInflater,
        @Nullable container: ViewGroup?,
        @Nullable savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_a, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        val navController = findNavController(this)

        val jumpBFragment: Button = view.findViewById(R.id.jumpBFragment)
        val navView : BottomNavigationView = requireActivity().findViewById(R.id.bottom_navigation)



        jumpBFragment.setOnClickListener {
//            val bundle = Bundle()
//            bundle.putString("content", "How are you?")
//            Navigation.findNavController(view).navigate(R.id.action_afragment_to_bfragment, bundle)


            val badge = navView.getOrCreateBadge(R.id.fragment_a)
            badge.number = 100
            badge.backgroundColor = Color.parseColor("#FF00FF")
            badge.maxCharacterCount = 3

        }

        initView(view)

    }

    private fun initView(view: View) {
        btn1 = view.findViewById(R.id.btn1)
        tvContent = view.findViewById(R.id.tv_content)

        btn1.setOnClickListener {

            lifecycleScope.launch {
                val ret = ApiRequest.safeApiCall { ApiUtil.getUser("1") }
                when (ret) {
                    is Result.Success -> {
                        Toast.makeText(requireActivity(), "Success", Toast.LENGTH_SHORT).show()
                        tvContent.text =
                            "userId = ${ret.data.userId}, \nid = ${ret.data.id}, \ntitle = ${ret.data.title}, \ncompleted = ${ret.data.completed}"

                    }
                    is Result.Failure -> {
                        Toast.makeText(requireActivity(), "Failure", Toast.LENGTH_SHORT).show()
                    }

                    is Result.Complete -> {
                        Toast.makeText(requireActivity(), "Complete", Toast.LENGTH_SHORT).show()
                    }
                }

            }

        }
    }


}