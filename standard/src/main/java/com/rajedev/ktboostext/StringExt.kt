package com.rajedev.ktboostext

import java.text.Normalizer
import java.util.Locale

/**
 * Created by Rajendhiran Easu on 10/11/24.
 * Description: Extension function for the string manipulation
 */

/**
 * Extension function to convert a string to its initials.
 *
 * @param maxSize The maximum number of initials to return. Default is 1.
 * @return A string containing the initials of the original string, up to the specified maxSize.
 */
fun String.toInitials(maxSize: Int = 1): String {
    return this.split(" ")
        .filter { it.isNotEmpty() }
        .joinToString("") { it.first().uppercase() }
        .take(maxSize)
}

/**
 * Extension function to convert a string to title case.
 *
 * @return A string converted to title case.
 */
fun String.toTitleCase(): String = this.split(" ")
    .joinToString(" ") { it.replaceFirstChar { char -> char.uppercase() } }

/**
 * Extension function to convert a string to snake case.
 *
 * @return A string converted to snake case.
 */
fun String.toSnakeCase(): String {
    return this.replace(Regex("([a-z])([A-Z])"), "$1_$2").lowercase()
}

/**
 * Extension function to convert a string to camel case.
 *
 * @return A string converted to camel case.
 */
fun String.toCamelCase(): String {
    return this.split(" ").joinToString("") { word ->
        word.replaceFirstChar {
            if (it.isLowerCase()) it.titlecase(
                Locale.ROOT
            ) else it.toString()
        }
    }.replaceFirstChar { it.lowercase(Locale.ROOT) }
}

/**
 * Extension function to convert a string to kebab case.
 *
 * @return A string converted to kebab case.
 */
fun String.toKebabCase(): String = this.replace(Regex("([a-z])([A-Z])"), "$1-$2").lowercase()

/**
 * Extension function to truncate a string to a specified length.
 *
 * @param maxLength The maximum length of the truncated string.
 * @param showEllipsizeDot Whether to show ellipsize dots (...) at the end of the truncated string. Default is true.
 * @return The truncated string.
 */
fun String.truncate(maxLength: Int, showEllipsizeDot: Boolean = true): String =
    if (this.length > maxLength) {
        this.substring(0, maxLength) + if (showEllipsizeDot) "..." else ""
    } else {
        this
    }

/**
 * Extension function to remove accents from a string.
 *
 * @return A string with accents removed.
 */
fun String.removeAccents(): String = Normalizer.normalize(this, Normalizer.Form.NFD)
    .replace("[^\\p{ASCII}]".toRegex(), "")

/**
 * Extension function to replace words in a string.
 *
 * @param replacements A vararg of pairs where the first value is the word to be replaced and the second value is the replacement.
 * @return The string with the words replaced.
 */
fun String.replaceWords(vararg replacements: Pair<String, String>): String {
    var result = this
    replacements.forEach { (oldValue, newValue) ->
        result = result.replace(oldValue, newValue)
    }
    return result
}

/**
 * Extension function to clean a string by removing non-alphanumeric characters and trimming whitespace.
 *
 * @return The cleaned string.
 */
fun String.cleanString(): String = this.replace("[^a-zA-Z0-9\\s]".toRegex(), "").trim()

/**
 * Extension function to count the number of words in a string.
 *
 * @return The number of words in the string.
 */
fun String.getWordsCount(): Int = this.split(" ").count { it.isNotEmpty() }

/**
 * Extension function to replace all non-alphanumeric characters in a string.
 *
 * @return The string with all non-alphanumeric characters replaced.
 */
fun String.replaceAllNonAlphaNumeric(): String = this.replace("[^a-zA-Z0-9 ]".toRegex(), "")