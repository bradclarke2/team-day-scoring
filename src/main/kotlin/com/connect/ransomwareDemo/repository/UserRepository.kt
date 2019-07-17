package com.connect.ransomwareDemo.repository

import com.connect.ransomwareDemo.domain.CodeGroup
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Mono

@Repository
interface UserRepository: ReactiveMongoRepository<CodeGroup, String>{
    override fun findById(id: String): Mono<CodeGroup>
}