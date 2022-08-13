package com.demo.transfer.service.impl

import com.demo.transfer.dto.response.AccountDetailsResponse
import com.demo.transfer.exception.AccountNotFoundException
import com.demo.transfer.repository.AccountRepository
import com.demo.transfer.service.IAccountService
import org.springframework.stereotype.Service
import java.util.*

@Service
class AccountService(private val accountRepository: AccountRepository): IAccountService {
    override fun get(id: Long): AccountDetailsResponse {
        val account = accountRepository.findById(id).getValueIfPresent("Account Not Found")
        return AccountDetailsResponse(account.id, account.iban, account.balance)
    }

}

inline fun <reified T> Optional<T>.getValueIfPresent(errorMessage: String): T =
    if (this.isPresent) this.get() else throw AccountNotFoundException(errorMessage)