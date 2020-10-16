package sheridan.tetervak.samplemidtermv3p1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import sheridan.tetervak.samplemidtermv3p1.databinding.ActivityOutputBinding
import sheridan.tetervak.samplemidtermv3p1.model.BreedInfo

class OutputActivity : AppCompatActivity() {

    companion object{
        const val BREED_INFO = "breed_info"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityOutputBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.breedInfo = intent.getSerializableExtra(BREED_INFO) as BreedInfo

        binding.backButton.setOnClickListener { finish() }
    }
}