package com.garmin.garminkaptain

import java.text.DateFormat

inline val <reified T> T.TAG: String
    get() = T::class.java.simpleName

fun Long.formatDate(): String = DateFormat.getDateInstance().format(this * 1000L)