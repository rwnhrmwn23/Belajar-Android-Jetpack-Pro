package com.onedev.dicoding.academy.ui.academy

import android.annotation.SuppressLint
import android.opengl.Visibility
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.onedev.dicoding.academy.databinding.FragmentAcademyBinding
import com.onedev.dicoding.academy.utils.DataDummy
import com.onedev.dicoding.academy.viewmodel.ViewModelFactory

class AcademyFragment : Fragment() {
    private var _binding: FragmentAcademyBinding? = null
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentAcademyBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, factory)[AcademyViewModel::class.java]
            val academyAdapter = AcademyAdapter()

            binding?.progressBar?.visibility = View.VISIBLE
            viewModel.getCourse().observe(viewLifecycleOwner, {
                binding?.progressBar?.visibility = View.GONE
                academyAdapter.setCourses(it)
                academyAdapter.notifyDataSetChanged()
            })

            binding?.rvAcademy?.apply {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = academyAdapter
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}