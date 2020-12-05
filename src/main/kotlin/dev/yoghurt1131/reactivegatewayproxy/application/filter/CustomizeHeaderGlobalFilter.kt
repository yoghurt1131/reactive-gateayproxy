package dev.yoghurt1131.reactivegatewayproxy.application.filter

import dev.yoghurt1131.reactivegatewayproxy.application.request.ProxyHeaderSupplier
import org.springframework.cloud.gateway.filter.GatewayFilterChain
import org.springframework.cloud.gateway.filter.GlobalFilter
import org.springframework.core.Ordered
import org.springframework.http.server.reactive.ServerHttpRequest
import org.springframework.web.server.ServerWebExchange
import reactor.core.publisher.Mono

class CustomizeHeaderGlobalFilter(
        private val proxyHeaderSuppliers: List<ProxyHeaderSupplier>
) : GlobalFilter, Ordered {

    override fun filter(exchange: ServerWebExchange?, chain: GatewayFilterChain?): Mono<Void> {
        val requestBuilder: ServerHttpRequest.Builder = exchange!!.request.mutate()
        proxyHeaderSuppliers.forEach { sup -> requestBuilder.header(sup.get().headerName, sup.get().headerValue) }
        val request: ServerHttpRequest = requestBuilder.build()
        return chain!!.filter(exchange.mutate().request(request).build())
    }

    override fun getOrder() = Ordered.LOWEST_PRECEDENCE
}