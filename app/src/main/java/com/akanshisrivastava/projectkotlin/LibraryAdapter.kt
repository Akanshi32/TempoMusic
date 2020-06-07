package com.akanshisrivastava.projectkotlin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class LibraryAdapter(
    context: Context?,
    music: List<String?>
) :
    ArrayAdapter<String?>(context!!, 0, music) {
    override fun getView(
        position: Int,
        convertView: View?,
        parent: ViewGroup

    ): View {

        var convertView = convertView

        val s = getItem(position)
        if (convertView == null) {
            convertView =
                LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)

        }
        val genreName = convertView!!.findViewById<TextView>(R.id.genre_title)
        genreName.text = s
        return convertView
    }
}