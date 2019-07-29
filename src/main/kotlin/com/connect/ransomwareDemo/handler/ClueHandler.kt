package com.connect.ransomwareDemo.handler

import com.connect.ransomwareDemo.repository.CodeGroupRepository
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.ServerResponse.ok
import org.springframework.web.reactive.function.server.ServerResponse.status
import org.springframework.web.reactive.function.server.body
import reactor.core.publisher.Mono
import reactor.core.publisher.Mono.just

@Component
class ClueHandler(val codeGroupRepository: CodeGroupRepository) {
    fun helloWorld(req: ServerRequest): Mono<ServerResponse> = ok().body(just("Hello World!"))

    fun submitAnswer(req: ServerRequest): Mono<ServerResponse> {
        val codeGroupId = req.pathVariable("id")

        return when (req.pathVariable("clue")) {
            "answer" -> {
                //TODO update the score in database
                ok().body(just("successful"))
            }
            else -> status(HttpStatus.NOT_FOUND).body(just("that is not the correct answer"))
        }

    }
}