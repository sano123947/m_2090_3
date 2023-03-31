package ru.geekbraines.m_2090_3.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import ru.geekbraines.m_2090_3.databinding.FragmentFirstBinding
import ru.geekbraines.m_2090_3.databinding.FragmentPictureBinding
import ru.geekbraines.m_2090_3.viewmodel.AppState
import ru.geekbraines.m_2090_3.viewmodel.PictureOfTheDayViewModel

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class PictureOfTheDayFragment : Fragment() {

    private var _binding: FragmentPictureBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentPictureBinding.inflate(inflater, container, false)
        return binding.root

    }

    val viewModel: PictureOfTheDayViewModel by lazy {
        ViewModelProvider(this).get(PictureOfTheDayViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getLiveData().observe(viewLifecycleOwner
        ) { }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}