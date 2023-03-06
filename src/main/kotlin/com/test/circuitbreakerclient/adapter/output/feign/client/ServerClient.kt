package com.test.circuitbreakerclient.adapter.output.feign.client

import com.test.circuitbreakerclient.adapter.output.feign.response.ServerResponse
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping

@FeignClient(
    name = "server-client",
    url = "http://localhost:8081"
)
interface ServerClient {

    @GetMapping("/v1/server")
    fun getServer(): List<ServerResponse>

}