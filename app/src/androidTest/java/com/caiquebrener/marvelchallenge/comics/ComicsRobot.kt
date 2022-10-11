package com.caiquebrener.marvelchallenge.comics

import com.caiquebrener.marvelchallenge.robot.Robot

fun getComics(func: ComicsRobot.() -> Unit) = ComicsRobot().apply(func)
class ComicsRobot : Robot() {

    fun textViewIsVisible(view:Int){
        isDisplayed(view)
    }
}