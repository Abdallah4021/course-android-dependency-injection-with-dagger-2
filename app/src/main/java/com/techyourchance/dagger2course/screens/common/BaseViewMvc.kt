package com.techyourchance.dagger2course.screens.common

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.IdRes
import androidx.annotation.LayoutRes

abstract class BaseViewMvc<LISTENER_TYPE>(
    private val layoutInflater: LayoutInflater,
    private val parent: ViewGroup?
) {

    protected val listeners = HashSet<LISTENER_TYPE>()
    protected val context: Context get() = rootView.context
    val rootView: View =
        layoutInflater.inflate(getLayoutId(), parent, false)


    fun registerListener(listener: LISTENER_TYPE) {
        listeners.add(listener)
    }

    fun unRegisterListener(listener: LISTENER_TYPE) {
        listeners.remove(listener)
    }

    fun <T : View?> findViewById(@IdRes id: Int): T {
        return rootView.findViewById<T>(id)
    }

    @LayoutRes
    abstract fun getLayoutId(): Int
}