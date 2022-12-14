package ca.qc.cgodin.mini_projet3

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.navGraphViewModels
import ca.qc.cgodin.mini_projet3.ViewModel.SucViewModel
import ca.qc.cgodin.mini_projet3.databinding.FragmentConnexionBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ConnexionFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ConnexionFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var binding: FragmentConnexionBinding
    private val viewModel: SucViewModel by navGraphViewModels(R.id.nav_graph)



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }


    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

            binding.btnConnexion.setOnClickListener {
                lifecycleScope.launch {
                    withContext(Dispatchers.Main) {

                if (viewModel.connectStudent(binding.etID.text.toString(), binding.etPwd.text.toString()))
                {

                        Log.i("miniprojet3", "You have clicked on me!!")
                        val bundle = Bundle().apply {
                            putSerializable("aut", binding.etID.text.toString())
                        }
                        findNavController().navigate(
                            R.id.action_connexionFragment_to_allSucFragment, bundle
                        )

                    } else {
                        val toast = Toast.makeText(
                            context,
                            resources.getString(R.string.toast_conn_refus),
                            Toast.LENGTH_SHORT
                        )
                        toast.show()
                    }
            }
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentConnexionBinding.inflate(inflater, container, false)
        val view = binding.root


        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ConnexionFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ConnexionFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
