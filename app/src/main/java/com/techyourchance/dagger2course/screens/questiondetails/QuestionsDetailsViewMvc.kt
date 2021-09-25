package com.techyourchance.dagger2course.screens.questiondetails

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.techyourchance.dagger2course.R
import com.techyourchance.dagger2course.screens.common.BaseMvcListener
import com.techyourchance.dagger2course.screens.common.BaseViewMvc
import com.techyourchance.dagger2course.screens.common.toolbar.MyToolbar

class QuestionDetailsViewMvc(
    private val layoutInflater: LayoutInflater,
    private val parent: ViewGroup?
) : BaseViewMvc<QuestionDetailsViewMvc.Listener>(layoutInflater, parent) {

    interface Listener : BaseMvcListener {
        fun onBackClicked()
    }

    private var toolbar: MyToolbar
    private var swipeRefresh: SwipeRefreshLayout
    private var txtQuestionBody: TextView

    init {

        txtQuestionBody = findViewById(R.id.txt_question_body)

        // init toolbar
        toolbar = findViewById(R.id.toolbar)
        toolbar.setNavigateUpListener {
            for (listener in listeners) {
                listener.onBackClicked()
            }
        }

        // init pull-down-to-refresh (used as a progress indicator)
        swipeRefresh = findViewById(R.id.swipeRefresh)
        swipeRefresh.isEnabled = false

    }

    fun showProgressIndication() {
        swipeRefresh.isRefreshing = true
    }

    fun hideProgressIndication() {
        swipeRefresh.isRefreshing = false
    }

    fun setQuestionBodyText(text: CharSequence) {
        txtQuestionBody.text = text
    }

    override fun getLayoutId(): Int {
        return R.layout.layout_question_details
    }
}

