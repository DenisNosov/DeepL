package dev.denisnosoff.deepl.ext

import android.app.Activity
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.view.View
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
) : ArrayAdapter<CharSequence> {
    val adapter = ArrayAdapter.createFromResource(
        context,
        arrayId,
        itemId
    )
    adapter.setDropDownViewResource(dropdownItemId)
    this.adapter = adapter
    return adapter
}

fun View.hide() {
    visibility = View.GONE
}

fun View.show() {
    visibility = View.VISIBLE
}

fun Fragment.copyTextToClipboard(label: String, text: String) : Boolean {
    val clipboard = activity?.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager?
    val clip = ClipData.newPlainText(label, text)
    if (clipboard != null) {
        clipboard.primaryClip = clip
        return true
    }
    return false
}