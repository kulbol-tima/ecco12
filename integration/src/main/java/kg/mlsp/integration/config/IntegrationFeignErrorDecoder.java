package kg.mlsp.integration.config;

import feign.FeignException;
import feign.Response;
import feign.codec.ErrorDecoder;

public class IntegrationFeignErrorDecoder implements ErrorDecoder {
    @Override
    public Exception decode(String methodKey, Response response) {
        return FeignException.errorStatus(methodKey, response);
    }
}