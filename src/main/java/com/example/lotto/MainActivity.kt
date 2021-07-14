package com.example.lotto

import android.animation.Animator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val countDownTimer = object : CountDownTimer(3000, 100) {
            override fun onTick(p0: Long) {
                val lotteryList = arrayListOf(number1, number2, number3, number4, number5, number6)
                val numberArray = IntArray(6)
                lotteryList.forEachIndexed {index, textView ->
                    while (true) {
                        val randomNumber = (Math.random() * 45 + 1).toInt()
                        if (!numberArray.contains(randomNumber)) {
                            numberArray[index] = randomNumber
                            break;
                        }
                    }
                    textView.text = "${numberArray[index]}"
                }
            }

            override fun onFinish() {
            }
        }

        lotteryWhirl.setOnClickListener {
            if (lotteryWhirl.isAnimating) {
                lotteryWhirl.cancelAnimation()
                countDownTimer.cancel()
            } else {
                lotteryWhirl.playAnimation()
                countDownTimer.start()
            }
        }
    }
}