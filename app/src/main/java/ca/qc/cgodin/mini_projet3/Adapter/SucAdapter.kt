package ca.qc.cgodin.mini_projet3.Adapter

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import ca.qc.cgodin.mini_projet3.R
import ca.qc.cgodin.mini_projet3.Room.SavedSuccs
import ca.qc.cgodin.mini_projet3.models.Succursales

class sucAdapter constructor(context: Context): RecyclerView.Adapter<sucAdapter.SucViewHolder>() {

    private val context: Context = context
    private var Suc: List<Succursales> = emptyList()
    private var SSuc: List<SavedSuccs> = emptyList<SavedSuccs>()
    private lateinit var onItemClickListener: ((Succursales) -> Unit)

    inner class SucViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val root: LinearLayout = itemView.findViewById(R.id.constraintLayout)
        val idNo: TextView = itemView.findViewById(R.id.tvNo)
        val tvVille: TextView = itemView.findViewById(R.id.tvVille)
        val tvBudget: TextView = itemView.findViewById(R.id.tvBudget)
        val tvMatricule: TextView = itemView.findViewById(R.id.tvMatricule)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SucViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.suc_item, parent, false)
        return SucViewHolder(view)
    }

    override fun onBindViewHolder(holderSuc: SucViewHolder, position: Int) {
        val suc = Suc[position]


        if(position % 3 == 0){
            holderSuc.root.setBackgroundColor(ContextCompat.getColor(context, R.color.hellblau))
        }
        else if (position % 3 == 1){
            holderSuc.root.setBackgroundColor(ContextCompat.getColor(context, R.color.blau))
        }
        else if (position % 3 == 2){
            holderSuc.root.setBackgroundColor(ContextCompat.getColor(context, R.color.dunkelblau))
        }
        holderSuc.itemView.apply {
            //Glide.with(this).load(suc.urlToImage).into(holderSuc.ivCoverImage)
            holderSuc.idNo.text = suc.accesMdP
            holderSuc.tvVille.text = suc.ville
            holderSuc.tvBudget.text = suc.budget
            holderSuc.tvMatricule.text = suc.accesMdP
        }

        holderSuc.itemView.setOnClickListener {
            onItemClickListener(suc)
        }


    }

    fun setOnItemClickListener(listener: (Succursales) -> Unit){
        onItemClickListener = listener
    }


    override fun getItemCount(): Int = Suc.size

    fun setSuc(sucs: List<Succursales>) {
        this.Suc = sucs
        notifyDataSetChanged()
    }

    fun setSSuc(succs: List<SavedSuccs>){
        this.SSuc = succs
        notifyDataSetChanged()
    }
}