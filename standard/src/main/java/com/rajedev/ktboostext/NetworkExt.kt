package com.rajedev.ktboostext

import kotlinx.coroutines.delay

/**
 * Created by Rajendhiran Easu on 10/11/24.
 * Description: Extension function for the network manipulation
 */

/**
 * Extension function to check if a string is a valid URL.
 *
 * @return True if the string is a valid URL, false otherwise.
 */
fun String.isValidUrl(): Boolean = android.util.Patterns.WEB_URL.matcher(this).matches()

/**
 * Extension function to get the value of a query parameter from a URL.
 *
 * @param key The key of the query parameter to retrieve.
 * @return The value of the query parameter, or null if the key is not found.
 */
infix fun String.getQueryParam(key: String): String? {
    val regex = """[?&]$key=([^&]*)""".toRegex()
    return regex.find(this)?.groupValues?.get(1)
}

/**
 * Extension function to get all query parameters from a URL.
 *
 * @return A map where the keys are the query parameter names and the values are lists of query parameter values.
 */
fun String.getQueryParams(): Map<String, List<String>> {
    val regex = """[?&]([^=]*)=([^&]*)""".toRegex()
    return regex.findAll(this)
        .map { it.destructured }
        .groupBy({ it.component1() }, { it.component2() })
}

/**
 * Extension function to extract all URLs from a string.
 *
 * @return A list of URLs found in the string.
 */
fun String.extractUrls(): List<String> {
    val urlRegex = """\bhttps?://[^\s]+""".toRegex()
    return urlRegex.findAll(this).map { it.value }.toList()
}

/**
 * Extension function to extract all email addresses from a string.
 *
 * @return A list of email addresses found in the string.
 */
fun String.extractEmails(): List<String> {
    val emailPattern = "[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}".toRegex()
    return emailPattern.findAll(this).map { it.value }.toList()
}

/**
 * A generic function that executes a block of code and retries if it fails,
 * with a specified number of retries and delay between retries.
 * This is useful for network requests or database queries in case of transient errors.
 *
 * @param T The type of the result.
 * @param retries The number of times to retry the block. Default is 3.
 * @param delayMillis The delay between retries in milliseconds. Default is 1000ms.
 * @param block The block of code to execute.
 * @return The result of the block, or null if all retries fail.
 * @throws Exception if all retries fail and no exception was thrown.
 */
suspend fun <T> withRetry(
    retries: Int = 3,
    delayMillis: Long = 1000L,
    block: suspend () -> T
): T? {
    var lastException: Exception? = null
    repeat(retries) {
        try {
            return block()
        } catch (e: Exception) {
            lastException = e
            delay(delayMillis)
        }
    }
    throw lastException ?: Exception("Unknown error")
}
