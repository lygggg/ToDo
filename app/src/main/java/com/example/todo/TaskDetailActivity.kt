package com.example.todo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_task_detail.*

class TaskDetailActivity : AppCompatActivity() {

    lateinit var taskTitle : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_detail)

        if (intent.hasExtra("taskTitle")) {

            taskTitle = intent.getStringExtra("taskTitle").toString()
            et_task_title.setText(taskTitle)
        }
    }
}