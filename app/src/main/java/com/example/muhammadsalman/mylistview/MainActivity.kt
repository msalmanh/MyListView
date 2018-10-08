package com.example.muhammadsalman.mylistview

import android.content.Context
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val listview = findViewById<ListView>(R.id.main_listview)
        //val redColor = Color.parseColor("#ff0000")
        //listview.setBackgroundColor(redColor)

        listview.adapter = MyCustomAdaptor(this)
    }


    private class MyCustomAdaptor(context: Context): BaseAdapter(){

        private val mContext:Context

        private val names = arrayListOf<String>(
                "Muhammad", "Salman", "Hussain","kotlin","xml","book","Love","Pray","Party",
                "Family","Friends"
        )

        init {
            mContext = context
        }


        //responsible for how many row i have in my list
        override fun getCount(): Int {
            //return 10
            return names.size
        }

        //ignore this too
        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        //igonre this
        override fun getItem(position: Int): Any {
            return "test string"
        }

        //responsible for rendering each row
        override fun getView(position: Int, convertView: View?, viewGroup: ViewGroup?): View {

            val layoutinflator = LayoutInflater.from(mContext)
            val rowMain = layoutinflator.inflate(R.layout.row_main, viewGroup, false)

            val nameTextView = rowMain.findViewById<TextView>(R.id.name_textView)
            nameTextView.text = names.get(position)


            val  poisitionTextView =rowMain.findViewById<TextView>(R.id.position_textview)
            poisitionTextView.text = "row number :$position"


            return rowMain
            //val textView = TextView(mContext)
            //textView.text = "here is my row for my listview"
            //return textView



        }
    }
}
