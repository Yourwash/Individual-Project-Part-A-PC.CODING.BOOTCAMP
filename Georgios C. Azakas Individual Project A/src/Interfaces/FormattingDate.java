
package Interfaces;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public interface FormattingDate {

    public static Date StringToDate(String tempDate) throws ParseException {
        //Instantiating the SimpleDateFormat class
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        //Parsing the given String to Date object
        Date date = formatter.parse(tempDate);     
        return date;
    }
}
