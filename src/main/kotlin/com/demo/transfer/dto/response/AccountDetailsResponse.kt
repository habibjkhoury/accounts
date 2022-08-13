package com.demo.transfer.dto.response

import io.swagger.v3.oas.annotations.media.Schema
import java.math.BigDecimal

data class AccountDetailsResponse(
    @field:Schema(description = "Account ID", required = true)
    val id: Long,
    @field:Schema(description = "Account IBAN", required = true)
    val iban: String,
    @field:Schema(description = "Account Balance", required = true)
    val balance: BigDecimal)
