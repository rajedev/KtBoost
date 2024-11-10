package com.rajedev.ktboostext

/**
 * Created by Rajendhiran Easu on 10/11/24.
 * Description: Extension function for the generic manipulation
 */

/**
 * A safe extension function that returns the object itself or a fallback value when the object is null.
 *
 * @param fallback The value to return if the object is null.
 * @return The object itself if it is not null, otherwise the fallback value.
 */
fun <T> T?.orElse(fallback: T): T {
    return this ?: fallback
}