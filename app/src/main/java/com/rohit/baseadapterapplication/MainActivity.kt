package com.rohit.baseadapterapplication

import android.app.Dialog
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.rohit.baseadapterapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var binding: ActivityMainBinding? = null
    var Array = arrayListOf("car", "bike", "boat","aeroplane")
    var baseAdapterClass= BaseAdapterClass(Array)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding?.listview?.adapter = baseAdapterClass
        binding?.fab?.setOnClickListener {
            var dialog = Dialog(this)
            dialog.setContentView(R.layout.custom_dialog)
            dialog.show()
            var etName = dialog.findViewById<EditText>(R.id.etName)
            var btName = dialog.findViewById<Button>(R.id.btName)
            btName?.setOnClickListener {
                if (etName?.text.toString().isNullOrEmpty()) {
                    etName?.error = "enter the vehicle"
                } else {
                    Array.add(etName.text.toString())
                    dialog.dismiss()
                    baseAdapterClass.notifyDataSetChanged()
                }
            }
        }
            binding?.listview?.setOnItemClickListener { parent, view, position, id ->
                var dialog = Dialog(this)
                dialog.setContentView(R.layout.custom_dialog2)
                dialog.show()
                var name = dialog.findViewById<EditText>(R.id.updatename)
                var update = dialog.findViewById<Button>(R.id.udpate_btn)
                var delete = dialog.findViewById<Button>(R.id.delete_btn)
                update.setOnClickListener {
                    Array.add(name.text.toString())
                    dialog.dismiss()
                    baseAdapterClass.notifyDataSetChanged()
                }
                delete.setOnClickListener {
                    Array.removeAt(position)
                    dialog.dismiss()
                    baseAdapterClass.notifyDataSetChanged()
                }
            }
    }
}