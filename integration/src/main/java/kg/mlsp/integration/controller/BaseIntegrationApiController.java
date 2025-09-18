package kg.mlsp.integration.controller;

import org.springframework.beans.factory.annotation.Value;

public abstract class BaseIntegrationApiController {

    protected static final String BASE_API_PATH = "/api";

    @Value("${integration-api.base-url}")
    protected String baseUrl;

}
