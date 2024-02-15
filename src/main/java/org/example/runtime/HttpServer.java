package org.example.runtime;
import java.lang.reflect.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static java.lang.Class.forName;

public class HttpServer {

    static Map<String, Method> componentes = new HashMap<String, Method>();
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        // 1.Cargar los componentes anotados con @Component
        //Para el primer prototipo lo leeré de la linea de comandos
        // Para la entrega final lo deben leer del disco

        Class c = Class.forName(args[0]);

        if(c.isAnnotationPresent(Component.class)) {
            for (Method m : Class.forName(args[0]).getMethods()) {
                if (m.isAnnotationPresent(GetMaping.class)) {
                    componentes.put(m.getAnnotation(GetMaping.class).value(), m);
                }
            }
        }

        // 2. Almacenar todos los métodos en una estructure llave valor
        // la llave sera el parth del webservice y el valor osn métodos
        //  Ojo todos los métodos serán estaticos

        String pathGet = "/component/hellow";
        String queryValue = "Miguel";
        Method m = componentes.get(pathGet.substring(11));
        if (m != null) {
            ///m.invoke(null);
            System.out.println("Salida: " + m.invoke(null,queryValue));
        }

        // 3. Si llega una ruta que está en lazada a un componente
        // Ejecute el componente. no olvide los encabezados
        // implemente pasar parámetros.
    }

}
