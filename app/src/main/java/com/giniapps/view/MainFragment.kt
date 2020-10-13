package com.giniapps.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.giniapps.R
import com.giniapps.databinding.FragmentMainBinding
import com.giniapps.view.adapter.MainAdapter
import com.giniapps.view.viewmodel.MainViewModel
import org.koin.android.ext.android.get


class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private val mainViewModel = get<MainViewModel>()
    private lateinit var mainAdapter : MainAdapter


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        mainAdapter = MainAdapter(requireContext())
        mainViewModel.getAllNumbers().observe(viewLifecycleOwner, { value ->
            if (value == null) {
                Toast.makeText(requireContext(), getString(R.string.main_fragment_fetch_error), Toast.LENGTH_SHORT).show()
                return@observe
            }
            binding.mainRecyclerview.adapter = mainAdapter
            binding.mainRecyclerview.setHasFixedSize(true)
            binding.mainRecyclerview.layoutManager = GridLayoutManager(requireContext(), 3)
            mainAdapter.submitList(value)
        })
    }
}