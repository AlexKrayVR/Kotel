package alex.com.kotel.adapter

import alex.com.kotel.R
import alex.com.kotel.database.Dummy
import alex.com.kotel.databinding.ItemDummyBinding
import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import java.math.BigDecimal
import java.util.ArrayList

class DummyAdapter(private var dummies: ArrayList<Dummy>, var context: Context) :
    RecyclerView.Adapter<DummyAdapter.DummyViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DummyAdapter.DummyViewHolder {
        val binding = ItemDummyBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DummyViewHolder(binding)
    }

    fun addNode(dummy: Dummy) {
        dummies.add(dummy)
        this.notifyDataSetChanged()
    }
    fun getSize():Int{
        return dummies.size
    }

    override fun onBindViewHolder(holder: DummyViewHolder, position: Int) {
        val current = dummies[position]

//        val text = "${context.getString(R.string.index)} ${current.id}"
        //val text = context.getString(R.string.index, current.id)
        holder.binding.id.text = context.getString(R.string.index, current.id)
        holder.binding.name.text = current.name
        holder.binding.count.text = current.count.toString()
    }

    override fun getItemCount(): Int {
        return dummies.size
    }

    class DummyViewHolder(var binding: ItemDummyBinding) : RecyclerView.ViewHolder(binding.root) {
    }


}