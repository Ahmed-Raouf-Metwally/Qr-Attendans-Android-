package com.example.myapplication.ui.dashboard
import androidx.lifecycle.ViewModelProvider
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.myapplication.R
import com.example.myapplication.api.ApiManager
import com.example.myapplication.databinding.FragmentHomeBinding
import com.example.myapplication.model.SubjectsItem
import com.example.myapplication.model.SubjectsResponse
import com.example.myapplication.ui.Adapters.SubjectsAdapter
import com.example.myapplication.ui.Adapters.SubjectsData
import com.example.myapplication.user.Lessons
import com.example.myapplication.user.stu
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

var SubjectsResponse: SubjectsResponse? = null
var MatId:Int?= null
class DashboardFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(
                this,
                ViewModelProvider.NewInstanceFactory()
            ).get(DashBoardViewModel::class.java)
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View =
            binding.root
        return root
    }
lateinit var subsrecy : RecyclerView
lateinit var subsadap : SubjectsAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subsrecy = view.findViewById(R.id.subjects_recycler)
        creat()
        subsadap = SubjectsAdapter(subNameList)
        subsrecy.adapter = subsadap
        subsadap.setSubjectClickListener(object : SubjectsAdapter.OnSubjectClickListener {
            override fun onSubjectClick(position: Int) {
                 MatId = SubjectsResponse?.subjects?.get(position)?.iD
                var intent = Intent(context, Lessons::class.java)
                startActivity(intent)
            }

        })
    }

    var subNameList : MutableList<SubjectsItem?>? = SubjectsResponse?.subjects ?: mutableListOf()
    fun creat(){
        ApiManager.getApis().getStudentSubject(stu).enqueue(object : Callback<SubjectsResponse> {
            override fun onResponse(
                call: Call<SubjectsResponse>,
                response: Response<SubjectsResponse>
            ) {
                Toast.makeText(requireContext(), "DONE", Toast.LENGTH_SHORT).show()
                SubjectsResponse = response.body()
            }

            override fun onFailure(call: Call<SubjectsResponse>, t: Throwable) {
                Toast.makeText(requireContext(), "network issue", Toast.LENGTH_SHORT).show()            }

        })
        }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}

