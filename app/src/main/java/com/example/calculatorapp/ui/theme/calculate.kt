package com.example.calculatorapp.ui.theme

import java.util.Stack


    fun calculate(s: String): Int {
        var num = 0
        var sign = '+'
        var total = 0
        var prev = 0

        for (i in 0 until s.length) {
            val c = s[i]
            if (c.isDigit()) {
                num = num * 10 + (c-'0')
            }

            if (!c.isDigit() && c != ' ' || i == s.length - 1) {
                when (sign) {
                    '+' -> {
                        total += prev
                        prev = num
                    }
                    '-' -> {
                        total += prev
                        prev = -num
                    }
                    '*' -> {
                        prev *= num
                    }
                    '/' -> {
                        if(num!=0)
                        prev /= num
                        else{
                           println("Divisible by zero");
                        }
                    }
                }
                num = 0
                sign = c
            }
        }
        return total + prev
    }
