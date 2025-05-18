#!/usr/bin/env kotlin

fun timeConversion(s: String): String {
    var hour = s.substring(0, 2).toInt()
    var minute = s.substring(3, 5).toInt()
    var second = s.substring(6, 8).toInt()

    val period = s.substring(8, 10)

    val isPM = period == "PM"

     val isAM = period == "AM"

    if (hour == 12 && isAM) {
        hour = 0
    }

    if (hour == 12 && isPM) {
        hour = 0
    }

    if (isPM) {
        hour = 12 + hour
    }

    lateinit var hourString: String
    lateinit var minuteString: String
    var secondString: String

    if (hour < 9) {
        val tempHour = hour.toString()
        hourString = "0$tempHour"
    } else {
        hourString = "$hour"
    }

    if (minute < 9) {
        val tempMinute = minute.toString()
        minuteString = "0$tempMinute"
    } else {
        minuteString = "$minute"
    }

    if (second < 9) {
        val tempSecond = second.toString()
        secondString = "0$tempSecond"
    } else {
        secondString = "$second"
    }

    return "$hourString:$minuteString:$secondString"
}

fun main() {
    val inputs = listOf(
        "07:05:45PM",
        "02:05:06AM",
        "12:00:00AM",
        "12:00:00PM",
        "12:05:10PM",
        "12:10:00AM",
        "12:45:54PM"
    )

    inputs.forEach {
        val result = timeConversion(it)

        println(result)
    }
}

main()
