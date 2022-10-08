package ca.qc.cgodin.mini_projet3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import ca.qc.cgodin.mini_projet3.ViewModel.SucViewModel
import ca.qc.cgodin.mini_projet3.ViewModel.SucViewModelProviderFactory
import ca.qc.cgodin.mini_projet3.databinding.ActivityMainBinding
import ca.qc.cgodin.mini_projet3.repository.SucRepository

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var sucViewModel: SucViewModel

    private val navController by lazy {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navHostFragment.navController }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.bottomNavigationView.setupWithNavController(navController)


        val sucRep = SucRepository()
        val viewProvider = SucViewModelProviderFactory(sucRep)

        try {
            val viewModelProvider = ViewModelProvider(
                navController.getViewModelStoreOwner(R.id.nav_graph),
                viewProvider)
            sucViewModel = viewModelProvider.get(SucViewModel::class.java)
        }catch (e: IllegalArgumentException){
            e.printStackTrace()
        }
        //val fragmentTransaction = supportFragmentManager.beginTransaction()
        //fragmentTransaction.add(R.id.fragmentContainerView,ConnexionFragment.newInstance("","")).commit()
        binding.bottomNavigationView.setOnClickListener{
            when(it.id){
                R.id.allSucFragment->{
                    val fragment = AllSucFragment()
                    supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView, fragment).commit()
                }
                R.id.addSucFragment->{
                    val fragment = AddSucFragment()
                    supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView, fragment).commit()

                }

            }
        }
    }
}
