package com.example.bubbledicer4

class Dice {
    //instance variables
    var num1 = 0
    var d = ""
    var num2 = 0


    //constructor
    constructor() {
        //default constructor that defaults to 1d20 when you make a dice object
        num1 = 1
        var d = "d"
        num2 = 20
    }

    //constructor that lets you pass in the values you want
    constructor(first:Int, sd:String, secondNum:Int) {
        num1 = first
        d = sd
        num2 = secondNum
    }


    fun getNotation():String {
        //pass in the dice that you want to be turned into a string so that you can put is
        //as txt values for your buttons or whatever
        var s = ""
        s = if (num1 > 1) {
            "" + num1 + "d" + num2
        } else {
            "d$num2" //no front number
        }
        return s
    }

    fun getNotationF():String {
        var s = ""
        s = if (num1 > 1) {
            "" + num1 + "d" + "F"
        } else {
            "dF" //no front number
        }
        return s

    }
}
//run .getNotation every time after change values