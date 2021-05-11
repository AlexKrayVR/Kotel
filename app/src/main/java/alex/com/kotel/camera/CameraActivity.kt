package alex.com.kotel.camera

import alex.com.kotel.R
import alex.com.kotel.camera.adapter.CameraAdapter
import alex.com.kotel.databinding.ActivityCameraBinding
import alex.com.kotel.logging.Logging
import android.os.Bundle
import android.view.View
import android.widget.ScrollView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSmoothScroller
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.SmoothScroller


class CameraActivity : AppCompatActivity() {

    lateinit var binding: ActivityCameraBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCameraBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var images = arrayListOf<String>(
            "https://i.pinimg.com/originals/1b/55/30/1b5530626b0a8c782f5b3e4d4cb2a4f2.jpg",
            "https://i.pinimg.com/originals/1b/55/30/1b5530626b0a8c782f5b3e4d4cb2a4f2.jpg",
            "https://cdn.pixabay.com/photo/2016/10/20/18/35/earth-1756274__340.jpg",
            "https://cdn.pixabay.com/photo/2016/10/20/18/35/earth-1756274__340.jpg",
            "https://cdn.pixabay.com/photo/2016/10/20/18/35/earth-1756274__340.jpg",
            "https://cdn.pixabay.com/photo/2016/10/20/18/35/earth-1756274__340.jpg",
            "https://cdn.pixabay.com/photo/2016/10/20/18/35/earth-1756274__340.jpg",
            "https://cdn.pixabay.com/photo/2016/10/20/18/35/earth-1756274__340.jpg",
            "https://cdn.pixabay.com/photo/2016/10/20/18/35/earth-1756274__340.jpg",
            "https://cdn.pixabay.com/photo/2016/10/20/18/35/earth-1756274__340.jpg",
            "https://besthqwallpapers.com/Uploads/19-11-2017/29500/thumb2-planets-4k-saturn-galaxy-stars.jpg",
            "https://astrovedicculture.com/wp-content/uploads/2020/01/saturn-and-galactic-center.jpg",
            "https://astrovedicculture.com/wp-content/uploads/2020/01/saturn-and-galactic-center.jpg",
            "https://i.pinimg.com/originals/15/6c/f4/156cf40e439434d90e8bbfe218b8e797.jpg"
        )

        var manager: LinearLayoutManager;
        manager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        var adapter = CameraAdapter(images, manager, this)

        binding.recyclerImages.layoutManager = manager
        binding.recyclerImages.adapter = adapter
        binding.recyclerImages.setHasFixedSize(false)
        //binding.recyclerImages.scrollToPosition(adapter.itemCount - 1)\

        adapter.setListener(object : CameraAdapter.Listener {
            override fun done(view: View) {

                binding.recyclerImages.smoothScrollToPosition(adapter.itemCount - 1)



                //TODO ЗАПОМНИ!!! ЧТО ТАК ТОЖЕ МОЖНО
                //TODO ПОЧИТАТЬ ПРО КОТЛИН ФАЙЛ
                //TODO image library GLIDE COIN

                Logging.run {
                    logDebug("done! adapter size: ${adapter.itemCount}")
                    logDebug("view.height: ${view.height}")
                    logDebug("binding.recyclerImages: ${binding.recyclerImages.height}")
                }

//                Logging.logDebug("done! adapter size: ${adapter.itemCount}")
//                Logging.logDebug("view.height: ${view.height}")
//                Logging.logDebug("binding.recyclerImages: ${binding.recyclerImages.height}")

//
//                binding.recyclerImages.smoothScrollBy(
//                    0,
//                    400
//                    //400 - dummy height
//                )

            }

        })

        //working only in fixed height
        binding.recyclerImages.post(Runnable {
            Logging.logDebug("post")
            binding.recyclerImages.scrollToPosition(adapter.itemCount - 1)
        })


//        val smoothScroller: SmoothScroller = object : LinearSmoothScroller(this) {
//            override fun getVerticalSnapPreference(): Int {
//                return SNAP_TO_START
//            }
//        }
//        smoothScroller.targetPosition = adapter.itemCount - 1;
//        manager.startSmoothScroll(smoothScroller);


        binding.button.setOnClickListener {
            adapter.addPicture("https://i.pinimg.com/474x/1d/e0/ee/1de0eef600f9c57f451d44f64684df2d.jpg")
            //images.add("https://i.pinimg.com/474x/1d/e0/ee/1de0eef600f9c57f451d44f64684df2d.jpg")
            //binding.recyclerImages.scrollToPosition(adapter.itemCount - 1)
            //binding.recyclerImages.smoothScrollBy(0, binding.recyclerImages.height)

        }

    }
}