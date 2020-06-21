package com.zxj.wukong.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.zxj.wukong.BR
import com.zxj.wukong.R
import com.zxj.wukong.data.CaseInfo
import com.zxj.wukong.databinding.ItemShoppingCartBinding
import com.zxj.wukong.repository.local.DbManager
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ShoppingCartAdapter(var casesInfo:List<CaseInfo>): RecyclerView.Adapter<ShoppingCartAdapter.Holder>() {
    class Holder(var viewBinding:ItemShoppingCartBinding):RecyclerView.ViewHolder(viewBinding.root)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(ItemShoppingCartBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return if (casesInfo.isNullOrEmpty()) 0 else casesInfo.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val caseInfo = casesInfo[position]
        holder.viewBinding.setVariable(BR.caseInfo, caseInfo)
        holder.viewBinding.trashCanIv.setOnClickListener {
            GlobalScope.launch {
                DbManager.shoppingCartDao.delete(caseInfo)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return R.layout.item_shopping_cart
    }
}