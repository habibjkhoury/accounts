package com.demo.transfer.service

import com.demo.transfer.dto.response.AccountDetailsResponse
import com.demo.transfer.entity.Account
import com.demo.transfer.exception.AccountNotFoundException
import com.demo.transfer.repository.AccountRepository
import com.demo.transfer.service.impl.AccountService
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.mockito.Mockito.mock
import java.math.BigDecimal
import java.util.*

class AccountServiceTest {

    private val accountRepository: AccountRepository = mock(AccountRepository::class.java)

    private val accountService: AccountService = AccountService(accountRepository)

    @Test
    fun `get account with id not found should return error`(){
        Mockito.`when`(accountRepository.findById(3L)).thenReturn(Optional.empty())

        Assertions.assertThrows(AccountNotFoundException::class.java) {
            accountService.get(
                3L
            )
        }
    }

    @Test
    fun `get account with id not found should return details`(){

        val details = AccountDetailsResponse(1L, "123", BigDecimal.TEN)
        val account = Account()
        account.id = 1L
        account.balance = BigDecimal.TEN
        account.iban = "123"
        Mockito.`when`(accountRepository.findById(1L)).thenReturn(Optional.of(account))

        Assertions.assertEquals(accountService.get(1L), details)
    }
}