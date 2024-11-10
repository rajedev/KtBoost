package com.rajedev.ktboostext

import java.text.Normalizer
import java.util.Locale

/**
 * Copyright (c) 2024 /LiveRamp, All rights reserved.
 * Created by Rajendhiran Easu on 10/11/24.
 * Description: Extension function for the string manipulation
 */

fun String.toInitials(maxSize: Int = 1): String {
    return this.split(" ")
        .filter { it.isNotEmpty() }
        .joinToString("") { it.first().uppercase() }
        .take(maxSize)
}

fun String.toTitleCase(): String = this.split(" ")
    .joinToString(" ") { it.replaceFirstChar { char -> char.uppercase() } }

fun String.toSnakeCase(): String {
    return this.replace(Regex("([a-z])([A-Z])"), "$1_$2").lowercase()
}

fun String.toCamelCase(): String {
    return this.split(" ").joinToString("") { word ->
        word.replaceFirstChar {
            if (it.isLowerCase()) it.titlecase(
                Locale.ROOT
            ) else it.toString()
        }
    }.replaceFirstChar { it.lowercase(Locale.ROOT) }
}

fun String.toKebabCase(): String = this.replace(Regex("([a-z])([A-Z])"), "$1-$2").lowercase()

fun String.truncate(maxLength: Int, showEllipsizeDot: Boolean = true): String =
    if (this.length > maxLength) {
        this.substring(0, maxLength) + if (showEllipsizeDot) "..." else ""
    } else {
        this
    }

fun String.removeAccents(): String = Normalizer.normalize(this, Normalizer.Form.NFD)
    .replace("[^\\p{ASCII}]".toRegex(), "")

fun String.replaceWords(vararg replacements: Pair<String, String>): String {
    var result = this
    replacements.forEach { (oldValue, newValue) ->
        result = result.replace(oldValue, newValue)
    }
    return result
}

fun String.cleanString(): String = this.replace("[^a-zA-Z0-9\\s]".toRegex(), "").trim()

fun String.getWordsCount(): Int = this.split(" ").count { it.isNotEmpty() }

