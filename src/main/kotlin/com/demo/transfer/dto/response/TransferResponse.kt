package com.demo.transfer.dto.response

import io.swagger.v3.oas.annotations.media.Schema

data class TransferResponse (
    @field:Schema(description = "Transfer response message")
    val message: String)