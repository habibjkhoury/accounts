package com.demo.transfer.dto.request

import org.jetbrains.annotations.NotNull
import java.math.BigDecimal
import javax.validation.constraints.Positive

data class TransferRequest(
    @field:NotNull
    val sender: String,
    @field:NotNull
    val receiver: String,
    @field:NotNull
    @field:Positive
    val amount: BigDecimal
)