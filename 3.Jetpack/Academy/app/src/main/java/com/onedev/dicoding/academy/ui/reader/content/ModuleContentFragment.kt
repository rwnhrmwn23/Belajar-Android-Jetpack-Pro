package com.onedev.dicoding.academy.ui.reader.content

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.onedev.dicoding.academy.data.ContentEntity
import com.onedev.dicoding.academy.data.ModuleEntity
import com.onedev.dicoding.academy.databinding.FragmentModuleContentBinding
import com.onedev.dicoding.academy.ui.course.CourseReaderViewModel

class ModuleContentFragment : Fragment() {
    private var _binding: FragmentModuleContentBinding? = null
    private val binding get() = _binding

    companion object {
        const val TAG = "ModuleContentFragment"
        fun newInstance(): ModuleContentFragment = ModuleContentFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentModuleContentBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            val viewModel = ViewModelProvider(requireActivity()).get(CourseReaderViewModel::class.java)
            val module = viewModel.getSelectedModule()
            populateWebView(module)
        }

    }

    private fun populateWebView(module: ModuleEntity) {
        binding?.webView?.loadData(module.contentEntity?.content ?: "", "text/html", "UTF-8")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}