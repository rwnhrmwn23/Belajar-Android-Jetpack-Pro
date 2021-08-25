package com.onedev.dicoding.academy.ui.reader.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.onedev.dicoding.academy.data.ModuleEntity
import com.onedev.dicoding.academy.databinding.ItemsModuleListCustomBinding

class ModuleListAdapter internal constructor(private val listener: MyAdapterClickListener): RecyclerView.Adapter<ModuleListAdapter.ModuleViewHolder>(){
    private val listModules = ArrayList<ModuleEntity>()

    internal fun setModules(modules: List<ModuleEntity>?) {
        if (modules == null) return
        this.listModules.clear()
        this.listModules.addAll(modules)
    }

    inner class ModuleViewHolder(private val binding: ItemsModuleListCustomBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(moduleEntity: ModuleEntity) {
            with(binding) {
                textModuleTitle.text = moduleEntity.title
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ModuleViewHolder {
        val binding = ItemsModuleListCustomBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ModuleViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ModuleViewHolder, position: Int) {
        holder.bind(listModules[position])
        holder.itemView.setOnClickListener {
            listener.onItemClicked(holder.adapterPosition, listModules[holder.adapterPosition].moduleId)
        }
    }

    override fun getItemCount(): Int = listModules.size

    internal interface MyAdapterClickListener {
        fun onItemClicked(position: Int, moduleId: String)
    }
}