package com.rajedev.ktboostext

/**
 * Copyright (c) 2024 /LiveRamp, All rights reserved.
 * Created by Rajendhiran Easu on 10/11/24.
 * Description: Extension function for the network manipulation
 */

fun String.isValidUrl(): Boolean = android.util.Patterns.WEB_URL.matcher(this).matches()

infix fun String.getQueryParam(key: String): String? {
    val regex = """[?&]$key=([^&]*)""".toRegex()
    return regex.find(this)?.groupValues?.get(1)
}

fun String.getQueryParams(): Map<String, List<String>> {
    val regex = """[?&]([^=]*)=([^&]*)""".toRegex()
    return regex.findAll(this)
        .map { it.destructured }
        .groupBy({ it.component1() }, { it.component2() })
}

fun String.extractUrls(): List<String> {
    val urlRegex = """\bhttps?://[^\s]+""".toRegex()
    return urlRegex.findAll(this).map { it.value }.toList()
}

fun String.extractEmails(): List<String> {
    val emailPattern = "[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}".toRegex()
    return emailPattern.findAll(this).map { it.value }.toList()
}
