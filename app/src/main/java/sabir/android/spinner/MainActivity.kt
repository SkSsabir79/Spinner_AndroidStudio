package sabir.android.spinner

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import sabir.android.spinner.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val options = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, options)
        binding.optionsListView.adapter = adapter

        binding.addButton.setOnClickListener {
            val option = binding.optionEditText.text.toString()
            if (option.isNotEmpty()) {
                options.add(option)
                adapter.notifyDataSetChanged()
                binding.optionEditText.text.clear()
            } else {
                Toast.makeText(this, "Please enter an option", Toast.LENGTH_SHORT).show()
            }
        }

        binding.spinButton.setOnClickListener {
            if (options.isNotEmpty()) {
                val randomOption = options.random()
                Toast.makeText(this, "Selected: $randomOption", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Please add some options first", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
