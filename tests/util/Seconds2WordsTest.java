package util;

import static org.junit.Assert.*;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;

public class Seconds2WordsTest 
{
    @Test
    public void convertZeroSeconds() 
    {
        Seconds2Words seconds2Words = new Seconds2Words(0);
        String result = seconds2Words.convert();
        assertThat(result, is(equalTo("0 seconds")));
    }

    @Test
    public void convertOneSecond() 
    {
        Seconds2Words seconds2Words = new Seconds2Words(1);
        String result = seconds2Words.convert();
        assertThat(result, is(equalTo("1 second")));
    }


    @Test
    public void convertFiftyEightSeconds() 
    {
        Seconds2Words seconds2Words = new Seconds2Words(58);
        String result = seconds2Words.convert();
        assertThat(result, is(equalTo("58 seconds")));
    }

    @Test
    public void convertSingularMinsPluralSecs() 
    {
        Seconds2Words seconds2Words = new Seconds2Words(119);
        String result = seconds2Words.convert();
        assertThat(result, is(equalTo("1 minute, 59 seconds")));
    }

    @Test
    public void convertPluralMinsPluralSecs() 
    {
        Seconds2Words seconds2Words = new Seconds2Words(122);
        String result = seconds2Words.convert();
        assertThat(result, is(equalTo("2 minutes, 2 seconds")));
    }

    @Test
    public void convertSingularMinsSingularSecs() 
    {
        Seconds2Words seconds2Words = new Seconds2Words(61);
        String result = seconds2Words.convert();
        assertThat(result, is(equalTo("1 minute, 1 second")));
    }

    @Test
    public void convertPluralMinsSingularSecs() 
    {
        Seconds2Words seconds2Words = new Seconds2Words(121);
        String result = seconds2Words.convert();
        assertThat(result, is(equalTo("2 minutes, 1 second")));
    }

    @Test
    public void convertWholeSingularMinute()
    {
        Seconds2Words seconds2Words = new Seconds2Words(60);
        String result = seconds2Words.convert();
        assertThat(result, is(equalTo("1 minute")));
    }

    @Test
    public void convertWholePluralMinutes()
    {
        Seconds2Words seconds2Words = new Seconds2Words(120);
        String result = seconds2Words.convert();
        assertThat(result, is(equalTo("2 minutes")));
    }

    @Test
    public void convertSingularHour()
    {
        Seconds2Words seconds2Words = new Seconds2Words(3750);
        String result = seconds2Words.convert();
        assertThat(result, is(equalTo("1 hour, 2 minutes, 30 seconds")));
    }

    @Test
    public void convertPluralHour()
    {
        Seconds2Words seconds2Words = new Seconds2Words(36750);
        String result = seconds2Words.convert();
        assertThat(result, is(equalTo("10 hours, 12 minutes, 30 seconds")));
    }

    @Test
    public void convertHourNoMinutes()
    {
        Seconds2Words seconds2Words = new Seconds2Words(3610);
        String result = seconds2Words.convert();
        assertThat(result, is(equalTo("1 hour, 10 seconds")));
    }

    public void convertSingleHourSingleMinuteSingleSecond()
    {
        Seconds2Words seconds2Words = new Seconds2Words(3661);
        String result = seconds2Words.convert();
        assertThat(result, is(equalTo("1 hour, 1 minute, 1 second")));
    }
}
