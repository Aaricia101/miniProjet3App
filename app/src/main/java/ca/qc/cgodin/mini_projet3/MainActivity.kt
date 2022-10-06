package ca.qc.cgodin.mini_projet3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import ca.qc.cgodin.mini_projet3.ViewModel.SucViewModel
import ca.qc.cgodin.mini_projet3.ViewModel.SucViewModelProviderFactory
import ca.qc.cgodin.mini_projet3.databinding.ActivityMainBinding
import ca.qc.cgodin.mini_projet3.repository.SucRepository

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.fragmentContainerView,ConnexionFragment.newInstance("","")).commit()
    }
}
