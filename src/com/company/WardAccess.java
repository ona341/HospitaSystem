package com.company;
//Onyinyechi Aghaizu
//11284287
//ona341
import java.util.TreeMap;

public class WardAccess {
    /**
     * This class creates a single ward instance
     */
    private static Ward ward;

    /**
     * private constructor
     */

    private WardAccess(){
}

    /**
     * This function creates the ward, but only if it has not been created already.
     * @param name a string that is the ward name
     * @param first an integer that the label of the first bed in the ward
     * @param last an integer that the label of the last bed in the ward
     */
    public static void initialize(String name,int first,int last){
        if(ward!=null){
            throw new IllegalCallerException("Ward has been created already");
        }
        ward=new Ward(name,first,last);
    }

    /**
     * returns the ward instance
     * @return the ward instance
     */
    public static Ward getInstance(){
        if(ward==null){
            throw new IllegalCallerException("Ward has not been created");
        }
        return ward;
    }
}
