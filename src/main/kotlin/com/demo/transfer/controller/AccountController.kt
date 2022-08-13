package com.demo.transfer.controller

import com.demo.transfer.dto.request.TransferRequest
import com.demo.transfer.dto.response.AccountDetailsResponse
import com.demo.transfer.dto.response.TransferResponse
import com.demo.transfer.model.ErrorResponse
import com.demo.transfer.service.impl.AccountService
import com.demo.transfer.service.impl.TransferService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.ArraySchema
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api/v1/account")
@Tag(name = "account", description = "Account APIs")
class AccountController(val transferService: TransferService, val accountService: AccountService) {

    @PostMapping("/transfer")
    @Operation(
        summary = "Transfer",
        description = "initiate transaction from an account to another"
    )
    @ApiResponses(
        value = [ApiResponse(
            responseCode = "200",
            description = "Successful",
            content = arrayOf(Content(array = ArraySchema(schema = Schema(implementation = TransferResponse::class))))
        ), ApiResponse(
            responseCode = "400",
            description = "Bad request",
            content = arrayOf(Content(array = ArraySchema(schema = Schema(implementation = ErrorResponse::class))))
        )]
    )
    fun transfer(@Valid @RequestBody req: TransferRequest): TransferResponse = transferService.transfer(req)

    @GetMapping("/{id}")
    @Operation(
        summary = "Get Account Details",
        description = "Get Account Details for the specified account"
    )
    @ApiResponses(
        value = [ApiResponse(
            responseCode = "200",
            description = "Successful",
            content = arrayOf(Content(array = ArraySchema(schema = Schema(implementation = AccountDetailsResponse::class))))
        ), ApiResponse(
            responseCode = "400",
            description = "Bad request, Account not found",
            content = arrayOf(Content(array = ArraySchema(schema = Schema(implementation = ErrorResponse::class))))
        )]
    )
    fun get(@PathVariable id: Long): AccountDetailsResponse = accountService.get(id)
}