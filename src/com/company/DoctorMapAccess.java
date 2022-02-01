package com.company;
//Onyinyechi Aghaizu
//11284287
//ona341
import java.util.TreeMap;


/**
 * This class creates a single TreeMap instance to store doctors
 */
public class DoctorMapAccess {
    private static final TreeMap<String, Doctor> doctors=new TreeMap<>();

    /**
     * private constructor to ensure only one is created
     */
    private DoctorMapAccess(){ }
    /**
     * returns the dictionary containing all doctors known to the system.
     * @return a treemap that is the an instance of the class
     */
    public static TreeMap <String,Doctor> getInstance(){
        return doctors;
    }
}
