package com.demo.transfer.service.impl

import com.demo.transfer.dto.request.TransferRequest
import com.demo.transfer.dto.response.TransferResponse
import com.demo.transfer.exception.AccountNotFoundException
import com.demo.transfer.exception.InsufficientBalanceException
import com.demo.transfer.repository.AccountRepository
import com.demo.transfer.service.ITransferService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Isolation
import org.springframework.transaction.annotation.Transactional

@Service
class TransferService(val accountRepository: AccountRepository): ITransferService {

    @Transactional(isolation = Isolation.REPEATABLE_READ)
    override fun transfer(req: TransferRequest): TransferResponse {

        val sender = accountRepository.findByIban(req.sender) ?: throw AccountNotFoundException("wrong sender")
        val receiver = accountRepository.findByIban(req.receiver) ?: throw AccountNotFoundException("wrong receiver")


        if(sender.balance < req.amount){
            throw InsufficientBalanceException("Insufficient balance")
        }
        accountRepository.addBalance(sender.id, req.amount.negate())

        accountRepository.addBalance(receiver.id, req.amount)

        return TransferResponse("Successful")
    }


}