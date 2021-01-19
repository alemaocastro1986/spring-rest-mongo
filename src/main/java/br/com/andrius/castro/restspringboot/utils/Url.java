package br.com.andrius.castro.restspringboot.utils;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

public class Url {
    public static String decode(String url){
        return URLDecoder.decode(url, StandardCharsets.UTF_8);
    }

}
