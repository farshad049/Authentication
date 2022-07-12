package com.example.authentication.auth

import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import com.example.authentication.MainActivity

abstract class BaseFragment(@LayoutRes layoutRes:Int) :Fragment(layoutRes) {


    protected val mainActivity: MainActivity
        get() = activity as MainActivity








}