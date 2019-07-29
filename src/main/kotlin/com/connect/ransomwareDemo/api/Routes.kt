package com.connect.ransomwareDemo.api

import com.connect.ransomwareDemo.handler.ClueHandler
import com.connect.ransomwareDemo.handler.CodeGroupHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.reactive.CorsWebFilter
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource
import org.springframework.web.reactive.function.server.router
import java.util.*

@Configuration
class Routes {
    @Bean
    fun router(clueHandler: ClueHandler, codeGroupHandler: CodeGroupHandler) = router {
        accept(MediaType.APPLICATION_JSON).nest {
            GET("/hello", clueHandler::helloWorld)
            POST("/setup", codeGroupHandler::createCodeGroup)
            GET("/users", codeGroupHandler::getCodeGroup)
            PUT("/{id}/answers/{clue}", clueHandler::submitAnswer)
        }
    }

    @Bean
    fun corsWebFilter(): CorsWebFilter {
        val corsConfig = CorsConfiguration()
        corsConfig.allowedOrigins = listOf("*")
        corsConfig.maxAge = 8000L
        corsConfig.allowedMethods = listOf("POST", "GET", "OPTIONS", "HEAD", "PUT", "PATCH", "DELETE")
        corsConfig.allowedHeaders = listOf("*")

        val source = UrlBasedCorsConfigurationSource()
        source.registerCorsConfiguration("/**", corsConfig)

        return CorsWebFilter(source)
    }

}