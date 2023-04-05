package com.example.baseobjectwithmvi

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

public abstract class BaseActivity : AppCompatActivity() {

    //通用的Toolbar标题
    private lateinit var tvTitle: TextView;

    //通用的ToolBar
    private lateinit var toolbar: Toolbar

    //内容区域
    private lateinit var content: FrameLayout

    //右上角的图标
    private lateinit var img: ImageView

    protected abstract val getContentView : Int

    protected abstract fun init(savedInstanceState: Bundle?)

    protected fun setTitle(title : String) {
        if (title.isNotEmpty()) {
            tvTitle.text = title
        }
    }

    protected fun setTitleBack(visible: Boolean) {
        if (visible)
            toolbar.setNavigationIcon(R.drawable.ic_arrow_back)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)
        initView(savedInstanceState)
    }

    private fun initView(savedInstanceState: Bundle?) {
        tvTitle = findViewById(R.id.tv_title)
        toolbar = findViewById(R.id.toolbar)
        content = findViewById(R.id.content)

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        //子類別放進FrameLayout
        LayoutInflater.from(this).inflate(getContentView, content)

        setTitleBack(true)

        init(savedInstanceState)
    }

    //隐藏Toolbar 通过setToolbar重新制定Toolbar
    open fun hidetoolBar() {
        toolbar.visibility = View.GONE
    }





}