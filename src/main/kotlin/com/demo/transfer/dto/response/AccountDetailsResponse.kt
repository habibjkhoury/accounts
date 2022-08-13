package com.demo.transfer.dto.response

import java.math.BigDecimal

data class AccountDetailsResponse(val id: Long, val iban: String, val balance: BigDecimal)
