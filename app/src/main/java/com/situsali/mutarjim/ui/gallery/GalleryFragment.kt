package com.situsali.mutarjim.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.situsali.mutarjim.R
import com.situsali.mutarjim.databinding.FragmentGalleryBinding

class GalleryFragment : Fragment() {

    private lateinit var galleryViewModel: GalleryViewModel
    private var _binding: FragmentGalleryBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        galleryViewModel =
            ViewModelProvider(this).get(GalleryViewModel::class.java)

        _binding = FragmentGalleryBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textGallery
        val listTranslate: ListView = binding.listTranslate

        galleryViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })

        val array = arrayOf("Halo","Saya","Adalah", "Array")
        listTranslate.adapter = activity?.let { ArrayAdapter(it, R.layout.listview_item, array) }

        return root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}