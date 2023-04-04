package com.doubleclick.multisearchview.extensions

import android.animation.Animator
import android.animation.ValueAnimator
import com.doubleclick.multisearchview.helper.SimpleAnimationListener

fun ValueAnimator.endListener(onAnimationEnd: ()->Unit){
    addListener(object : SimpleAnimationListener(){
        override fun onAnimationEnd(animation: Animator) {
            super.onAnimationEnd(animation)
            onAnimationEnd.invoke()
        }
    })
}