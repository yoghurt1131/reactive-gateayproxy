package dev.yoghurt1131.reactivegatewayproxy.application.request

import java.util.function.Supplier

interface ProxyHeaderSupplier: Supplier<HttpHeader> {
    override fun get(): HttpHeader
}