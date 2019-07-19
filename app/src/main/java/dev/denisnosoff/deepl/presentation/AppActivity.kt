package dev.denisnosoff.deepl.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat
import com.aurelhubert.ahbottomnavigation.AHBottomNavigation
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem
import dev.denisnosoff.deepl.R
import dev.denisnosoff.deepl.presentation.base.BaseFragment
import dev.denisnosoff.deepl.presentation.view.document.DocumentFragment
import dev.denisnosoff.deepl.presentation.view.translate.TranslateFragment
import kotlinx.android.synthetic.main.activity_main.*

class AppActivity : AppCompatActivity() {

    private val currentFragment: BaseFragment?
        get() = supportFragmentManager.fragments.firstOrNull { !it.isHidden } as BaseFragment?

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupBottomBar()
    }

    private fun setupBottomBar() {

        val itemTranslate = AHBottomNavigationItem(getString(R.string.translate), R.drawable.ic_translate)
        val itemDocument = AHBottomNavigationItem(getString(R.string.upload_document), R.drawable.ic_document)


        bottomNavigation.addItems(listOf(itemTranslate, itemDocument))

        bottomNavigation.titleState = AHBottomNavigation.TitleState.ALWAYS_SHOW
        bottomNavigation.accentColor = ContextCompat.getColor(this, R.color.colorAccent)
        bottomNavigation.defaultBackgroundColor = ContextCompat.getColor(this, R.color.colorPrimaryDark)

        bottomNavigation.setOnTabSelectedListener { position, wasSelected ->
            if (!wasSelected) selectTab(
                when (position) {
                    0 -> translate
                    1 -> document
                    else -> translate
                }
            )
            true
        }

        selectTab(translate)
    }

    private fun selectTab(tag: String) {
        val currentFragment = currentFragment
        val newFragment = supportFragmentManager.findFragmentByTag(tag)

        if (currentFragment != null && newFragment != null && currentFragment == newFragment) return

        supportFragmentManager.beginTransaction().apply {
            if (newFragment == null) add(R.id.container, createTabFragment(tag), tag)

            currentFragment?.let { hide(it) }
            newFragment?.let { show(it) }

        }.commitNow()
    }

    private fun createTabFragment(tag: String) : BaseFragment {
        return when (tag) {
            translate -> TranslateFragment()
            document -> DocumentFragment()
            else -> TranslateFragment()
        }
    }

    companion object {
        private var translate = "translate"
        private var document = "document"
    }
}
