package com.candidate.servando.search.ui

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.view.LayoutInflater
import com.candidate.servando.search.R
import androidx.recyclerview.widget.RecyclerView
import com.candidate.servando.search.core.domain.Category
import com.candidate.servando.search.ui.widget.CategoriesReactionPublisher

class CategoriesAdapter(private val categories: List<Category>) : RecyclerView.Adapter<CategoriesAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.category_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = categories.size

    override fun onBindViewHolder(holder: CategoriesAdapter.ViewHolder, position: Int) {
        holder.categoryTitle.text = categories[position].name
        holder.categoryId = categories[position].id
    }

    class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        var categoryId: String = ""
        val categoryTitle: TextView = view.findViewById(R.id.categoriesTitle)

        init {
            view.setOnClickListener {
                CategoriesReactionPublisher.clicked(categoryId)
            }
        }
    }
}