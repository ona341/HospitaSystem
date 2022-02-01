package com.company;
//Onyinyechi Aghaizu
//11284287
//ona341

/**
 * this class asks the user which inputoutputinteface type they want to use
 */
public class IOAccess {
    /**
     * A an attribut to hold the interface chosen
     */
    public static InputOutputInterface io;

    /**
     * private constructor
     */
    private IOAccess() {

    }

    /**
     * asks the user to pick an input output type and returns the type chosen
     * @return returns the input output type chosen
     */
    public static InputOutputInterface getInstance(){
        if (io==null){
        InputOutputInterface pickio=new DialogIO(){};
        String[] options=new String [2];
        options[0]="\n\t1: ConsoleIO";
        options[1]="\n\t2: DialogIO";
        int picked=pickio.readChoice(options);
        if (picked==0 ){
            io=new ConsoleIO();
        }
        else if (picked==1){
            io=new DialogIO(){};
        }
        else
            pickio.outputString("Invalid choice.");
        }

        return io;
    }
}
