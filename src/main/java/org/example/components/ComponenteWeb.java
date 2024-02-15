package org.example.components;

import org.example.runtime.Component;
import org.example.runtime.GetMaping;

@Component
public class ComponenteWeb {

     @GetMaping("/hellow")
     public static String hello(String a ){
        return "Hellow World " + a;
    }
}
