package dev.denisnosoff.deepl.presentation.view.translate

import dev.denisnosoff.deepl.R
import dev.denisnosoff.deepl.ext.hideKeyboard
import dev.denisnosoff.deepl.ext.initWithArray
import dev.denisnosoff.deepl.presentation.base.BaseFragment
import dev.denisnosoff.deepl.presentation.presenter.translate.TranslateView
import kotlinx.android.synthetic.main.fragment_translate.*

class TranslateFragment : BaseFragment(), TranslateView {

    override val layoutId: Int
        get() = R.layout.fragment_translate

    override fun initViews() {
        initOutput()
        initLanguages()
        initButton()
    }

    private fun initOutput() {
        etOutput.keyListener = null
        etOutput.setOnFocusChangeListener { v, hasFocus ->
            if (hasFocus) hideKeyboard()
        }
    }

    private fun initLanguages() {
        initInputLanguages()
        initOutputLanguages()
    }

    private fun initInputLanguages() {
        inputSpinner.initWithArray(
            context,
            R.array.input_languages,
            R.layout.spinner_language_item,
            R.layout.spinner_language_dropdown_item
        )
    }

    private fun initOutputLanguages() {
        outputSpinner.initWithArray(
            context,
            R.array.output_languages,
            R.layout.spinner_language_item,
            R.layout.spinner_language_dropdown_item
        )
    }

    private fun initButton() {

    }
}