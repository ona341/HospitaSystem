package com.company;
//Onyinyechi Aghaizu
//11284287
//ona341

/**
 * Display the empty beds for the ward.
 */
public class displayEmptyBeds implements Command{
    public void execute(){String empty="Empty Beds:\n";
        for(int ward:WardAccess.getInstance().availableBeds())
        {empty = empty + "Bed: " + Integer.toString(ward)+"\n";}
        IOAccess.getInstance().outputString(empty);
    }
}
