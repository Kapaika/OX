package com.OX.app;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author Bartosz Kupajski
 */
class Language {

    private static Language instance;
    private static ResourceBundle resourceBundle;

    private Language() {
        resourceBundle = ResourceBundle.getBundle("OX",new Locale("en","EN"));
    }

    static synchronized Language getInstance() {
        if (instance == null) {
            instance = new Language();
        }

        return instance;
    }

    String getString(String key) {
        return resourceBundle.getString(key);
    }

    public void changeLangugae(){
        if(resourceBundle.getLocale().getCountry().equals("EN")){
            resourceBundle = ResourceBundle.getBundle("OX",new Locale("pl","PL"));
        }else{
            resourceBundle = ResourceBundle.getBundle("OX",new Locale("en","EN"));
        }
    }

}
