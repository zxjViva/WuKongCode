package com.zxj.wukong.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.zxj.wukong.BR
import com.zxj.wukong.R
import com.zxj.wukong.data.CaseInfo
import com.zxj.wukong.databinding.ItemCaseBinding

class CasesAdapter(var data: List<CaseInfo>?) : RecyclerView.Adapter<CasesAdapter.Holder>() {
    interface OnClickListener{
        fun onClick(view: ImageView,caseInfo: CaseInfo)
    }
    var addBtClickListener:OnClickListener? = null

    class Holder(var itemCaseBinding: ItemCaseBinding) :
        RecyclerView.ViewHolder(itemCaseBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(ItemCaseBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return if (data.isNullOrEmpty()) 0 else data!!.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val caseInfo = data!![position]
        holder.itemCaseBinding.setVariable(BR.caseInfo, caseInfo)
        holder.itemCaseBinding.addView.setOnClickListener{
            addBtClickListener?.onClick(holder.itemCaseBinding.addView, caseInfo)
        }

        holder.itemView.setOnClickListener {
            it.findNavController().navigate(R.id.action_homeFragment_to_caseDescFragment)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return R.layout.item_case
    }

}