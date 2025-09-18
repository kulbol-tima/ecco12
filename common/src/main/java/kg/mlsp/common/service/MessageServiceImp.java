package kg.mlsp.common.service;

import kg.mlsp.common.exception.ErrorMessage;
import kg.mlsp.common.exception.SuccessMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;


@Slf4j
@Service
@RequiredArgsConstructor
public class MessageServiceImp implements MessageService{
    @Override
    public Map<String, String> getErrorMessages() {
        return ErrorMessage.toMap();
    }

    @Override
    public Map<String, String> getSuccessMessages() {
        return SuccessMessage.toMap();
    }
}
