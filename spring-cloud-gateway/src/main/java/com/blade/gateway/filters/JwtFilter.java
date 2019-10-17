package com.blade.gateway.filters;

import com.alibaba.fastjson.JSONObject;
import com.google.common.net.HttpHeaders;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 前置过滤器，主要作用是做token校验
 * @author lyq
 * @create 8/15/19
 */
@Component
@Slf4j
public class JwtFilter implements GlobalFilter,Ordered {

    /**
     * 白名单路径
     */
    private static Set<String> whitePath;

    static {
        whitePath = new HashSet<>();
        whitePath.add("/api/system/users/login");
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        String path = request.getURI().getPath();
        if (whitePath.contains(path)) {
            return chain.filter(exchange);
        }
        String token = request.getHeaders().getFirst(HttpHeaders.AUTHORIZATION);
        if (StringUtils.isEmpty(token)) {
            ServerHttpResponse response = exchange.getResponse();
            return authFailure(response);
        }
        // TODO:校验token
        ServerHttpRequest httpRequest = request.mutate().header("Authorization", token).build();
        ServerWebExchange build = exchange.mutate().request(httpRequest).build();
        return chain.filter(build);

    }

    private Mono<Void> authFailure(ServerHttpResponse resp) {
        resp.setStatusCode(HttpStatus.UNAUTHORIZED);
        resp.getHeaders().add("Content-Type","application/json;charset=UTF-8");
        Map<String,Object> result = new HashMap<>();
        result.put("code",HttpStatus.UNAUTHORIZED.value());
        result.put("message","未登录,请先登录！");
        String returnStr = "";
        try {
            returnStr = JSONObject.toJSONString(result);
        } catch (Exception e) {
            log.error(e.getMessage(),e);
        }
        DataBuffer buffer = resp.bufferFactory().wrap(returnStr.getBytes(StandardCharsets.UTF_8));
        return resp.writeWith(Flux.just(buffer));
    }

    @Override
    public int getOrder() {
        return -1;
    }

}
