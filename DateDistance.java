public class DateDistance {

    public static boolean isLeapYear ( long year ) {
        return (year % 4 == 0 && year % 100 != 0 || year % 400 == 0);
    }


    public static long daysInMonth ( long year, long month ) {
        if (month == 1|| month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            return 31;
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            return 30;
        } else if (month == 2 && year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
            return 29;
        } else if (month == 2) {
            return 28;
        }
        return 0;
    }

    public static boolean validMonth ( long month ) {
        return (month >= 1 && month <= 12);
    }

    public static boolean validYear ( long year ) {
        return (year >= 1);
    }

    public static boolean validDay ( long month, long day, long year ) {
        return day >= 1 && day <= daysInMonth(year, month);
    }

    public static boolean isValidDate ( long month, long day, long year ) {
        return (validMonth(month) && validYear(year) && validDay(month, day, year));
    }

    public static boolean date0IsEarlierDate ( long month0, long day0, long year0,
        long month1, long day1, long year1 ) {
            return (year1 > year0) || (month1 > month0 && year1 == year0) || (day1 > day0 && month1 == month0 && year1 == year0);
        }

    public static long daysBetween ( long month0, long day0, long year0,
            long month1, long day1, long year1 ) {
                long dayCount = 0;
                long tempYear = year1;
                long tempMonth = month1;
                long tempDay = day1;
                if (!date0IsEarlierDate(month0, day0, year0, month1, day1, year1)) {
                    year1 = year0;
                    year0 = tempYear;
                    month1 = month0;
                    month0 = tempMonth;
                    day1 = day0;
                    day0 = tempDay;
                }
                while (month0 != month1 || day0 != day1 || year0 != year1) {
                    dayCount++;
                    if (day0 < daysInMonth(year0, month0)) {
                        day0++;
                    } else {
                        day0 = 1;
                        if (month0 == 12) {
                            month0 = 1;
                            year0++;
                        } else {
                            month0++;
                        }
                    }
                }
                return dayCount;
            }

    public static String dayOfTheWeek ( long month, long day, long year ) {
        String dayOfWeek = "";
        if (!date0IsEarlierDate(1, 1, 2018, month, day, year)) {
            if (daysBetween(1, 1, 2018, month, day, year) % 7 == 0) {
                dayOfWeek = "Monday";
            } else if (daysBetween(1, 1, 2018, month, day, year) % 7 == 1) {
                dayOfWeek = "Sunday";
            } else if (daysBetween(1, 1, 2018, month, day, year) % 7 == 2) {
                dayOfWeek = "Saturday";
            } else if (daysBetween(1, 1, 2018, month, day, year) % 7 == 3) {
                dayOfWeek = "Friday";
            } else if (daysBetween(1, 1, 2018, month, day, year) % 7 == 4) {
                dayOfWeek = "Thursday";
            } else if (daysBetween(1, 1, 2018, month, day, year) % 7 == 5) {
                dayOfWeek = "Wednesday";
            } else if (daysBetween(1, 1, 2018, month, day, year) % 7 == 6) {
                dayOfWeek = "Tuesday";
            }
        } else {
         if (daysBetween(1, 1, 2018, month, day, year) % 7 == 0) {
            dayOfWeek = "Monday";
        } else if (daysBetween(1, 1, 2018, month, day, year) % 7 == 1) {
            dayOfWeek = "Tuesday";
        } else if (daysBetween(1, 1, 2018, month, day, year) % 7 == 2) {
            dayOfWeek = "Wednesday";
        } else if (daysBetween(1, 1, 2018, month, day, year) % 7 == 3) {
            dayOfWeek = "Thursday";
        } else if (daysBetween(1, 1, 2018, month, day, year) % 7 == 4) {
            dayOfWeek = "Friday";
        } else if (daysBetween(1, 1, 2018, month, day, year) % 7 == 5) {
            dayOfWeek = "Saturday";
        } else if (daysBetween(1, 1, 2018, month, day, year) % 7 == 6) {
            dayOfWeek = "Sunday";
        }
        }
        return dayOfWeek;
    }

    public static String monthFromNumber ( long month ) {
        String monthString = "";
        if (month == 1) {
            monthString = "January";
        } else if (month == 2) {
            monthString = "February";
        } else if (month == 3) {
            monthString = "March";
        } else if (month == 4) {
            monthString = "April";
        } else if (month == 5) {
            monthString = "May";
        } else if (month == 6) {
            monthString = "June";
        } else if (month == 7) {
            monthString = "July";
        } else if (month == 8) {
            monthString = "August";
        } else if (month == 9) {
            monthString = "September";
        } else if (month == 10) {
            monthString = "October";
        }  else if (month == 11) {
            monthString = "November";
        }  else if (month == 12) {
            monthString = "December";
        }
        return monthString;
    }

    public static String longformDate ( long month, long day, long year ) {
        return dayOfTheWeek(month, day, year) + ", " + monthFromNumber(month) + " " + day + ", " + year;
    }

    public static void main ( String[] args ) {
        try {
            long month0 = Integer.parseInt(args[0]);
            long day0 = Integer.parseInt(args[1]);
            long year0 = Integer.parseInt(args[2]);
            long month1 = Integer.parseInt(args[3]);
            long day1 = Integer.parseInt(args[4]);
            long year1 = Integer.parseInt(args[5]);
            if (args.length < 6 || args.length > 6) {
                System.out.println("Usage instructions: java DateDistance <month0> <day0> <year0> <month1> <day1> <year1>");
            } else if (!isValidDate(month0, day0, year0) || !isValidDate(month1, day1, year1)) {
                System.out.println("Invalid date entered!");
            } else {
                long daysBetween = daysBetween(month0, day0, year0, month1, day1, year1);
                String longDate0 = longformDate(month0, day0, year0);
                String longDate1 = longformDate(month1, day1, year1);
                System.out.println("There are " + daysBetween + " days between " + longDate0 + " and " + longDate1 + ".");
            }
        } catch (Exception e) {
            System.out.println("Usage instructions: java DateDistance <month0> <day0> <year0> <month1> <day1> <year1>");
        }
    }
}
