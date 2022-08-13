package com.demo.transfer.repository

import com.demo.transfer.entity.Account
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.transaction.annotation.Transactional
import java.math.BigDecimal


@Transactional(readOnly = true)
interface AccountRepository : JpaRepository<Account, Long>{
    fun findByIban(iban: String):Account?

    @Query(value = """
        UPDATE account
        SET balance = balance + :amount
        WHERE id = :id
        """,
        nativeQuery = true)
    @Modifying
    @Transactional
    fun addBalance(@Param("id") id: Long, @Param("amount")amount: BigDecimal)
}