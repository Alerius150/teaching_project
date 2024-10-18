package kz.teaching_project.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class UtilFunctions
{
    public String pathnameToName(String name) {
        String[] split = name.split("-");

        for (int i = 0; i < split.length; i++) {
            String first = split[i].substring(0, 1);
            String a = split[i].substring(1);
            String firstCapitalized = first.toUpperCase();
            split[i] = firstCapitalized + a;
        }
        String finalCategoryName = split[0];
        for (int i = 1; i < split.length; i++) {
            finalCategoryName += " " + split[i];
        }
        return finalCategoryName;

    }
    public static String getUniquePathName(String name) {
        String finalResult;
        name = name.replaceAll("[^a-zA-Z0-9\\s]", "");
        String[] split = name.split(" ");

        for (int i = 0; i < split.length; i++) {
            split[i] = split[i].trim().toLowerCase();
        }
        finalResult = split[0];
        for (int i = 1; i < split.length; i++) {
            if(split[i].length() > 0)
                finalResult += "-" + split[i];
        }
        return finalResult;
    }

    public static boolean isLogged() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        boolean isLogged = null != authentication && !("anonymousUser").equals(authentication.getName());
        return isLogged;
    }
}