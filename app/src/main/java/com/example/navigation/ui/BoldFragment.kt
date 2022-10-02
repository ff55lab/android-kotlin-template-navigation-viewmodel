package com.example.navigation.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.navigation.MainActivity
import com.example.navigation.R
import com.example.navigation.databinding.FragmentBoldBinding
import com.example.navigation.viewmodel.ActivityVM
import com.example.navigation.viewmodel.FragmentVM

class BoldFragment : Fragment() {

    private var _binding: FragmentBoldBinding? = null
    private lateinit var _main: MainActivity

    //region shared view model
    // access the activity view model
    private val _activityViewModel: ActivityVM by activityViewModels()
    val activityVM get() = _activityViewModel

    // accessible only within current fragment
    private val _fragmentViewModel: FragmentVM by viewModels()
    val fragmentVM get() = _fragmentViewModel
    //endregion

    override fun onAttach(context: Context) {
        super.onAttach(context)
        _main = requireActivity() as MainActivity
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        val fragmentBinding = FragmentBoldBinding.inflate(inflater, container, false)
        _binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding?.boldFragment = this

        // region Example: View Model
        _fragmentViewModel.value = "bold fragment"
        // endregion
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun showBold1() {
        findNavController().navigate(R.id.action_fragmentBold_to_bold1Fragment)
    }

    fun showBold2() {
        findNavController().navigate(R.id.action_fragmentBold_to_bold2Fragment)
    }

    fun showItalic() {
        _main.binding.bottomNavigationView.selectedItemId = R.id.fragmentItalic
    }

    //region Example: Binding view

    fun showClickMe() {
        // _binding
        // Accesses all binding views with valid android:id

        // _binding?.clickMe
        // Accesses to clickMe Button view

        _binding?.clickMe?.text = getString(R.string.done_binding_me)
    }

    //endregion

    //region Example: View model

    fun showSharedValue() {
        _binding?.sharedValue?.text = _activityViewModel.value
    }

    fun showFragmentValue() {
        _binding?.sharedValue?.text = _fragmentViewModel.value
    }

    fun amendSharedValue() {
        _activityViewModel.value = "amended bold fragment"
        showSharedValue()
    }

    //endregion

}