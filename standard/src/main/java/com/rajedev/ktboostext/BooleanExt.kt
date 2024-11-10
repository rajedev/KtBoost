package com.rajedev.ktboostext

/**
 * Created by Rajendhiran Easu on 10/11/24.
 * Description: Extension function for the boolean manipulation
 */

/**
 * Extension function to perform a logical AND NOT operation.
 *
 * @param other The other boolean value to compare with.
 * @return The result of the AND NOT operation.
 */
infix fun Boolean.andNot(other: Boolean): Boolean = this && !other

/**
 * Extension function to perform a logical OR NOT operation.
 *
 * @param other The other boolean value to compare with.
 * @return The result of the OR NOT operation.
 */
infix fun Boolean.orNot(other: Boolean): Boolean = this || !other

/**
 * Extension function to toggle the boolean value.
 *
 * @return The toggled boolean value.
 */
fun Boolean.toggle(): Boolean = !this

/**
 * Extension function to check if a nullable boolean is true.
 *
 * @return True if the boolean is not null and true, false otherwise.
 */
fun Boolean?.isTrue(): Boolean = this != null && this == true

/**
 * Extension function to check if a nullable boolean is false.
 *
 * @return True if the boolean is not null and false, false otherwise.
 */
fun Boolean?.isFalse(): Boolean = this != null && this == false

/**
 * Extension function to check if a nullable boolean is null or true.
 *
 * @return True if the boolean is null or true, false otherwise.
 */
fun Boolean?.isNullOrTrue(): Boolean = this == null || this == true

/**
 * Extension function to check if a nullable boolean is null or false.
 *
 * @return True if the boolean is null or false, false otherwise.
 */
fun Boolean?.isNullOrFalse(): Boolean = this == null || this == false

/**
 * Extension function to convert a boolean to a "Yes" or "No" string.
 *
 * @return "Yes" if the boolean is true, "No" otherwise.
 */
fun Boolean.toYesNo(): String = if (this) "Yes" else "No"

/**
 * Extension function to convert a boolean to a "True" or "False" string.
 *
 * @return "True" if the boolean is true, "False" otherwise.
 */
fun Boolean.asString(): String = if (this) "True" else "False"

/**
 * Extension function to convert a boolean to an integer.
 *
 * @return 1 if the boolean is true, 0 otherwise.
 */
fun Boolean.toInt(): Int = if (this) 1 else 0

/**
 * Inline extension function to execute an action if the boolean is true.
 *
 * @param action The action to execute if the boolean is true.
 */
inline fun Boolean.ifTrue(action: () -> Unit) {
    if (this) action()
}

/**
 * Inline extension function to execute an action if the boolean is false.
 *
 * @param action The action to execute if the boolean is false.
 */
inline fun Boolean.ifFalse(action: () -> Unit) {
    if (!this) action()
}

/**
 * Inline extension function to execute one of two actions based on the boolean value.
 *
 * @param ifTrue The action to execute if the boolean is true.
 * @param ifFalse The action to execute if the boolean is false.
 */
inline fun Boolean.ifTrueOrElse(ifTrue: () -> Unit, ifFalse: () -> Unit) {
    if (this) ifTrue() else ifFalse()
}
