package com.example.navigation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.example.navigation.R
import com.example.navigation.viewmodel.ActivityVM
import com.example.navigation.viewmodel.FragmentVM

class ParkingFragment : Fragment() {

    //region shared view model
    // access the activity view model
    private val _activityViewModel: ActivityVM by activityViewModels()
    val activityVM get() = _activityViewModel

    // accessible only within current fragment
    private val _fragmentViewModel: FragmentVM by viewModels()
    val fragmentVM get() = _fragmentViewModel
    //endregion

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_parking, container, false)
    }

}