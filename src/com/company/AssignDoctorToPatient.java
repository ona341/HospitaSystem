package com.company;
//Onyinyechi Aghaizu
//11284287
//ona341
import java.util.NoSuchElementException;
/**
 * Assign a doctor to take care of a patient.
 */
public class AssignDoctorToPatient implements Command{

    public void execute(){
        IOAccess.getInstance().outputString("Assigning a new Doctor-Patient Association...");

        String healthNumber = IOAccess.getInstance().readString("\nEnter the health number of the patient: \n");

        Patient p = PatientMapAccess.getInstance().get(healthNumber);
        if (p == null)
            throw new NoSuchElementException("There is no patient with health number "
                    + healthNumber);

        IOAccess.getInstance().outputString("\nGetting Doctor information...");
        String name = IOAccess.getInstance().readString("\nEnter the name of the doctor: ");
        Doctor d = DoctorMapAccess.getInstance().get(name);
        if (d == null)
            throw new NoSuchElementException("There is no doctor with name " + name);
        else
        {
            p.addDoctor(d);
            d.addPatient(p);
        }
    }
}
