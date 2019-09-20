package com.example.todo

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val adapter by lazy {
        TaskListAdapter()
    }
    private val pref by lazy {
        this.getPreferences(0)
    }
    private val editor by lazy {
        pref.edit()
    }

    var memoSize: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_add_task.setOnClickListener {
            adapter.addItem(TaskItem(et_add_task.text.toString()))

            if (memoSize > 0) {
                editor.putString("memo${adapter.items.size}", et_add_task.text.toString()).apply()
                memoSize++
                editor.putInt("memoSize", memoSize).apply()

            }
        }
//
//        layout_task_container.setOnClickListener {
//
//            val intent = Intent(this, TaskDetailActivity::class.java)
//            intent.putExtra("taskTitle", tv_task_name.text.toString())
//            startActivity(intent)
//        }

        rv_task_list.layoutManager = LinearLayoutManager(this)
        rv_task_list.adapter = adapter
        rv_task_list.setHasFixedSize(true)

        memoSize = pref.getInt("memoSize", 0)

        if (memoSize > 0) {
            for (i in 1..memoSize) {
                adapter.addItem(TaskItem(pref.getString("memo${i}", "없음")!!))
            }
        }

        Toast.makeText(this, "환영합니다", Toast.LENGTH_SHORT).show()
    }

    override fun onStart() {
        super.onStart()
        // The activity is about to become visible.
    }

    override fun onResume() {
        super.onResume()
        // The activity has become visible (it is now "resumed").

    }

    override fun onPause() {
        super.onPause()
        // Another activity is taking focus (this activity is about to be "paused").
    }

    override fun onStop() {
        super.onStop()
        // The activity is no longer visible (it is now "stopped")
    }

    override fun onDestroy() {
        super.onDestroy()
        // The activity is about to be destroyed.
        Toast.makeText(this, "안녕히 가세요", Toast.LENGTH_SHORT).show()
    }
}


