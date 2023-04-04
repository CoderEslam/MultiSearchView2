package com.doubleclick.multisearchview.`interface`

interface MultiSearchViewListener {

    fun onTextChanged(index: Int, s: CharSequence)

    fun onSearchComplete(index: Int, s: CharSequence)

    fun onSearchItemRemoved(index: Int)

    fun onItemSelected(index: Int, s: CharSequence)
}