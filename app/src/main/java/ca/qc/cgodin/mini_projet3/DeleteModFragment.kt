package ca.qc.cgodin.mini_projet3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.navGraphViewModels
import ca.qc.cgodin.mini_projet3.Adapter.sucAdapter
import ca.qc.cgodin.mini_projet3.ViewModel.SucViewModel
import ca.qc.cgodin.mini_projet3.databinding.FragmentDeleteModBinding
import ca.qc.cgodin.mini_projet3.models.Succursales
import com.google.gson.Gson


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DeleteModFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DeleteModFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var binding: FragmentDeleteModBinding
    private lateinit var sucAdapter: sucAdapter
    private val viewModel: SucViewModel by navGraphViewModels(R.id.nav_graph)

    private var obj: Succursales? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
            obj = it.getSerializable("Succursales") as Succursales?
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDeleteModBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //val suc1 = args.succursale
        binding.access.setText(obj?.accesMdP)
        binding.budget.setText(obj?.budget)
        binding.ville.setText(obj?.ville)


        //val suc:Succursales = Gson().fromJson(data.toString(), Succursales::class.java)
        //val string = Json.encodeToString(data)

        //val jsonData = JSON.stringify(obj?.let { Succursales(it.accesMdP) }, MyModel(42))
        //Log.i("test", suc.toString())
        binding.buttonSup.setOnClickListener(){
            val data = Succursales(obj?.accesMdP.toString(), obj?.budget.toString(), obj?.ville.toString())

            var gson = Gson()
            var json = gson.toJson(data)
            viewModel.deleteSuc(json)
            Toast.makeText(getActivity(), "succursale supprimer", Toast.LENGTH_LONG).show()

        }

        binding.buttonModifier.setOnClickListener(){
            val data = Succursales(binding.access.text.toString(), binding.ville.text.toString(), binding.budget.text.toString())

            var gson = Gson()
            var json = gson.toJson(data)
            viewModel.UpdateSuc(json)
            Toast.makeText(activity, "succursale mis à jour", Toast.LENGTH_LONG).show()
        }


    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment DeleteModFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            DeleteModFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}