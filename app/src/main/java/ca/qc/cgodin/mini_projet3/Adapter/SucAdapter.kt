package ca.qc.cgodin.mini_projet3.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ca.qc.cgodin.mini_projet3.R
import ca.qc.cgodin.mini_projet3.models.Succursale
import com.bumptech.glide.Glide

class sucAdapter: RecyclerView.Adapter<sucAdapter.SucViewHolder>() {

    private var Suc: List<Succursale> = emptyList()

    inner class SucViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
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


        holderSuc.itemView.apply {
            //Glide.with(this).load(suc.urlToImage).into(holderSuc.ivCoverImage)
            holderSuc.idNo.text = suc.no.toString()
            holderSuc.tvVille.text = suc.ville
            holderSuc.tvBudget.text = suc.budget.toString()
            holderSuc.tvMatricule.text = suc.matricule.toString()
        }


    }


    override fun getItemCount(): Int = Suc.size

    fun setSuc(sucs: List<Succursale>) {
        this.Suc = sucs
        notifyDataSetChanged()
    }
}