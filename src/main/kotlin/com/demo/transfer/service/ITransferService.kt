package com.demo.transfer.service

import com.demo.transfer.dto.request.TransferRequest
import com.demo.transfer.dto.response.TransferResponse

interface ITransferService {

    fun transfer(req: TransferRequest): TransferResponse
}