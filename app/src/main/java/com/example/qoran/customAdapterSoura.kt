package com.example.qoran

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.qoran.model.soura
import com.example.qoran.ui.MainActivity2
import kotlinx.android.synthetic.main.soura_item.view.*

class customAdapterSoura(var quran:ArrayList<soura>, var context: Context): RecyclerView.Adapter<customAdapterSoura.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.soura_item,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return quran.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textIndex.text=quran[position].id.toString()
        holder.textname.text="سوره ${quran[position].name}"
        holder.itemView.setOnClickListener {
            Toast.makeText(context,quran[position].name,Toast.LENGTH_LONG).show()
            val intent=Intent(holder.itemView.context,
                MainActivity2::class.java)
            intent.putExtra("sura_name",quran[position].name)
            intent.putExtra("standard_full",quran[position].sup())
            holder.itemView.context.startActivity(intent)
        }
    }

    //--------------------ViewHolder-------------------------------------------------------------
    class ViewHolder(view:View):RecyclerView.ViewHolder(view){
        var textIndex=view.soura_index
        var textname=view.soura_name
    }


}