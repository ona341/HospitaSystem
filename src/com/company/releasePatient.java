package com.company;
//Onyinyechi Aghaizu
//11284287
//ona341
import java.util.NoSuchElementException;

/**
 * Release a patient from the ward.
 */
public class releasePatient implements Command{
    public void execute(){IOAccess.getInstance().outputString("\nReleasing a patient");
        IOAccess.getInstance().outputString("\nGetting Patient information...");

        String healthNumber = IOAccess.getInstance().readString("\nEnter the health number of the patient: ");
        Patient p = PatientMapAccess.getInstance().get(healthNumber);
        if (p == null)
            throw new NoSuchElementException("There is no patient with health number "
                    + healthNumber);

        int bedlabel=p.getBedLabel();
        p.setBedLabel(-1);
        WardAccess.getInstance().freeBed(bedlabel);}
}
