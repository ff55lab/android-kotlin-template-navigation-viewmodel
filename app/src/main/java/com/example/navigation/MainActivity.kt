package com.example.navigation

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.navigation.databinding.ActivityMainBinding
import com.example.navigation.viewmodel.ActivityVM

class MainActivity : AppCompatActivity() {

    private lateinit var _binding: ActivityMainBinding
    internal val binding get() = _binding

    private lateinit var _navController: NavController

    //region shared view model
    // accessible by fragments within this activity
    private val _activityViewModel: ActivityVM by viewModels()
    val activityVM get() = _activityViewModel
    //endregion

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        val view = _binding.root
        setContentView(view)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        _navController = navHostFragment.navController

        // https://stackoverflow.com/questions/68777836/android-clear-backstack-after-reselecting-bottom-navigation-tab/68779398#68779398
        _binding.bottomNavigationView.apply {
            _navController.let { navController ->
                NavigationUI.setupWithNavController(
                    this,
                    navController
                )
//                setOnItemSelectedListener { item ->
//                    NavigationUI.onNavDestinationSelected(item, navController)
//                    true
//                }
//                setOnItemReselectedListener {
//                    navController.popBackStack(destinationId = it.itemId, inclusive = false)
//                }
            }
        }

        //region shared view model
        _activityViewModel.value = "main activity"
        //endregion
    }

    override fun onSupportNavigateUp(): Boolean {
        return _navController.navigateUp() || super.onSupportNavigateUp()
    }

}