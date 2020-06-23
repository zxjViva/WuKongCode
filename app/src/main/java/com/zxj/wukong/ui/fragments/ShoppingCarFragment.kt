package com.zxj.wukong.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.zxj.wukong.adapter.ShoppingCartAdapter
import com.zxj.wukong.adapter.SpacesItemDecoration
import com.zxj.wukong.data.CaseInfo
import com.zxj.wukong.databinding.FragmentShoppingcartBinding
import com.zxj.wukong.repository.local.DbManager
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ShoppingCarFragment : Fragment() {
    lateinit var binding: FragmentShoppingcartBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentShoppingcartBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        GlobalScope.launch {
            val casesInfo = DbManager.shoppingCartDao.queryAll()
            activity?.runOnUiThread {
                val shoppingCartAdapter = ShoppingCartAdapter(casesInfo)
                binding.rv.adapter = shoppingCartAdapter
                binding.rv.addItemDecoration(SpacesItemDecoration(8))
                addTouchHelper()
            }
        }

    }

    private fun addTouchHelper() {
        ItemTouchHelper(object : ItemTouchHelper.Callback() {
            override fun getMovementFlags(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder
            ): Int {
                val dragFlags = ItemTouchHelper.DOWN or ItemTouchHelper.UP
                return makeMovementFlags(dragFlags, 0)
            }

            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                val shoppingCartAdapter = recyclerView.adapter as ShoppingCartAdapter
                val sourceCase = shoppingCartAdapter.casesInfo[viewHolder.bindingAdapterPosition]
                sourceCase.index = target.bindingAdapterPosition
                val targetCase = shoppingCartAdapter.casesInfo[target.bindingAdapterPosition]
                targetCase.index = viewHolder.bindingAdapterPosition
                updateSql(sourceCase,targetCase)
                recyclerView.adapter?.notifyItemMoved(
                    viewHolder.bindingAdapterPosition,
                    target.bindingAdapterPosition
                )
                return true
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {

            }

        }).attachToRecyclerView(binding.rv)
    }
    private fun updateSql(
        source: CaseInfo, target: CaseInfo){
        GlobalScope.launch {
            DbManager.shoppingCartDao.update(source)
            DbManager.shoppingCartDao.update(target)
        }
    }
}