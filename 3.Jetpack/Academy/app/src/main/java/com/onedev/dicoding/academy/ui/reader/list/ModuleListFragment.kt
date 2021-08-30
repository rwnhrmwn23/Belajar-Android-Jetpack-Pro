package com.onedev.dicoding.academy.ui.reader.list

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.onedev.dicoding.academy.data.ModuleEntity
import com.onedev.dicoding.academy.databinding.FragmentModuleListBinding
import com.onedev.dicoding.academy.ui.course.CourseReaderActivity
import com.onedev.dicoding.academy.ui.course.CourseReaderViewModel
import com.onedev.dicoding.academy.ui.reader.CourseReaderCallback
import com.onedev.dicoding.academy.utils.DataDummy
import com.onedev.dicoding.academy.viewmodel.ViewModelFactory

class ModuleListFragment : Fragment(), ModuleListAdapter.MyAdapterClickListener {
    private var _binding: FragmentModuleListBinding? = null
    private val binding get() = _binding

    private lateinit var adapter: ModuleListAdapter
    private lateinit var courseReaderCallback: CourseReaderCallback
    private lateinit var viewModel: CourseReaderViewModel

    companion object {
        const val TAG = "ModuleListFragment"
        fun newInstance(): ModuleListFragment = ModuleListFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentModuleListBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val factory = ViewModelFactory.getInstance(requireActivity())
        viewModel = ViewModelProvider(requireActivity(), factory)[CourseReaderViewModel::class.java]

        binding?.progressBar?.visibility = View.VISIBLE
        adapter = ModuleListAdapter(this)
        viewModel.getModules().observe(viewLifecycleOwner, {
            populateRecyclerView(it)
        })
    }

    private fun populateRecyclerView(modules: List<ModuleEntity>) {
        binding?.apply {
            val dividerItemDecoration = DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL)
            progressBar.visibility = View.GONE
            adapter.setModules(modules)
            rvModule.setHasFixedSize(true)
            rvModule.layoutManager = LinearLayoutManager(context)
            rvModule.adapter = adapter
            rvModule.addItemDecoration(dividerItemDecoration)
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        courseReaderCallback = context as CourseReaderActivity
    }

    override fun onItemClicked(position: Int, moduleId: String) {
        courseReaderCallback.moveTo(position, moduleId)
        viewModel.setSelectedModule(moduleId)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}