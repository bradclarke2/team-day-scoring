package com.connect.ransomwareDemo.handler

import com.connect.ransomwareDemo.domain.CodeGroup
import com.connect.ransomwareDemo.repository.CodeGroupRepository
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.body
import reactor.core.publisher.Mono

@Component
class CodeGroupHandler(val codeGroupRepository: CodeGroupRepository) {

    fun createCodeGroup(req: ServerRequest): Mono<ServerResponse> {
        val bodyToMono = req.bodyToMono(CodeGroup::class.java)
        val publisher = codeGroupRepository.saveAll(bodyToMono)
        return ServerResponse.ok().body(publisher)
    }

    fun getCodeGroup(req: ServerRequest): Mono<ServerResponse> =
            ServerResponse.ok().body(codeGroupRepository.findAll())
}