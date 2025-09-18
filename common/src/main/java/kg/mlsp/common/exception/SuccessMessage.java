package kg.mlsp.common.exception;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.LinkedHashMap;
import java.util.Map;

public class SuccessMessage {
    public static final String RECORD_DELETED = "Запись успешно удалена.";
    public static final String STATUS_CHANGED = "Статус успешно изменен.";


    public static Map<String, String> toMap() {
        Map<String, String> map = new LinkedHashMap<>();
        Field[] fields = SuccessMessage.class.getDeclaredFields();
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
