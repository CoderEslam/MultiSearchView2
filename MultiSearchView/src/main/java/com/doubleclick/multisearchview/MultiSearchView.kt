package com.doubleclick.multisearchview

import android.content.Context
import android.util.AttributeSet
import android.widget.RelativeLayout
import com.doubleclick.multisearchview.`interface`.MultiSearchViewListener
import com.doubleclick.multisearchview.databinding.ViewMultiSearchBinding
import com.doubleclick.multisearchview.extensions.inflate

class MultiSearchView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) :
    RelativeLayout(context, attrs, defStyleAttr) {


    private val binding = inflate<ViewMultiSearchBinding>(R.layout.view_multi_search)

    init {
        val typedArray = context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.MultiSearchView,
            defStyleAttr,
            defStyleAttr
        )
        val searchTextStyle =
            typedArray.getResourceId(R.styleable.MultiSearchView_searchTextStyle, 0)

        binding.searchViewContainer.apply {
            this.searchTextStyle = searchTextStyle
        }

        binding.imageViewSearch.setOnClickListener {
            if (binding.searchViewContainer.isInSearchMode().not()) {
                binding.searchViewContainer.search()
            } else {
                binding.searchViewContainer.completeSearch()
            }
        }
    }

    fun setSearchViewListener(multiSearchViewListener: MultiSearchViewListener) {
        binding.searchViewContainer.setSearchViewListener(multiSearchViewListener)
    }
}