package kg.mlsp.common.exception;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.LinkedHashMap;
import java.util.Map;

public class ErrorMessage {
    public static final String APPLICATION_NOT_FOUND = "Заявка с указанным ID не найдена: %s";
    public static final String APPLICATION_APPLICANT_EMPTY = "Заявитель пустой для заявки с ID: %s";
    public static final String APPLICATION_APPLICANT_PIN_EMPTY = "ПИН заявителя пустой для заявки с ID: %s";
    public static final String INCOME_NOT_FOUND = "Доход с указанным ID не найден: %s";
    public static final String FAMILY_MEMBER_NOT_FOUND = "Член семьи с указанным ID не найден: %s";
    public static final String PERSON_NOT_FOUND = "Физическое лицо с указанным ID не найдено: %s";


    public static final String ATTACHMENT_NOT_FOUND = "Файл с указанным ID не найдено: %s";
    public static final String ATTACHMENT_FILE_EMPTY = "Файл не выбран";
    public static final String ATTACHMENT_DOCUMENT_TYPE_EMPTY = "Тип документа не выбран";
    public static final String ATTACHMENT_DOCUMENT_TYPE_NOT_FOUND = "Тип документа не найден";


    public static Map<String, String> toMap() {
        Map<String, String> map = new LinkedHashMap<>();
        Field[] fields = ErrorMessage.class.getDeclaredFields();
        for (Field field : fields) {
            if (Modifier.isStatic(field.getModifiers()) &&
                    Modifier.isFinal(field.getModifiers()) &&
                    field.getType().equals(String.class)) {
                try {
                    map.put(field.getName(), (String) field.get(null));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return map;
    }
}
