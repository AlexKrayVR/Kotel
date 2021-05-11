package alex.com.kotel.common

import alex.com.kotel.adapter.DummyAdapter
import alex.com.kotel.database.Dummy
import alex.com.kotel.database.DummyDatabase
import alex.com.kotel.databinding.ActivityMainBinding
import alex.com.kotel.logging.Logging
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.util.ArrayList

open class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val db = DummyDatabase.getDatabase(this)

        val first = Dummy(0, "dfggdf", 45);
        val second = Dummy(0, "ghjjjj", 23);
        val third = Dummy(0, "5fghfhh", 77);
        db.dummyDao().insert(first, second, third)
        val list = db.dummyDao().getAllSimple()

        Logging.logDebug(list.joinToString())


        val adapter = DummyAdapter(list as ArrayList<Dummy>, this)
        binding.recyclerView.adapter = adapter
        binding.add.setOnClickListener {
            list.add(first)
            db.dummyDao().insert(first)
            binding.recyclerView.scrollToPosition(adapter.getSize()-1)
        }


    }


    override fun onStop() {
        super.onStop()
    }
}