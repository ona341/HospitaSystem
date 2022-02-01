package com.company;
//Onyinyechi Aghaizu
//11284287
//ona341

/**
 * A simple hospital system with only one ward.  Patients and doctors can be created,
 * and patients assigned to a doctor and/or placed in a bed of the ward.
 */
public class HospitalSystemA5Q6
{
    /**
     * Initialize an instance of the hospital ward
     * relies on user-input to get the relavent information
     */
    public HospitalSystemA5Q6() {

        IOAccess.getInstance().outputString("\nGetting Ward information...");

        String name =IOAccess.getInstance().readString("\nEnter the name of the Ward: ");
        IOAccess.getInstance().outputString("\nEntered: " + name);
        int firstBedNum = IOAccess.getInstance().readInt("\nEnter the integer label of the first bed: ");
        IOAccess.getInstance().outputString("\nEntered: " + firstBedNum);

        int lastBedNum = IOAccess.getInstance().readInt("\nEnter the integer label of the last bed: ");
        IOAccess.getInstance().outputString("\nEntered: " + lastBedNum);

        WardAccess.initialize(name,firstBedNum,lastBedNum);
    }

    /**
     * Run the hospital system.
     * @param args not used
     */
    public static void main(String[] args){
        int task = -1;
        Command [] commands = new Command [9];
        commands[0]=new SystemState();
        commands[1]=new AddPatient();
        commands[2]=new AddDoctor();
        commands[3]=new AssignDoctorToPatient();
        commands[4]=new displayEmptyBeds();
        commands[5]=new AssignBed();
        commands[6]=new releasePatient();
        commands[7]=new DropAssociation();
        commands[8]=new SystemState();
        HospitalSystemA5Q6 sys;

        IOAccess.getInstance().outputString("\nInitializing the system...");

        while (true) {
            // keep trying until the user enters the data correctly
            try {
                sys = new HospitalSystemA5Q6();
                break;
            }
            catch (RuntimeException e) {
                IOAccess.getInstance().outputString(e.getMessage());
            }
        }

        while(task != 0) {
            try
            {
                String[] options=new String [9];
                options[0]="\n\t1: quit";
                options[1]="\n\t2: add a new patient";
                options[2]="\n\t3: add a new doctor";
                options[3]="\n\t4: assign a doctor to a patient";
                options[4]="\n\t5: display the empty beds of the ward";
                options[5]="\n\t6: assign a patient a bed";
                options[6]="\n\t7: release a patient";
                options[7]="\n\t8: drop doctor-patient association";
                options[8]="\n\t9: display current system state\nEnter your selection {1-9}:";

                task = IOAccess.getInstance().readChoice(options);
                commands[task].execute();
            }
            catch (RuntimeException e) {
                IOAccess.getInstance().outputString(e.getMessage());
            }
        }
    }
}

