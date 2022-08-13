package com.demo.transfer.dto.request

import io.swagger.v3.oas.annotations.media.Schema
import org.jetbrains.annotations.NotNull
import java.math.BigDecimal
import javax.validation.constraints.Positive

data class TransferRequest(
    @field:NotNull
    @field:Schema(description = "Sender IBAN", required = true)
    val sender: String,
    @field:NotNull
    @field:Schema(description = "Receiver IBAN", required = true)
    val receiver: String,
    @field:NotNull
    @field:Positive
    @field:Schema(description = "Positive amount of the transaction", required = true)
    val amount: BigDecimal
)