package org.bakore;

import org.joda.time.DateTime;

public class Problem19 {
    //Start on Sunday
    private static final DateTime START_DATE= new DateTime(1899,12,31,0,0,0);
    private static final DateTime END_DATE= new DateTime(2001,1,1,0,0,0);


    //TODO: implement this without using the date library.
    public static void main(String [] args){
        int noOfSundays =0;
        // Increment by 7
         for(DateTime date = START_DATE ; date.isBefore(END_DATE); date=date.plusDays(7)){
             //Ignore all days in 1901 if any
             if(date.getYear()==1900){
                 continue;
             }
            if(date.getDayOfMonth()==1){
                noOfSundays++;
                //System.out.println(date.toString());
            }
        }
        System.out.println("No of Sundays: "+ noOfSundays);
    }

}
