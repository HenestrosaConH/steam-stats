package com.josecarloslh.steamstats

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.josecarloslh.steamstats.databinding.ActivityMainBinding
import com.josecarloslh.steamstats.deals.DealsFragment
import com.josecarloslh.steamstats.mostowned.MostOwnedFragment
import com.josecarloslh.steamstats.toprated.TopRatedFragment

class MainActivity : AppCompatActivity() {

    private val fragments: HashMap<Int, Fragment> = hashMapOf(
        Pair(R.id.action_deals, DealsFragment()),
        Pair(R.id.action_top_rated, TopRatedFragment()),
        Pair(R.id.action_most_owned, MostOwnedFragment())
    )
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()

        with(binding.bnvMain) {
            selectedItemId = DEFAULT_ITEM
            setOnItemSelectedListener { item ->
                val fragment: Fragment? = fragments[item.itemId]
                if (fragment != null)
                    replaceFragment(fragment)
                true
            }
        }
    }

    private fun initView() {
        val currentFragment =
            supportFragmentManager.findFragmentById(R.id.flMain)

        if (currentFragment == null) {
            fragments[DEFAULT_ITEM]?.let {
                supportFragmentManager
                    .beginTransaction()
                    .add(R.id.flMain, it)
            }
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.flMain, fragment)
            .commit()
    }

    companion object {
        const val DEFAULT_ITEM = R.id.action_deals
    }
}