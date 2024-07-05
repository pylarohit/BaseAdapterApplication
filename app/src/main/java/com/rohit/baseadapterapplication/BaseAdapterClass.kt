package com.rohit.baseadapterapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.rohit.baseadapterapplication.databinding.BaseItemAdapterBinding

class BaseAdapterClass(var array: ArrayList<String>) : BaseAdapter() {
    var binding: BaseItemAdapterBinding? = null
    override fun getCount(): Int {
        return array.size
    }

    override fun getItem(position: Int): Any {
        return ""
    }

    override fun getItemId(position: Int): Long {
        return 1L
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.base_item_adapter,parent,false)
        return view
    }
}

