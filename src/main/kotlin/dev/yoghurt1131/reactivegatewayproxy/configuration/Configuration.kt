package dev.yoghurt1131.reactivegatewayproxy.configuration

import dev.yoghurt1131.reactivegatewayproxy.application.filter.CustomizeHeaderGlobalFilter
import dev.yoghurt1131.reactivegatewayproxy.application.request.AuthProxyHeaderSupplierImpl
import dev.yoghurt1131.reactivegatewayproxy.application.request.ProxyHeaderSupplier
import dev.yoghurt1131.reactivegatewayproxy.properties.ProxyProperties
import org.springframework.boot.autoconfigure.AutoConfigureBefore
import org.springframework.cloud.gateway.config.GatewayAutoConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.stereotype.Component

@Component
@Configuration
@AutoConfigureBefore(GatewayAutoConfiguration::class)
class Configuration {


    @Bean
    fun authProxyHeaderSupplierImpl(proxyProperties: ProxyProperties): ProxyHeaderSupplier {
        return AuthProxyHeaderSupplierImpl(proxyProperties)
    }

    @Bean
    fun addAuthHeaderFilter(proxyHeaderSuppliers: List<ProxyHeaderSupplier>): CustomizeHeaderGlobalFilter {
        return CustomizeHeaderGlobalFilter(proxyHeaderSuppliers)
    }

}