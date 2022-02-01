package com.company;
//Onyinyechi Aghaizu
//11284287
//ona341
import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

public class PatientMapAccess {
    private static final TreeMap<String, Patient> patients=new TreeMap<>();
    private PatientMapAccess(){
    }
//    private static
public static TreeMap <String,Patient> getInstance(){
return patients;
}

}
