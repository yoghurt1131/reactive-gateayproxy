package dev.yoghurt1131.reactivegatewayproxy.properties

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationProperties("application.proxy")
class ProxyProperties {

    lateinit var authHeaderName: String
}