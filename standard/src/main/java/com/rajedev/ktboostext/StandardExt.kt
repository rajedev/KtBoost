package com.rajedev.ktboostext

/**
 * Copyright (c) 2024 /LiveRamp, All rights reserved.
 * Created by Rajendhiran Easu on 09/11/24.
 * Description: Extension function for the retail or ecommerce logics
 */

fun String.isAlphaNumeric(): Boolean = this.matches("[a-zA-Z0-9]+".toRegex())

fun String.isNumeric(): Boolean = this.matches("\\d+".toRegex())

fun String.isOnlyDigits(): Boolean = this.all { it.isDigit() }

fun String.toIntOrZero(): Int = this.toIntOrNull() ?: 0