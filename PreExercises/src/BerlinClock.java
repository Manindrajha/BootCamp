/**
 * Created by manindrajha on 04/01/2017.
 */
import java.lang.*;

public class BerlinClock {

    private String seconds= "";

    private int firstRowMultiplier = 5;
    private int hrsBlockNumbers = 4;
    private int minutesBlockNumbersTop= 11;
    private int minutesBlockNumbersBottom=4;


    /*
    To get the time in Berlin Clock Format
     */

    public String[] getBerlinTimeFormat(String time){

        System.out.println("Input Time Received is :"+time);
        String[] berlinTime = time.split(":");
        int secondsReading = Integer.parseInt(berlinTime[2]);
        System.out.println("Input Seconds Received is :"+secondsReading);
        int hrsReading = Integer.parseInt(berlinTime[0]);
        System.out.println("Input Hrs  Received is :"+hrsReading);
        int minutesReading = Integer.parseInt(berlinTime[1]);
        System.out.println("Input Minutes  Received is :"+minutesReading);

        String[] finalDisplay= new String[]{getSeconds(secondsReading),
                                            getFirstLineHours(hrsReading),
                                            getSecondRowHrs(hrsReading),
                                            getFirstRowMinutes(minutesReading),
                                            getSecondRowMinutes(minutesReading)
        };

        return finalDisplay;
    }

    // Getting the seconds
    private String getSeconds(int inputSeconds){

        if(inputSeconds % 2 == 0)
            seconds="Y";
        else
            seconds= "O";

        return seconds;
    }

    //Getting the firstLine of Hours
    private String getFirstLineHours(int inputHrs){

        int numberOfOnsigns = calculateFirstRowOnSigns(inputHrs);

        String firstRowHrs = displayRedYellow(hrsBlockNumbers,numberOfOnsigns,"R");

        return firstRowHrs;

    }

    private String getSecondRowHrs(int inputHrs){

        int remaininghrs= inputHrs % firstRowMultiplier;
        String secondRowHrs = displayRedYellow(hrsBlockNumbers,remaininghrs,"R");
        return secondRowHrs;
    }

    private String getFirstRowMinutes(int inputMinutes){

        int numberOfOnsigns = calculateFirstRowOnSigns(inputMinutes);
        String firstRowMinutes = displayRedYellow(minutesBlockNumbersTop,numberOfOnsigns,"Y");
        firstRowMinutes = firstRowMinutes.replace("YYY","YYR");
        return firstRowMinutes;

    }

    private String getSecondRowMinutes(int inputMinutes){

        int remainingMinutes= inputMinutes % firstRowMultiplier;
        String secondRowMinutes = displayRedYellow(minutesBlockNumbersBottom,remainingMinutes,"Y");

        return secondRowMinutes;
    }

    private int calculateFirstRowOnSigns(int number){

        return (number-(number % firstRowMultiplier))/firstRowMultiplier;
    }

    private String displayRedYellow(int numberOfBlocks, int numberOfOnsigns, String displayChar){

        String display="";
        for(int i = 0; i<numberOfOnsigns; i++){
            display += displayChar;
        }
        for (int j=0; j< (numberOfBlocks - numberOfOnsigns); j++){

            display += "O";
        }

        return display;
    }

}
