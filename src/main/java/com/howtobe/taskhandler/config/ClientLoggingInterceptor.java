package com.howtobe.taskhandler.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Slf4j
public class ClientLoggingInterceptor implements ClientHttpRequestInterceptor {

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        logRequest(request, body);
        ClientHttpResponse response = execution.execute(request, body);
        logResponse(response);
        return response;
    }

    private void logRequest(HttpRequest httpRequest, byte[] body) {

        if (log.isDebugEnabled()) {
            log.debug("========================= request start =========================");
            log.debug("URI:     {}", httpRequest.getURI());
            log.debug("Method:  {}", httpRequest.getMethod());
            log.debug("Headers: {}", httpRequest.getHeaders());
            log.debug("Body:    {}", new String(body, StandardCharsets.UTF_8));
            log.debug("=========================  request end  =========================");
        }
    }

    private void logResponse(ClientHttpResponse response) throws IOException {
        if (log.isDebugEnabled()) {
            log.debug("========================= response start =========================");
            log.debug("Status code: {}", response.getStatusCode());
            log.debug("Status text: {}", response.getStatusText());
            log.debug("Headers:     {}", response.getHeaders());
            log.debug("Body:        {}", response.getBody());
            log.debug("=========================  response end  =========================");
        }
    }
}
