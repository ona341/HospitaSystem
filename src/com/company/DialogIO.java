package com.company;
//Onyinyechi Aghaizu
//11284287
//ona341
import javax.swing.*;

public abstract class DialogIO extends AbstractDialogIO  {

    /**
     * Display a prompt and read the string entered.
     *
     * @param prompt the string to be displayed as a prompt
     * @return the String read
     */
    public String readString(String prompt) {

        return JOptionPane.showInputDialog(prompt);
    }

    /**
     * Display a prompt and read the int entered.
     *
     * @param prompt the string to be displayed as a prompt
     * @return the int read
     */
    public int readInt(String prompt) {

        String entered=JOptionPane.showInputDialog(prompt);

        boolean task=true;
        while(task) {
            try
            {
                Integer.parseInt(entered);
                task=false;

            }

            catch (RuntimeException e) {
                entered=JOptionPane.showInputDialog("Input is not a valid integer.\nTry again\n"+prompt);
            }
        }
        return Integer.parseInt(entered);

    }

    /**
     * Output the String parameter.
     *
     * @param outString the string whose value is to be displayed
     */
    public void outputString(String outString) {
        JOptionPane.showMessageDialog(null, outString);
    }



    /**
     * used to test if the consoleIO was working
     *
     * @param args not used
     */
    public static void main(String[] args) {

        String prompt="\nEnter the name of the patient: ";
        String prompt1="\nEnter the bed number of the patient: ";

        DialogIO test=new DialogIO() {};
        String read=test.readString(prompt);
        test.outputString(read);

        int read1=test.readInt(prompt1);
//        System.out.print(read1);

        String[] options=new String [9];
        options[0]="\n\t1: quit";
        options[1]="\n\t2: add a new patient";
        options[2]="\n\t3: add a new doctor";
        options[3]="\n\t4: assign a doctor to a patient";
        options[4]="\n\t5: display the empty beds of the ward";
        options[5]="\n\t6: assign a patient a bed";
        options[6]="\n\t7: release a patient";
        options[7]="\n\t8: drop doctor-patient association";
        options[8]="\n\t9: display current system state\n";
//        options[0]=;



        int read2=test.readChoice(options);
//        System.out.print(read2);

        //test.outputString(read1);

    }
}
