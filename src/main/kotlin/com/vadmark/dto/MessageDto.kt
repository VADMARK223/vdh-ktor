package com.vadmark.dto

import kotlinx.serialization.Serializable

/**
 * @author Markitanov Vadim
 * @since 17.04.2022
 */
@Serializable
class MessageDto(
    val id: Long? = null,
    val data: String
) {
    constructor(data: String) : this(null, data)
}