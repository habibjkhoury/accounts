package com.demo.transfer.exception.handler

import com.demo.transfer.exception.AccountNotFoundException
import com.demo.transfer.exception.InsufficientBalanceException
import com.demo.transfer.model.ErrorResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@ControllerAdvice
open class GlobalExceptionHandler : ResponseEntityExceptionHandler() {
    @ExceptionHandler(value = [AccountNotFoundException::class])
    protected fun handleAccountNotFoundException(
        ex: AccountNotFoundException
    ): ResponseEntity<Any> {
        val errorResponse: ErrorResponse? =
            ex.message?.let { ErrorResponse(it) }
        return ResponseEntity.badRequest().body(errorResponse)
    }

    @ExceptionHandler(value = [InsufficientBalanceException::class])
    protected fun handleInsufficientBalanceException(
        ex: InsufficientBalanceException
    ): ResponseEntity<Any> {
        val errorResponse: ErrorResponse? =
            ex.message?.let { ErrorResponse(it) }
        return ResponseEntity.badRequest().body(errorResponse)
    }
}