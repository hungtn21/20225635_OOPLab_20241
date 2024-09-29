import java.util.Scanner;
public class DaysOfMonth {
    public static boolean isLeapYear(int year)
    {
        if (year%4==0) {
            if (year % 100 == 0) {
                return (year % 400 == 0);
            }
            else {
                return true;
            }
        }
        else {
            return false;
        }
    }

    public static int getDaysOfMonth(String month, int year) {
        month=month.toLowerCase();
        switch (month) {
            case "january":
            case "jan.":
            case "jan":
            case "1":
                return 31;
            case "february":
            case "feb.":
            case "feb":
            case "2":
                return isLeapYear(year) ? 29 : 28;
            case "march":
            case "mar.":
            case "mar":
            case "3":
                return 31;
            case "april":
            case "apr.":
            case "apr":
            case "4":
                return 30;
            case "may":
            case "5":
                return 31;
            case "june":
            case "jun.":
            case "jun":
            case "6":
                return 30;
            case "july":
            case "jul.":
            case "jul":
            case "7":
                return 31;
            case "august":
            case "aug.":
            case "aug":
            case "8":
                return 31;
            case "september":
            case "sep.":
            case "sep":
            case "9":
                return 30;
            case "october":
            case "oct.":
            case "oct":
            case "10":
                return 31;
            case "november":
            case "nov.":
            case "nov":
            case "11":
                return 30;
            case "december":
            case "dec.":
            case "dec":
            case "12":
                return 31;
            default:
                return -1; // Invalid month
        }
    }

    public static String getValidMonth(Scanner scanner) {
        String month = "";
        while (true) {
            System.out.print("Enter a month (full name, abbreviation, or number): ");
            month = scanner.next();
            int days = getDaysOfMonth(month, 2000);
            if (days != -1) {
                break;
            } else {
                System.out.println("Invalid month. Please try again.");
            }
        }
        return month;
    }

    public static int getValidYear(Scanner scanner) {
        int year = -1;
        while (year < 0) {
            System.out.print("Enter a valid year (positive number): ");
            if (scanner.hasNextInt()) {
                year = scanner.nextInt();
                if (year < 0) {
                    System.out.println("Year cannot be negative.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid year.");
                scanner.next();
            }
        }
        return year;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get valid month and year from the user
        String month = getValidMonth(scanner);
        int year = getValidYear(scanner);

        // Get number of days in the month
        int days = getDaysOfMonth(month, year);

        System.out.println("Number of days in " + month + " " + year + ": " + days);
        scanner.close();
    }

}