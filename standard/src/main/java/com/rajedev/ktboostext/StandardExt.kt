package com.rajedev.ktboostext

/**
 * Created by Rajendhiran Easu on 09/11/24.
 * Description: Extension function for the retail or ecommerce logics
 */

/**
 * Extension function to check if a string is alphanumeric.
 *
 * @return True if the string contains only alphanumeric characters, false otherwise.
 */
fun String.isAlphaNumeric(): Boolean = this.matches("[a-zA-Z0-9]+".toRegex())

/**
 * Extension function to check if a string is numeric.
 *
 * @return True if the string contains only numeric characters, false otherwise.
 */
fun String.isNumeric(): Boolean = this.matches("\\d+".toRegex())

/**
 * Extension function to check if a string contains only digits.
 *
 * @return True if the string contains only digit characters, false otherwise.
 */
fun String.isOnlyDigits(): Boolean = this.all { it.isDigit() }

/**
 * Extension function to convert a string to an integer, or return zero if the conversion fails.
 *
 * @return The integer value of the string, or zero if the conversion fails.
 */
fun String.toIntOrZero(): Int = this.toIntOrNull() ?: 0

/**
 * Extension function to check if a string is a valid phone number.
 *
 * @return True if the string matches the phone number pattern, false otherwise.
 */
fun String.isValidPhoneNumber(): Boolean =
    this.matches("^\\+?[0-9]{1,4}?[-.\\s]?\\(?[0-9]{1,3}?\\)?[-.\\s]?[0-9]{3}[-.\\s]?[0-9]{4}$".toRegex())
