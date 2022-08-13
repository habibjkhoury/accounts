package com.demo.transfer.controller

import com.demo.transfer.dto.request.TransferRequest
import com.demo.transfer.dto.response.AccountDetailsResponse
import com.demo.transfer.dto.response.TransferResponse
import com.demo.transfer.service.impl.AccountService
import com.demo.transfer.service.impl.TransferService
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.mockito.Mockito.mock
import java.math.BigDecimal


class AccountControllerTest {

    private val transferService: TransferService = mock(TransferService::class.java)
    private val accountService: AccountService = mock(AccountService::class.java)

    private val accountController: AccountController = AccountController(transferService, accountService)

    @Test
    fun `transfer call should return success`(){

        val transferRequest = TransferRequest("123", "456", BigDecimal.TEN)

        Mockito.`when`(transferService.transfer(transferRequest)).thenReturn(TransferResponse("successful"))

        Assertions.assertEquals(accountController.transfer(transferRequest).message, "successful")

    }

    @Test
    fun `get account should return details`(){

        Mockito.`when`(accountService.get(1L)).thenReturn(AccountDetailsResponse(1L, "123", BigDecimal.TEN))

        Assertions.assertEquals(accountController.get(1L), AccountDetailsResponse(1L, "123", BigDecimal.TEN))

    }
}