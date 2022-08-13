package com.demo.transfer.service

import com.demo.transfer.dto.request.TransferRequest
import com.demo.transfer.entity.Account
import com.demo.transfer.exception.AccountNotFoundException
import com.demo.transfer.exception.InsufficientBalanceException
import com.demo.transfer.repository.AccountRepository
import com.demo.transfer.service.impl.TransferService
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import java.math.BigDecimal

class TransferServiceTest {

    private val accountRepository: AccountRepository = Mockito.mock(AccountRepository::class.java)

    private val transferService: TransferService = TransferService(accountRepository)

    companion object{

        private val sender: Account = Account()
        private val receiver: Account = Account()

        @BeforeAll
        fun setup(){
            sender.id = 1L
            sender.iban = "123"
            sender.balance = BigDecimal(100)

            receiver.id = 2L
            receiver.iban = "456"
            receiver.balance = BigDecimal(200)
        }
    }

    @Test
    fun `transfer with sender not found should return error`(){
        Mockito.`when`(accountRepository.findByIban("789")).thenReturn(null)
        Mockito.`when`(accountRepository.findByIban("456")).thenReturn(Account())

        Assertions.assertThrows(AccountNotFoundException::class.java) {
            transferService.transfer(
                TransferRequest("789", "456", BigDecimal.TEN)
            )
        }
    }

    @Test
    fun `transfer with receiver not found should return error`(){
        Mockito.`when`(accountRepository.findByIban("123")).thenReturn(null)
        Mockito.`when`(accountRepository.findByIban("789")).thenReturn(Account())

        Assertions.assertThrows(AccountNotFoundException::class.java) {
            transferService.transfer(
                TransferRequest("123", "789", BigDecimal.TEN)
            )
        }
    }

    @Test
    fun `transfer with amount higher than balance should return error`(){
        Mockito.`when`(accountRepository.findByIban("123")).thenReturn(sender)
        Mockito.`when`(accountRepository.findByIban("456")).thenReturn(receiver)

        Assertions.assertThrows(InsufficientBalanceException::class.java) {
            transferService.transfer(
                TransferRequest("123", "456", BigDecimal(300))
            )
        }
    }
}