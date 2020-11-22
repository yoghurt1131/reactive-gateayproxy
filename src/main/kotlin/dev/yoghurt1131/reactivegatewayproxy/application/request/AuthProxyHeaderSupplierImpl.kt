package dev.yoghurt1131.reactivegatewayproxy.application.request

import dev.yoghurt1131.reactivegatewayproxy.properties.ProxyProperties

class AuthProxyHeaderSupplierImpl(
        private val proxyProperties: ProxyProperties
) : ProxyHeaderSupplier {
    override fun get(): HttpHeader {
        return HttpHeader(proxyProperties.authHeaderName, "AUTH_HEADER_VALUE")
    }
}