package com.connect.ransomwareDemo.handler

import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.ServerResponse.noContent
import reactor.core.publisher.Mono

class ClueHandler {
    fun createPair(req: ServerRequest): Mono<ServerResponse> = noContent().build()
}
