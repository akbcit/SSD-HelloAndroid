package com.example.helloandroid

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.helloandroid.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.randomButton.setOnClickListener {
            // Get a reference to the text view
            val showCountTextView = view.findViewById<TextView>(R.id.textview_first)
            // Convert the text to an Int
            val currentCount = showCountTextView.text.toString().toInt()
            // Create an action that sends currentCount as an argument
            val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment(currentCount)
            // Find and use the nav controller to navigate using the action
            findNavController().navigate(action)
        }
        binding.toastButton.setOnClickListener {
            // create a Toast with some text and display it for a short time
            val myToast = Toast.makeText(context, getString(R.string.hello_toast_text), Toast.LENGTH_SHORT)
            //show the Toast
            myToast.show()
        }
        binding.countButton.setOnClickListener {
            countMe(view)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun countMe(view: View) {
        // get the text view
        val showCountTextView = view.findViewById<TextView>(R.id.textview_first)

        // Get the current value of the text view
        val countString = showCountTextView.text.toString()

        // Convert the string to a number and increment it
        var count = countString.toInt()
        count++

        // Output new value to console
        println("Count is now $count")

        // Use LogCat
        Log.d("CountUpdated", " $count")

        // Display the new value
        showCountTextView.text = count.toString()
    }
}