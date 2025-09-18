package kg.mlsp.common.service;

import java.util.Map;

public interface MessageService {
    Map<String, String> getErrorMessages();
    Map<String, String> getSuccessMessages();
}
