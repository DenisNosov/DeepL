package dev.denisnosoff.deepl.presentation.view.translate

import android.content.ClipData
import android.widget.ArrayAdapter
import android.widget.Toast
import dev.denisnosoff.deepl.R
import dev.denisnosoff.deepl.data.network.models.translation.TranslationModel
import dev.denisnosoff.deepl.domain.languages.LanguageMapper
import dev.denisnosoff.deepl.ext.*
import dev.denisnosoff.deepl.presentation.base.BaseFragment
import dev.denisnosoff.deepl.presentation.presenter.translate.TranslatePresenter
import dev.denisnosoff.deepl.presentation.presenter.translate.TranslateView
import kotlinx.android.synthetic.main.fragment_translate.*
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import org.koin.android.ext.android.get
import org.koin.android.ext.android.inject

class TranslateFragment : BaseFragment(), TranslateView {

    @InjectPresenter
    lateinit var presenter: TranslatePresenter

    @ProvidePresenter
    fun providePresenter() : TranslatePresenter =
        TranslatePresenter(get(), get())

    private val languageMapper: LanguageMapper by inject()

    private lateinit var inputAdapter: ArrayAdapter<CharSequence>

    override val layoutId: Int
        get() = R.layout.fragment_translate

    override fun initViews() {
        initOutput()
        initLanguages()
        initButton()
    }

    private fun initOutput() {
        etOutput.keyListener = null

        etOutput.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                hideKeyboard()
                presenter.translateClicked(
                    etInput.text.toString(),
                    inputSpinner.selectedItem.toString(),
                    outputSpinner.selectedItem.toString()
                )
            }
        }

        etOutput.setOnLongClickListener {
            if (!etOutput.text.isNullOrEmpty()) {
                if (copyTextToClipboard(
                        getString(R.string.translation_clipboard_label),
                        etOutput.text.toString()
                    )) {
                    Toast.makeText(context, R.string.text_copied_label, Toast.LENGTH_SHORT).show()
                    return@setOnLongClickListener true
                }
            }
            return@setOnLongClickListener false
        }
    }

    private fun initLanguages() {
        initInputLanguages()
        initOutputLanguages()
    }

    private fun initInputLanguages() {
        inputAdapter = inputSpinner.initWithArray(
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
        btnTranslate.setOnClickListener {
            hideKeyboard()
            presenter.translateClicked(
                etInput.text.toString(),
                inputSpinner.selectedItem.toString(),
                outputSpinner.selectedItem.toString()
            )
        }
    }

    override fun showLoading(show: Boolean) {
        if (show) {
            ivArrow.hide()
            progressBar.show()
            btnTranslate.isEnabled = false
        } else {
            ivArrow.show()
            progressBar.hide()
            btnTranslate.isEnabled = true
        }
    }

    override fun showTranslation(translationModel: TranslationModel) {
        etOutput.setText(translationModel.text)

        translationModel.sourceLanguage?.let { language ->
            inputSpinner.setSelection(inputAdapter.getPosition(
                languageMapper.getDisplayedLanguageByResponse(language)
            ))
        }
    }
}