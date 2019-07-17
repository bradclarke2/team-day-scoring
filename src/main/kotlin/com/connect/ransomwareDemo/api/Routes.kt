package com.connect.ransomwareDemo.api

import com.connect.ransomwareDemo.handler.ClueHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.router

@Configuration
class Routes{
    @Bean
    fun router(clueHandler: ClueHandler) = router {
        POST("/setup", clueHandler::createPair )
    }
}