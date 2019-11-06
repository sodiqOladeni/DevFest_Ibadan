package dev.hackwithsodiq.devfestibadan.view.schedule

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import dev.hackwithsodiq.devfestibadan.R
import dev.hackwithsodiq.devfestibadan.utils.colorTagText

class TagsRecyclerViewAdapter(var tags:List<String>):RecyclerView.Adapter<TagsRecyclerViewAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_inline_tag, parent, false))
    }

    override fun getItemCount(): Int {
        return tags.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tagName.text = tags[position]
        holder.tagName.colorTagText(tags[position])
    }

    class ViewHolder(view: View):RecyclerView.ViewHolder(view){
        var tagName = view.findViewById<TextView>(R.id.tag_name)
        var parent = view.findViewById<LinearLayout>(R.id.parent)
    }
}