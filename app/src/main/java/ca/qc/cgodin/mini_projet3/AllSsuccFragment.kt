package ca.qc.cgodin.mini_projet3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.navGraphViewModels
import ca.qc.cgodin.mini_projet3.Adapter.sucAdapter
import ca.qc.cgodin.mini_projet3.ViewModel.SSuccViewModel
import ca.qc.cgodin.mini_projet3.databinding.FragmentAllSsuccBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


/**
 * A simple [Fragment] subclass.
 * Use the [AllSsuccFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AllSsuccFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var _binding: FragmentAllSsuccBinding? = null
    private val binding get() = _binding!!
    private lateinit var sucAdapter: sucAdapter
    private val viewModel: SSuccViewModel by navGraphViewModels(R.id.nav_graph)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sucAdapter = sucAdapter(view.context)
        binding.rvListSuc.adapter = sucAdapter
        viewModel.allSuccs.observe(viewLifecycleOwner, Observer{ succs ->
            succs?.let { sucAdapter.setSSuc(it) }
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
        _binding = FragmentAllSsuccBinding.inflate(inflater, container, false)
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
         * @return A new instance of fragment AllSsuccFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AllSsuccFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}