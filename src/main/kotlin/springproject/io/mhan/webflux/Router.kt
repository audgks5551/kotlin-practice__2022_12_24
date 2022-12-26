package springproject.io.mhan.webflux

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.RouterFunctions.route
import org.springframework.web.reactive.function.server.ServerResponse

@Configuration
class Router {

    @Bean
    fun helloRouter(handler: HelloHandler) : RouterFunction<ServerResponse> =
        route()
            .GET("/") { request ->  handler.sayHello(request) }
            // .GET("/", handler::sayHello) 위와 동일
            .build()
}