package com.example.myapplication.ui.scan

import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentGalleryBinding
import com.example.myapplication.user.ScannerActivity

class ScanFragment : Fragment() {
lateinit var attendeButton: Button
    private var _binding: FragmentGalleryBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val galleryViewModel =
            ViewModelProvider(
                this,
                ViewModelProvider.NewInstanceFactory()
            ).get(ScanViewModel::class.java)

        _binding = FragmentGalleryBinding.inflate(inflater, container, false)
        val root: View = binding.root



        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        attendeButton = view.findViewById(R.id.to_scan)
        attendeButton.setOnClickListener {
          val intent = Intent(context, ScannerActivity::class.java).apply {
              startActivity(this)
          }
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}