package br.edu.unifio.sistemabiomedicina.utils;

import java.lang.reflect.Field;

public class StringUtil {
    // Método para converter para maiúsculas
    public static void convertToUpperCase(Object obj) {
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.getType() == String.class) {
                try {
                    field.setAccessible(true);
                    String value = (String) field.get(obj);
                    if (value != null) {
                        field.set(obj, value.toUpperCase());
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace(); //
                }
            }
        }
    }

}
