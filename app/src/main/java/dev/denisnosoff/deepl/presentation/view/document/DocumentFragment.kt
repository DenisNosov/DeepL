package dev.denisnosoff.deepl.presentation.view.document

import dev.denisnosoff.deepl.R
import dev.denisnosoff.deepl.presentation.base.BaseFragment
import dev.denisnosoff.deepl.presentation.presenter.document.DocumentView

class DocumentFragment : BaseFragment(), DocumentView {

    override val layoutId: Int
        get() = R.layout.fragment_document

    override fun initViews() {

    }
}