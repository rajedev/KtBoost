package com.rajedev.ktboostext

/**
 * Copyright (c) 2024 /LiveRamp, All rights reserved.
 * Created by Rajendhiran Easu on 10/11/24.
 * Description: Extension function for the boolean manipulation
 */

infix fun Boolean.andNot(other: Boolean): Boolean = this && !other
infix fun Boolean.orNot(other: Boolean): Boolean = this || !other

fun Boolean.toggle(): Boolean = !this

fun Boolean?.isTrue(): Boolean = this != null && this == true
fun Boolean?.isFalse(): Boolean = this != null && this == false

fun Boolean?.isNullOrTrue(): Boolean = this == null || this == true
fun Boolean?.isNullOrFalse(): Boolean = this == null || this == false

fun Boolean.toYesNo(): String = if (this) "Yes" else "No"
fun Boolean.asString(): String = if (this) "True" else "False"
fun Boolean.toInt(): Int = if (this) 1 else 0

inline fun Boolean.ifTrue(action: () -> Unit) {
    if (this) action()
}

inline fun Boolean.ifFalse(action: () -> Unit) {
    if (!this) action()
}

inline fun Boolean.ifTrueOrElse(ifTrue: () -> Unit, ifFalse: () -> Unit) {
    if (this) ifTrue() else ifFalse()
}

