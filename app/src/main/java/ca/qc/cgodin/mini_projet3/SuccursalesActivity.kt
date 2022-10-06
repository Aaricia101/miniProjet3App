package ca.qc.cgodin.mini_projet3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import ca.qc.cgodin.mini_projet3.Adapter.sucAdapter
import ca.qc.cgodin.mini_projet3.ViewModel.SucViewModel
import ca.qc.cgodin.mini_projet3.ViewModel.SucViewModelProviderFactory
import ca.qc.cgodin.mini_projet3.databinding.ActivityMainBinding
import ca.qc.cgodin.mini_projet3.databinding.ActivitySuccursalesBinding
import ca.qc.cgodin.mini_projet3.repository.SucRepository

class SuccursalesActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySuccursalesBinding
    private lateinit var sucViewModel: SucViewModel
    private lateinit var sucAdapter: sucAdapter

    private val navController by lazy {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navHostFragment.navController
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySuccursalesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNavigationView.setupWithNavController(navController)

        val sucRepository = SucRepository()
        val viewModelProviderFactory = SucViewModelProviderFactory(sucRepository)

        try {
            val viewModelProvider = ViewModelProvider(
                navController.getViewModelStoreOwner(R.id.nav_graph), viewModelProviderFactory
            )
            sucViewModel = viewModelProvider.get(SucViewModel::class.java)

        } catch (e: IllegalArgumentException) {
            e.printStackTrace()
        }

        sucAdapter = sucAdapter()
        binding.rvListSuc.adapter = sucAdapter
        sucViewModel.listSucs.observe(this, Observer {
                resp -> sucAdapter.setSuc(resp)
        })

    }


}
