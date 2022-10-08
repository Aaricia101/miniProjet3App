package ca.qc.cgodin.mini_projet3

import android.app.Activity
import android.content.Intent
import android.os.Bundle

import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.navGraphViewModels
import ca.qc.cgodin.mini_projet3.Adapter.sucAdapter
import ca.qc.cgodin.mini_projet3.ViewModel.SucViewModel
import ca.qc.cgodin.mini_projet3.databinding.FragmentAllSucBinding


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AllSucFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AllSucFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var binding: FragmentAllSucBinding
    private lateinit var sucAdapter: sucAdapter
    private val viewModel: SucViewModel by navGraphViewModels(R.id.nav_graph)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sucAdapter = sucAdapter()
        binding.rvListSuc.adapter = sucAdapter
        viewModel.getSuc()
        viewModel.listSucs.observe(viewLifecycleOwner, Observer {
                resp -> sucAdapter.setSuc(resp)

        })


    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAllSucBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        sucAdapter.setOnItemClickListener {
            val bundle = Bundle().apply {
                putSerializable("Succursales", it)
            }

            findNavController().navigate(
                R.id.action_allSucFragment_to_deleteModFragment,
                bundle
            )

        }
    }



    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment AllSucFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AllSucFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}