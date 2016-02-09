package util;

public class Seconds2Words 
{
    private int seconds;

    public Seconds2Words(int seconds) 
    {
        this.seconds = seconds;
    }

    public String convert()
    {
        String result = "";

        int seconds = this.seconds;
        int displaySeconds = seconds % 60;

        int minutes = (int) Math.floor(seconds / 60);
        int displayMinutes = minutes % 60;

        int hours = (int) Math.floor(minutes / 60);
        int displayHours = hours % 60;

        boolean shouldPrintSeconds = displaySeconds != 0 || displayMinutes == 0;
        boolean shouldPrintMinutes = (displayMinutes != 0 || displayHours == 0) && minutes > 0;

        if (seconds >= 3600) {
            result = pluralise(result, displayHours, "hour", shouldPrintMinutes || shouldPrintSeconds);
        }

        if (shouldPrintMinutes) {			
            result = pluralise(result, displayMinutes, "minute", shouldPrintSeconds);
        }

        if (shouldPrintSeconds) {
            result = pluralise(result, displaySeconds, "second", false);
        }

        return result;
    }

    private String pluralise(String result, int units, String unitName, boolean addComma)
    {
        if (units == 1) {
            result += units + " " + unitName;
        } else {
            result += units + " " + unitName + "s";
        }

        if (addComma) {
            result += ", ";
        }

        return result;
    }
}
