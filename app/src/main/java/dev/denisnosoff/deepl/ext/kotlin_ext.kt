package dev.denisnosoff.deepl.ext

import android.app.Activity
import android.content.Context
import android.view.inputmethod.InputMethodManager
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.fragment.app.Fragment

fun Fragment.hideKeyboard() {
    val imm = activity!!.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(view!!.windowToken, 0)
}

fun Spinner.initWithArray(
    context: Context?,
    arrayId: Int,
    itemId: Int = android.R.layout.simple_spinner_item,
    dropdownItemId: Int = android.R.layout.simple_spinner_dropdown_item
) {
    val adapter = ArrayAdapter.createFromResource(
        context,
        arrayId,
        itemId
    )
    adapter.setDropDownViewResource(dropdownItemId)
    this.adapter = adapter
}