package com.demo.transfer.model

import io.swagger.v3.oas.annotations.media.Schema

data class ErrorResponse(
    @field:Schema(description = "Error message")
    val message: String)