package org.example.examples;

import java.lang.reflect.*;
import java.util.Arrays;

import static java.lang.System.*;

public class InvokeMain {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        try {
            Class<?> c = Class.forName(args[0]);
            Class[] argTypes = new Class[]{int.class, int.class};
            Method main = c.getDeclaredMethod("suma", argTypes);
            String[] mainArgs = Arrays.copyOfRange(args, 1, args.length);
            System.out.format("invoking %s.suma()%n", c.getName());
            main.invoke(null, Integer.parseInt(mainArgs[0]), Integer.parseInt(mainArgs[1]));
            // production code should handle these exceptions more gracefully
        } catch (ClassNotFoundException x) {
            x.printStackTrace();
        } catch (NoSuchMethodException x) {
            x.printStackTrace();
        }
    }
}
