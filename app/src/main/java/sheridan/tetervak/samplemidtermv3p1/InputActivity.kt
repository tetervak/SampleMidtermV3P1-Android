package sheridan.tetervak.samplemidtermv3p1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import sheridan.tetervak.samplemidtermv3p1.OutputActivity.Companion.BREED_INFO
import sheridan.tetervak.samplemidtermv3p1.databinding.ActivityInputBinding
import sheridan.tetervak.samplemidtermv3p1.model.BreedInfo

class InputActivity : AppCompatActivity() {

    private lateinit var binding: ActivityInputBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInputBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.submitButton.setOnClickListener{showOutput()}
    }

    private fun showOutput() {
        val breedName = binding.breedInput.text.toString().trim()
        if (breedName.isEmpty()) {
            val required = getString(R.string.required)
            binding.breedInput.error = required
            Toast.makeText(this, required, Toast.LENGTH_LONG).show()
        } else {
            val hairList = resources.getStringArray(R.array.hair_list)
            val hairLength = hairList[binding.hairInput.selectedItemPosition]
            val breedInfo = BreedInfo(breedName, hairLength)
            val intent = Intent(this, OutputActivity::class.java)
            intent.putExtra(BREED_INFO, breedInfo)
            startActivity(intent)
        }
    }
}