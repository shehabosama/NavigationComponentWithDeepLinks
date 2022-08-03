package com.example.bindingandnavigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.*
import com.example.bindingandnavigation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var navController:NavController
    private lateinit var binding:ActivityMainBinding
    lateinit var appBarConfiguration: AppBarConfiguration
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment

        navController = navHostFragment.findNavController()

        /**
         * app configuration bar used for deal the same level fragment as the same
         * in our case we passed the home fragment and search fragment because two of them are in the same leve
         * and we don't want to appear the navigate up or back button when we navigate from home fragment to search fragment or vise versa
         * */
        appBarConfiguration = AppBarConfiguration(
            setOf(R.id.homeFragment , R.id.searchFragment),
            binding.drawerLayout
        )

        /**
         * this listener disappear the navigation button when we come over the setting fragment and termsAndCondition fragment
         * */
        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            when(destination.id){
                R.id.settingsFragment,R.id.termsAndConditionsFragment ->
                    binding.navBottom.visibility = View.GONE
                else ->  binding.navBottom.visibility = View.VISIBLE
            }
        }

        // for associate custom tool bar with the built in menu
        setSupportActionBar(binding.toolbar)
        /**
         * this is function tells the activity that every fragment we will navigate to, the tool bar will hold it name
         * and also start to appear the back button or navigate up button when needed
         * */
        setupActionBarWithNavController(navController , appBarConfiguration)

        //setup the nav with navigation buttom
        binding.navBottom.setupWithNavController(navController)
        //setup the nav with navigation drawer
        binding.navView.setupWithNavController(navController)
    }


    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration)||super.onSupportNavigateUp()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
       menuInflater.inflate(R.menu.optoins_menu , menu)
       return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return  when(item.itemId){
            R.id.termsAndConditions -> {
                navController.navigate(NavGraphDirections.actionGlobalTermsAndConditionsFragment())
                true
            }
            else -> item.onNavDestinationSelected(navController)||super.onOptionsItemSelected(item)

        }

    }
}