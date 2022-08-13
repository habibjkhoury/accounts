package com.demo.transfer.controller

import com.demo.transfer.dto.request.TransferRequest
import com.demo.transfer.dto.response.AccountDetailsResponse
import com.demo.transfer.dto.response.TransferResponse
import com.demo.transfer.service.impl.AccountService
import com.demo.transfer.service.impl.TransferService
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api/v1/account")
class AccountController(val transferService: TransferService, val accountService: AccountService) {

    @PostMapping("/transfer")
    fun transfer(@Valid @RequestBody req: TransferRequest): TransferResponse = transferService.transfer(req)

    @GetMapping("/{id}")
    fun get(@PathVariable id: Long): AccountDetailsResponse = accountService.get(id)
}