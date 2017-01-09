/**
 * Created by manindrajha on 04/01/2017.
 */

public class TestBerlinClock {

   static BerlinClock berlinClock = new BerlinClock();

    public static void main(String[] args){

        String s="";
        if(args.length>0){

            s = args[0];
        }
        String[] display= berlinClock.getBerlinTimeFormat(s);


        for (int k=0; k<display.length; k++){

            System.out.println(display[k]);
        }


    }
}
