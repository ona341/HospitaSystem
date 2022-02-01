package com.company;
//Onyinyechi Aghaizu
//11284287
//ona341
/**
 * Read the information for a new doctor and then add the patient
 * to the dictionary of all patients.
 */
public class AddPatient implements Command{
    public void execute() {

        IOAccess.getInstance().outputString("\nAdding Patient to Ward...");

        String name = IOAccess.getInstance().readString("\nEnter the name of the patient: ");
        IOAccess.getInstance().outputString("\nEntered: " + name);


        String healthNum = IOAccess.getInstance().readString("\nEnter the health number of the patient: ");
        IOAccess.getInstance().outputString("\nEntered: " + healthNum);
        if (PatientMapAccess.getInstance().containsKey(healthNum))
        {
            throw new  IllegalStateException("Patient with the health number " + healthNum + " already exsists");
        }

        Patient p = new Patient(name, healthNum);
        Patient result = PatientMapAccess.getInstance().put(healthNum, p);
        if (result != null)
        {
            PatientMapAccess.getInstance().put(healthNum, result);  // put the original patient back
            throw new IllegalStateException("Health number in the patient dictionary even "
                    + "though containsKey failed.  Number " + healthNum + " not entered.");
        }
    }
    }
