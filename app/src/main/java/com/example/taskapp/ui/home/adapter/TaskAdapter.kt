package com.example.h_w_1_4month.ui.home.adapter

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.taskapp.databinding.ItemTaskBinding
import com.example.taskapp.model.Task

class TaskAdapter(
    private var onLongClick: (Int) -> Unit, private var onUpdateClick: (Task) -> Unit,
) :
    RecyclerView.Adapter<TaskAdapter.ViewHolder>() {

    private var arrayTask = arrayListOf<Task>()
    @SuppressLint("NotifyDataSetChanged")
    fun addTasks(list: List<Task>) {
        arrayTask.clear()
        arrayTask.addAll(list)
        notifyDataSetChanged()
    }

    fun getTask(position: Int): Task {
        return arrayTask[position]
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemTaskBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.OnBind(
            arrayTask[position]
        )
    }

    override fun getItemCount(): Int {
        return arrayTask.size
    }

    fun deleteItemsAndNotifyAdapter(pos: Int) {
        arrayTask.removeAt(pos)
        notifyItemRemoved(pos)
    }

    inner class ViewHolder(private var binding: ItemTaskBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun OnBind(taskMode: Task) {
            binding.tvTitle.text = taskMode.title
            binding.tvDesc.text = taskMode.desc

            itemView.setOnLongClickListener {
                Log.e("ololo", "OnBind: $adapterPosition")
                onLongClick(adapterPosition)
                return@setOnLongClickListener true
            }
            itemView.setOnClickListener{
                onUpdateClick(taskMode)
            }
        }
    }
}