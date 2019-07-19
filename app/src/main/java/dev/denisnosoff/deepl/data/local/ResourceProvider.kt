package dev.denisnosoff.deepl.data.local

import android.content.Context
import androidx.annotation.StringRes

class ResourceProvider(
    private val context: Context
) {

    fun getStringArray(id: Int) : Array<String> =
        context.resources.getStringArray(id)

    fun getString(@StringRes id: Int) : String =
        context.getString(id)
}