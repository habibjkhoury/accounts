package com.demo.transfer.service

import com.demo.transfer.dto.response.AccountDetailsResponse

interface IAccountService {

    fun get(id: Long): AccountDetailsResponse
}