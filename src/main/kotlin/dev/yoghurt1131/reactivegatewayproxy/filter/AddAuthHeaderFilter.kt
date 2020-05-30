package dev.yoghurt1131.reactivegatewayproxy.filter

import org.springframework.cloud.gateway.filter.GatewayFilterChain
import org.springframework.cloud.gateway.filter.GlobalFilter
import org.springframework.core.Ordered
import org.springframework.http.server.reactive.ServerHttpRequest
import org.springframework.web.server.ServerWebExchange
import reactor.core.publisher.Mono

class AddAuthHeaderFilter : GlobalFilter, Ordered {

    override fun filter(exchange: ServerWebExchange?, chain: GatewayFilterChain?): Mono<Void> {
        val request: ServerHttpRequest = exchange!!.request.mutate()
                .header("X-AUTH-HEADER", "AUTH_VALUE")
                .build()
        return chain!!.filter(exchange.mutate().request(request).build())
    }

    override fun getOrder() = Ordered.LOWEST_PRECEDENCE
}