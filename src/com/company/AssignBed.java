package com.company;
//Onyinyechi Aghaizu
//11284287
//ona341
import java.util.NoSuchElementException;

/**
 * Assign a patient to a specific bed.
 */
public class AssignBed implements Command{
    public void execute(){IOAccess.getInstance().outputString("\n Assigning a Patient to a Bed...");

        String healthNumber =IOAccess.getInstance().readString("\nEnter the health number of the patient: ");

        Patient p = PatientMapAccess.getInstance().get(healthNumber);
        if (p == null)
            throw new NoSuchElementException("There is no patient with health number "
                    + healthNumber);

        if (p.getBedLabel() != -1)
            throw new IllegalStateException(" Patient " + p
                    + " is already in a bed so cannot be assigned a new bed");


        int bedNum = IOAccess.getInstance().readInt("\nEnter the bed number for the patient: ");

        if (bedNum < WardAccess.getInstance().getMinBedLabel() || bedNum > WardAccess.getInstance().getMaxBedLabel())
            throw new IllegalArgumentException("Bed label " + bedNum + " is not valid, as "
                    + "the value must be between " + WardAccess.getInstance().getMinBedLabel()
                    + " and " + WardAccess.getInstance().getMaxBedLabel());

        p.setBedLabel(bedNum);
        WardAccess.getInstance().assignPatientToBed(p, bedNum);}
}
