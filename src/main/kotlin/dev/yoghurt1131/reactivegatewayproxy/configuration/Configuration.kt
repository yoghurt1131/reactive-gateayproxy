package dev.yoghurt1131.reactivegatewayproxy.configuration

import dev.yoghurt1131.reactivegatewayproxy.filter.AddAuthHeaderFilter
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
    fun addAuthHeaderFilter(): AddAuthHeaderFilter {
        return AddAuthHeaderFilter()
    }

}