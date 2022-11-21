package DisplayZoom;

import entities.DataPoint;

/**
 * DataPointManager class
 */
public class DataPointManager {
    /**
     * Creates a DataPoint object with the date (month, day, year)
     * @param month The month of the calendar date - between 1-12, inclusive
     * @param day The day of the calendar date - between 1-31, inclusive (depending on month)
     * @param year The year of calendar date - greater than or equal to 1
     * @return DataPoint
     */
    public DataPoint createDataPoint(int month, int day, int year) {
        try {
            checkValidInput(month, day, year);
        } catch(IllegalArgumentException e){
            throw new IllegalArgumentException(e.getMessage());
        }
        return new DataPoint(month, day, year);
    }

    /**
     * Checks for a valid input of (month, day, year), throws an Exception for invalid dates
     * @param month Month of calendar date
     * @param day Day of calendar date
     * @param year Year of calendar date
     */
    public void checkValidInput(int month, int day, int year) {
        // raise IllegalArgumentException if month is invalid
        if (month > 12 || month < 1) {
            throw new IllegalArgumentException ("A valid calendar month must be between 1-12, inclusive");
        }

        // raise IllegalArgumentException if day is invalid
        if (day < 1 || day > 31) {
            throw new IllegalArgumentException ("A valid calendar day must be between 1-31, inclusive");
        } else if (day > 28 && month == 2) {
            throw new IllegalArgumentException ("A valid calendar day in February must be between 1-28, inclusive");
        } else if (day > 30 && (month == 4 || month == 6 || month == 9 || month == 11)) {
            throw new IllegalArgumentException ("A valid calendar day in 30-day months must be between 1-30, inclusive");
        }

        //raise IllegalArgumentException if year is invalid
        if (year < 1) {
            throw new IllegalArgumentException ("A valid calendar year must be greater than or equal to 1");
        }
    }
}
