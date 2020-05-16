package com.example.bubbledicer4

import android.app.*
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.graphics.drawable.Icon
import android.os.Bundle
import android.view.Gravity
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.widget.AlertDialogLayout
import androidx.appcompat.widget.DialogTitle
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import dev.diceroll.parser.ResultTree
import dev.diceroll.parser.detailedRoll
import dev.diceroll.parser.roll
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(bottomAppBar)


        val diceRegex = Regex("/^(?:(\\d*)\\#)?(\\d*)d(\\d+)([*+-]?)(\\d*)\$/i")
        var defaultTextState = ""


        var d12State =  false
        var d20State =  false
        var d100State = false
        var d6State =   false
        var d8State =   false
        var d10State =  false
        var d2State =   false
        var d3State =   false
        var d4State =   false
        var dFState =   false
        var dnState =   false

        val diced12 =  Dice()
        val diced20 =  Dice()
        val diced100 =  Dice()
        val diced6 =  Dice()
        val diced8 =  Dice()
        val diced10 =  Dice()
        val diced2 =  Dice()
        val diced3 =  Dice()
        val diced4 =  Dice()
        val dicedF = Dice()
        val dicedn = Dice()
        val dice12 = Dice()

        fun massDisable(){
            button1.isEnabled = false
            button2.isEnabled = false
            button3.isEnabled = false
            button5.isEnabled = false
            button6.isEnabled = false
            button7.isEnabled = false
            button9.isEnabled = false
            button10.isEnabled = false
            button11.isEnabled = false
            button14.isEnabled = false
        }

        fun massEnable(){
            button1.isEnabled = true
            button2.isEnabled = true
            button3.isEnabled = true
            button5.isEnabled = true
            button6.isEnabled = true
            button7.isEnabled = true
            button9.isEnabled = true
            button10.isEnabled = true
            button11.isEnabled = true
            button13.isEnabled = true
            button14.isEnabled = true
        }

        fun disableDF(){
            button13.isEnabled = false
        }

        var count = 0

        fun stateReset(){
            d12State =  false
            d20State =  false
            d100State = false
            d6State =   false
            d8State =   false
            d10State =  false
            d2State =   false
            d3State =   false
            d4State =   false
            dFState =   false
            dnState =   false
        }

        //d12 button
        button1.setOnClickListener(){

            disableDF()

            if(!d12State && textScreen.text == "" ){
                textScreen.text = textScreen.text
                stateReset()
                d12State = true

                diced12.num2 = 12
                count++
                diced12.num1 = count
                textScreen.text = diced12.getNotation()}
            else if (!d12State && textScreen.text.last().toString() == "+"
                ||textScreen.text.last().toString() == "-"
                ||textScreen.text.last().toString() == "*"
                ||textScreen.text.last().toString() == "/"){

                count = 0
                stateReset()
                d12State = true

                diced12.num2 = 12
                count++
                diced12.num1 = count
                textScreen.text = textScreen.text.toString().plus(diced12.getNotation())}
            else if (!d12State){
                textScreen.text = textScreen.text.toString().plus("+")
                count = 0
                stateReset()
                d12State = true

                diced12.num2 = 12
                count++
                diced12.num1 = count
                textScreen.text = textScreen.text.toString().plus(diced12.getNotation())}
            else if (d12State){

                count++
                println(count)

                if(count == 1){
                    textScreen.text.removeSuffix("d12")
                } else if(count >= 2){
                    textScreen.text = textScreen.text.removeSuffix(diced12.getNotation())
                }
                diced12.num1 = count
                diced12.num2 = 12

                textScreen.text = textScreen.text.toString().plus(diced12.getNotation())
            }
        }

        //d20 button
        button2.setOnClickListener(){

            disableDF()

            if(!d20State && textScreen.text == "" ){
                textScreen.text = textScreen.text
                stateReset()
                d20State = true

                diced20.num2 = 20
                count++
                diced20.num1 = count
                textScreen.text = diced20.getNotation()}
            else if (!d20State && textScreen.text.last().toString() == "+"
                ||textScreen.text.last().toString() == "-"
                ||textScreen.text.last().toString() == "*"
                ||textScreen.text.last().toString() == "/"){

                count = 0
                stateReset()
                d20State = true

                diced20.num2 = 20
                count++
                diced20.num1 = count
                textScreen.text = textScreen.text.toString().plus(diced20.getNotation())}
            else if (!d20State){
                textScreen.text = textScreen.text.toString().plus("+")
                count = 0
                stateReset()
                d20State = true

                diced20.num2 = 20
                count++
                diced20.num1 = count
                textScreen.text = textScreen.text.toString().plus(diced20.getNotation())}
            else if (d20State){

                count++
                println(count)

                if(count == 1){
                    textScreen.text.removeSuffix("d${20}")
                } else if(count >= 2){
                    textScreen.text = textScreen.text.removeSuffix(diced20.getNotation())
                }
                diced20.num1 = count
                diced20.num2 = 20

                textScreen.text = textScreen.text.toString().plus(diced20.getNotation())
            }
        }

        //d100 button
        button3.setOnClickListener() {

            disableDF()

                if(!d100State && textScreen.text == "" ){
                    textScreen.text = textScreen.text
                    stateReset()
                    d100State = true

                    diced100.num2 = 100
                    count++
                    diced100.num1 = count
                    textScreen.text = diced100.getNotation()}
                else if (!d100State && textScreen.text.last().toString() == "+"
                    ||textScreen.text.last().toString() == "-"
                    ||textScreen.text.last().toString() == "*"
                    ||textScreen.text.last().toString() == "/"){

                    count = 0
                    stateReset()
                    d100State = true

                    diced100.num2 = 100
                    count++
                    diced100.num1 = count
                    textScreen.text = textScreen.text.toString().plus(diced100.getNotation())}
                else if (!d100State){
                    textScreen.text = textScreen.text.toString().plus("+")
                    count = 0
                    stateReset()
                    d100State = true

                    diced100.num2 = 100
                    count++
                    diced100.num1 = count
                    textScreen.text = textScreen.text.toString().plus(diced100.getNotation())}
                else if (d100State){

                    count++
                    println(count)

                    if(count == 1){
                        textScreen.text.removeSuffix("d${100}")
                    } else if(count >= 2){
                        textScreen.text = textScreen.text.removeSuffix(diced100.getNotation())
                    }
                    diced100.num1 = count
                    diced100.num2 = 100

                    textScreen.text = textScreen.text.toString().plus(diced100.getNotation())
                }
            }

        //d6 button
        button5.setOnClickListener(){
            disableDF()
                if(!d6State && textScreen.text == "" ){
                    textScreen.text = textScreen.text
                    stateReset()
                    d6State = true

                    diced6.num2 = 6
                    count++
                    diced6.num1 = count
                    textScreen.text = diced6.getNotation()}
                else if (!d6State && textScreen.text.last().toString() == "+"
                    ||textScreen.text.last().toString() == "-"
                    ||textScreen.text.last().toString() == "*"
                    ||textScreen.text.last().toString() == "/"){

                    count = 0
                    stateReset()
                    d6State = true

                    diced6.num2 = 6
                    count++
                    diced6.num1 = count
                    textScreen.text = textScreen.text.toString().plus(diced6.getNotation())}
                else if (!d6State){
                    textScreen.text = textScreen.text.toString().plus("+")
                    count = 0
                    stateReset()
                    d6State = true

                    diced6.num2 = 6
                    count++
                    diced6.num1 = count
                    textScreen.text = textScreen.text.toString().plus(diced6.getNotation())}
                else if (d6State){

                    count++
                    println(count)

                    if(count == 1){
                        textScreen.text.removeSuffix("d${6}")
                    } else if(count >= 2){
                        textScreen.text = textScreen.text.removeSuffix(diced6.getNotation())
                    }
                    diced6.num1 = count
                    diced6.num2 = 6

                    textScreen.text = textScreen.text.toString().plus(diced6.getNotation())
                }
            }

        //d8 button
        button6.setOnClickListener(){

            disableDF()
            if(!d8State && textScreen.text == "" ){
                textScreen.text = textScreen.text
                stateReset()
                d8State = true

                diced8.num2 = 8
                count++
                diced8.num1 = count
                textScreen.text = diced8.getNotation()}
            else if (!d8State && textScreen.text.last().toString() == "+"
                ||textScreen.text.last().toString() == "-"
                ||textScreen.text.last().toString() == "*"
                ||textScreen.text.last().toString() == "/"){

                count = 0
                stateReset()
                d8State = true

                diced8.num2 = 8
                count++
                diced8.num1 = count
                textScreen.text = textScreen.text.toString().plus(diced8.getNotation())}
            else if (!d8State){
                textScreen.text = textScreen.text.toString().plus("+")
                count = 0
                stateReset()
                d8State = true

                diced8.num2 = 8
                count++
                diced8.num1 = count
                textScreen.text = textScreen.text.toString().plus(diced8.getNotation())}
            else if (d8State){

                count++
                println(count)

                if(count == 1){
                    textScreen.text.removeSuffix("d${8}")
                } else if(count >= 2){
                    textScreen.text = textScreen.text.removeSuffix(diced8.getNotation())
                }
                diced8.num1 = count
                diced8.num2 = 8

                textScreen.text = textScreen.text.toString().plus(diced8.getNotation())
            }
        }

        //d10 button
        button7.setOnClickListener(){

            disableDF()
            if(!d10State && textScreen.text == "" ){
                textScreen.text = textScreen.text
                stateReset()
                d10State = true

                diced10.num2 = 10
                count++
                diced10.num1 = count
                textScreen.text = diced10.getNotation()}
            else if (!d10State && textScreen.text.last().toString() == "+"
                ||textScreen.text.last().toString() == "-"
                ||textScreen.text.last().toString() == "*"
                ||textScreen.text.last().toString() == "/"){

                count = 0
                stateReset()
                d10State = true

                diced10.num2 = 10
                count++
                diced10.num1 = count
                textScreen.text = textScreen.text.toString().plus(diced10.getNotation())}
            else if (!d10State){
                textScreen.text = textScreen.text.toString().plus("+")
                count = 0
                stateReset()
                d10State = true

                diced10.num2 = 10
                count++
                diced10.num1 = count
                textScreen.text = textScreen.text.toString().plus(diced10.getNotation())}
            else if (d10State){

                count++
                println(count)

                if(count == 1){
                    textScreen.text.removeSuffix("d${10}")
                } else if(count >= 2){
                    textScreen.text = textScreen.text.removeSuffix(diced10.getNotation())
                }
                diced10.num1 = count
                diced10.num2 = 10

                textScreen.text = textScreen.text.toString().plus(diced10.getNotation())
            }
        }

        //d2 button
        button9.setOnClickListener(){

            disableDF()
            if(!d2State && textScreen.text == "" ){
                textScreen.text = textScreen.text
                stateReset()
                d2State = true

                diced2.num2 = 2
                count++
                diced2.num1 = count
                textScreen.text = diced2.getNotation()}
            else if (!d2State && textScreen.text.last().toString() == "+"
                ||textScreen.text.last().toString() == "-"
                ||textScreen.text.last().toString() == "*"
                ||textScreen.text.last().toString() == "/"){

                count = 0
                stateReset()
                d2State = true

                diced2.num2 = 2
                count++
                diced2.num1 = count
                textScreen.text = textScreen.text.toString().plus(diced2.getNotation())}
            else if (!d2State){
                textScreen.text = textScreen.text.toString().plus("+")
                count = 0
                stateReset()
                d2State = true

                diced2.num2 = 2
                count++
                diced2.num1 = count
                textScreen.text = textScreen.text.toString().plus(diced2.getNotation())}
            else if (d2State){

                count++
                println(count)

                if(count == 1){
                    textScreen.text.removeSuffix("d${2}")
                } else if(count >= 2){
                    textScreen.text = textScreen.text.removeSuffix(diced2.getNotation())
                }
                diced2.num1 = count
                diced2.num2 = 2

                textScreen.text = textScreen.text.toString().plus(diced2.getNotation())
            }
        }

        //d3 button
        button10.setOnClickListener(){

            disableDF()
            if(!d3State && textScreen.text == "" ){
                textScreen.text = textScreen.text
                stateReset()
                d3State = true

                diced3.num2 = 3
                count++
                diced3.num1 = count
                textScreen.text = diced3.getNotation()}
            else if (!d3State && textScreen.text.last().toString() == "+"
                ||textScreen.text.last().toString() == "-"
                ||textScreen.text.last().toString() == "*"
                ||textScreen.text.last().toString() == "/"){

                count = 0
                stateReset()
                d3State = true

                diced3.num2 = 3
                count++
                diced3.num1 = count
                textScreen.text = textScreen.text.toString().plus(diced3.getNotation())}
            else if (!d3State){
                textScreen.text = textScreen.text.toString().plus("+")
                count = 0
                stateReset()
                d3State = true

                diced3.num2 = 3
                count++
                diced3.num1 = count
                textScreen.text = textScreen.text.toString().plus(diced3.getNotation())}
            else if (d3State){

                count++
                println(count)

                if(count == 1){
                    textScreen.text.removeSuffix("d${3}")
                } else if(count >= 2){
                    textScreen.text = textScreen.text.removeSuffix(diced3.getNotation())
                }
                diced3.num1 = count
                diced3.num2 = 3

                textScreen.text = textScreen.text.toString().plus(diced3.getNotation())
            }
        }

        //d4 button
        button11.setOnClickListener(){

            disableDF()
            if(!d4State && textScreen.text == "" ){
                textScreen.text = textScreen.text
                stateReset()
                d4State = true

                diced4.num2 = 4
                count++
                diced4.num1 = count
                textScreen.text = diced4.getNotation()}
            else if (!d4State && textScreen.text.last().toString() == "+"
                ||textScreen.text.last().toString() == "-"
                ||textScreen.text.last().toString() == "*"
                ||textScreen.text.last().toString() == "/"){

                count = 0
                stateReset()
                d4State = true

                diced4.num2 = 4
                count++
                diced4.num1 = count
                textScreen.text = textScreen.text.toString().plus(diced4.getNotation())}
            else if (!d4State){
                textScreen.text = textScreen.text.toString().plus("+")
                count = 0
                stateReset()
                d4State = true

                diced4.num2 = 4
                count++
                diced4.num1 = count
                textScreen.text = textScreen.text.toString().plus(diced4.getNotation())}
            else if (d4State){

                count++
                println(count)

                if(count == 1){
                    textScreen.text.removeSuffix("d${4}")
                } else if(count >= 2){
                    textScreen.text = textScreen.text.removeSuffix(diced4.getNotation())
                }
                diced4.num1 = count
                diced4.num2 = 4

                textScreen.text = textScreen.text.toString().plus(diced4.getNotation())
            }
        }

        // dF button
        button13.setOnClickListener(){
            if(!dFState && textScreen.text == "" ){
                massDisable()
                textScreen.text = textScreen.text
                stateReset()
                dFState = true

                dicedF.num2 = 6
                count++
                dicedF.num1 = count
                textScreen.text = dicedF.getNotationF()}
            else if (!dFState && textScreen.text.last().toString() == "+"
                ||textScreen.text.last().toString() == "-"
                ||textScreen.text.last().toString() == "*"
                ||textScreen.text.last().toString() == "/"){

                massDisable()
                count = 0
                stateReset()
                dFState = true

                dicedF.num2 = 6
                count++
                dicedF.num1 = count
                textScreen.text = textScreen.text.toString().plus(dicedF.getNotationF())}
            else if (!dFState){
                massDisable()
                textScreen.text = textScreen.text.toString().plus("+")
                count = 0
                stateReset()
                dFState = true

                dicedF.num2 = 6
                count++
                dicedF.num1 = count
                textScreen.text = textScreen.text.toString().plus(dicedF.getNotationF())}
            else if (dFState){
                massDisable()

                count++
                println(count)

                if(count == 1){
                    textScreen.text.removeSuffix("d${6}")
                } else if(count >= 2){
                    textScreen.text = textScreen.text.removeSuffix(dicedF.getNotationF())
                }
                dicedF.num1 = count
                dicedF.num2 = 6

                textScreen.text = textScreen.text.toString().plus(dicedF.getNotationF())
            }

        }

        // back/clear button
        button4.setOnClickListener(){
            stateReset()
            massEnable()
            count = 0
            textScreen.text = ""

        }

        // add button
        button8.setOnClickListener(){
            textScreen.text = textScreen.text.toString().plus("+")
            count = 0
            massEnable()
        }

        // subtract button
        button12.setOnClickListener(){
            textScreen.text = textScreen.text.toString().plus("-")
            count = 0
            massEnable()

        }

        // multiply button
        button16.setOnClickListener(){
            textScreen.text = textScreen.text.toString().plus("*")
            count = 0
            massEnable()

        }

        // divide button
        button17.setOnClickListener(){
            textScreen.text = textScreen.text.toString().plus("/")
            count = 0
            massEnable()

        }

        // roll fab
        floatingActionButton.setOnClickListener{
            if (textScreen.text.isNotEmpty() && !textScreen.text.endsWith("+") && !textScreen.text.endsWith("-") && !textScreen.text.endsWith("*") && !textScreen.text.endsWith("/")) {

                val result = roll(textScreen.text.toString())
                val longResult: ResultTree = detailedRoll(textScreen.text.toString())

                longResult.results[0]
                println("Roll : $result")
                println("Long Roll : ${longResult.value}")

                val rollAlert = MaterialAlertDialogBuilder(this)
                    //.setTitle(longResult.value.toString())
                    .setMessage("                       Roll Result: ${longResult.value.toString()}")
                    // Specifying a listener allows you to take an action before dismissing the dialog.
                    // The dialog is automatically dismissed when a dialog button is clicked.


                rollAlert.show()
            }
        }

        // bubble




//                fun diceButton(state: Boolean, sides: Int, die: Dice){
//            if(!state && textScreen.text == "" ){
//                textScreen.text = textScreen.text
//                stateReset()
//                state = true
//
//                die.num2 = sides
//                count++
//                die.num1 = count
//                textScreen.text = die.getNotation()}
//            else if (!state && textScreen.text.last().toString() == "+"
//                ||textScreen.text.last().toString() == "-"
//                ||textScreen.text.last().toString() == "*"
//                ||textScreen.text.last().toString() == "/"){
//
//                count = 0
//                stateReset()
//                state = true
//
//                die.num2 = sides
//                count++
//                die.num1 = count
//                textScreen.text = textScreen.text.toString().plus(die.getNotation())}
//            else if (!state){
//                textScreen.text = textScreen.text.toString().plus("+")
//                count = 0
//                stateReset()
//                state = true
//
//                die.num2 = sides
//                count++
//                die.num1 = count
//                textScreen.text = textScreen.text.toString().plus(die.getNotation())}
//            else if (state){
//
//                count++
//                println(count)
//
//                if(count == 1){
//                    textScreen.text.removeSuffix("d${sides}")
//                } else if(count >= 2){
//                    textScreen.text = textScreen.text.removeSuffix(die.getNotation())
//                }
//                die.num1 = count
//                die.num2 = sides
//
//                textScreen.text = textScreen.text.toString().plus(die.getNotation())
//            }
//        }

        //        var diceNotationStringBuilder = StringBuilder()
//        var diceNotation = ""
//        textScreen.text = diceNotation

//        fun diceButtonCheck(input: String){
//            var textNumber = input.length + 1
//            var negativeTextNumber: Int = textNumber.unaryMinus()
//            var negativeDiceNumber = textScreen.text.elementAt(negativeTextNumber).toString().toIntOrNull()
//
//            textScreen.text.substring(textScreen.text.length-1)
//
//
//            if(textScreen.text.endsWith(input) && negativeDiceNumber != null){
//                val numberToReplace = textScreen.text.elementAt(negativeTextNumber).toInt()
//                var numberPlusOne = numberToReplace + 1
//
//                textScreen.text.replaceRange(negativeTextNumber + 1, negativeTextNumber-1,numberPlusOne.toString())
//            }else{
//                textScreen.text.replaceRange(negativeTextNumber,negativeTextNumber,"2")
//            }
//        }
    }

    // bottom app bar
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.bottomappbar_bubble, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val NOTIFICATION_CHANNEL_ID = "com.example.bubbledice"

        val target = Intent(this, BubbleActivity::class.java)
        val bubbleIntent = PendingIntent.getActivity(this, 0, target, PendingIntent.FLAG_UPDATE_CURRENT)
        val notificationManager = this.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val importance = NotificationManager.IMPORTANCE_HIGH
        val notificationChannel = NotificationChannel(NOTIFICATION_CHANNEL_ID, "Reminder Alarms", importance)
        notificationManager.createNotificationChannel(notificationChannel)

        val bubbleMetadata = Notification.BubbleMetadata.Builder()
            .setDesiredHeight(1000)
            .setIcon(Icon.createWithResource(this, R.drawable.ic_d20vector))
            .setIntent(bubbleIntent)
            .setSuppressNotification(true)
            .build()

        val notificationBuilder = Notification.Builder(this, NOTIFICATION_CHANNEL_ID)
            .setContentIntent(bubbleIntent)
            .setContentTitle("Bubble Dice")
            .setSmallIcon(R.drawable.ic_d20vector)
            .setBubbleMetadata(bubbleMetadata)



        //val id = Random.nextInt(9999 - 1000) + 1000
        //notificationManager.notify(id, notificationBuilder.build())


        when (item!!.itemId) {
            R.id.app_bar_fav -> notificationManager.notify(1, notificationBuilder.build())

        }
        return true
    }

    // This is an extension method for easy Toast call
    fun Context.toast(message: CharSequence) {
        val toast = Toast.makeText(this, message, Toast.LENGTH_SHORT)
        toast.setGravity(Gravity.BOTTOM, 0, 325)
        toast.show()
    }

}

