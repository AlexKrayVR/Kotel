package alex.com.kotel.camera.adapter

import alex.com.kotel.databinding.ItemPictureBinding
import alex.com.kotel.logging.Logging
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import java.util.*

class CameraAdapter(private var pictures: ArrayList<String>, private var manager: LinearLayoutManager, var context: Context) :
    RecyclerView.Adapter<CameraAdapter.PictureViewHolder>() {

    private lateinit var listener: Listener
    private var flag = false

    interface Listener {
        fun done(view: View)
    }

    fun setListener(listener: Listener) {
        this.listener = listener
    }

    fun addPicture(url: String) {
        pictures.add(url)
        flag = true
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CameraAdapter.PictureViewHolder {
        val binding = ItemPictureBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PictureViewHolder(binding)
    }


    override fun onBindViewHolder(holder: PictureViewHolder, position: Int) {
        Picasso.get()
            .load(pictures[position])
            .noPlaceholder()
            .centerCrop()
            .resize(400, 0)
            .into(holder.binding.image, object : Callback {
                override fun onSuccess() {
                    if (flag) {
                        Logging.logDebug("onSuccess-flag: $flag\tsize: ${pictures.size-1}")
                        listener.done(holder.binding.image)
                        flag = false

                        //manager.scrollToPosition(2)
                    }
                }

                override fun onError(e: Exception) {}
            })


    }

    override fun getItemCount(): Int {
        return pictures.size
    }

    class PictureViewHolder(var binding: ItemPictureBinding) :
        RecyclerView.ViewHolder(binding.root) {
    }


}