package logbookapplication;

import java.util.Scanner;

public class LogBookApplication {

    public static void main(String[] args) {
        int wish=0, day=0,month = 0,year=0, entries=0; 
       
        Scanner input = new Scanner(System.in);
      
	System.out.println("\t\t\t    LOGBOOK APPLICATION");
        Instructions();
	System.out.println("\n\n\t\t\t\t    COFFEE SHOP");
        System.out.print("\n\t What do you Want to?"
                + "\n\t Enter '1' for Test 1    "
                + "\n\t Enter '2' for Test 2    "
                + "\n\t Enter '3' for Test 3    "
                + "\n\t Enter '4' for Test 4    "
                + "\n\t Enter '5' for Test 5    "
                + "\n\t Enter '6' to Exit. \n"
                + "\n Enter:   ");
        wish =input.nextInt();
        while(wish>0 && wish <=6 )
        {
            if (wish==1 )
            {
                System.out.println("\n\t Test 1  "
                + "\n\t             This tests the constructor, month, year, and daysInMonth Operations. \n");
                
                System.out.print("Enter month:  ");
                month = input.nextInt();
                System.out.print("Enter year:  ");
                year = input.nextInt();
                //Coffee intake for january,2002

                LogBook Coffee = new LogBook(month,year);
                //Record entries for 1st and 15th january,2002
                Coffee.PutEntry(1, 5);
                Coffee.PutEntry(15, 2);

                //output the Logbook entries
                System.out.println("Month/Year : "+Coffee.GetMonth()+" / " + Coffee.GetYear() );
                for (day = 1; day<=Coffee.DaysInMonth() ; day++)
                {
                    System.out.println(day + " : " + Coffee.GetEntry(day));
                }
        
                System.out.print("\n\n\t *-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n"
                                + "\t *-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
            }
            else if (wish==2)
            {
                int entry=0;
                System.out.println("\n\t Test 2    'Coffee Shop : by default entries'"
                            + "\n\t             This test also uses PutEntry and GetEntry Methods.  \n");
                System.out.println("Year : 2020 , month : 9 ");
                LogBook Coffee = new LogBook(9,2020);
                System.out.print("\n\t Enter '1' to Record entries for the first and fifteenth of the month"
                        + "\n\t Enter '2' to Record entries for the first and last day of the month "
                        + "\n\t Enter '3' to Record entries for all the Fridays in the month"
                        + "\n\t Enter '4' to Change the entry for the first day"
                        + "\n Enter:    ");
                int record = input.nextInt();
                if (record==1)
                {
                    System.out.println("\n Record entries for the first and fifteenth of the month: ");
                    System.out.print(" Date: 1-9-2020 ,     Entry: ");
                    entry = input.nextInt();
                    Coffee.PutEntry(1,entry);
                    System.out.print("\n Date: 15-9-2020 ,     Entry: ");
                    entry = input.nextInt();
                    Coffee.PutEntry(15,entry);
                }
                else if (record==2)
                {
                    System.out.println("\n Record entries for the first and last day of the month: ");
                    System.out.print(" Date: 1-9-2020 ,     Entry: ");
                    entry = input.nextInt();
                    Coffee.PutEntry(1,entry);
                    System.out.print("\n Date: 30-9-2020 ,     Entry: ");
                    entry = input.nextInt();
                    Coffee.PutEntry(30,entry);
                }
                else if (record==3)
                {
                    System.out.println("\n Record entries for all the Fridays in the month: ");
                    System.out.print(" Date: 4-9-2020 ,     Entry: ");
                    entry = input.nextInt();
                    Coffee.PutEntry(4,entry);
                    System.out.print("\n Date: 11-9-2020 ,     Entry: ");
                    entry = input.nextInt();
                    Coffee.PutEntry(11,entry);
                    System.out.print("\n Date: 18-9-2020 ,     Entry: ");
                    entry = input.nextInt();
                    Coffee.PutEntry(18,entry);
                    System.out.print("\n Date: 25-9-2020 ,     Entry: ");
                    entry = input.nextInt();
                    Coffee.PutEntry(25,entry);
                }
                else if (record==4)
                {
                    System.out.println("\n Change the entry for the first day: ");
                    System.out.print(" Date: 1-9-2020 ,     Entry: ");
                    entry = input.nextInt();
                    Coffee.PutEntry(1,entry);
                }
                Coffee.DisplayCalendar();
                System.out.print("\n\n\t *-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n"
                                + "\t *-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
                
            }
            else if (wish==3)
            {
                int answer=0;
                System.out.println("\n\t Test 3    'Coffee Shop :  by user input entries'"
                + "\n\t             This test uses displayCalendar operation.   \n ");
                
                System.out.print("\n\t What do you Want to?"
                + "\n\t Enter '1' to make entries "
                + "\n\t Enter '2' to see calendar"
                + "\n Enter:   ");
                answer = input.nextInt();
                System.out.print("\n Year:     ");
                year = input.nextInt();

                System.out.print(" Month:     ");
                month = input.nextInt();

                LogBook r = new LogBook(month,year);
                
                while (answer == 1)
                {
                    System.out.print("\n\t How many entries do you wnt to enter( no. of days)?"
                        + "\n Enter:   ");
                    int ans =input.nextInt();
                    for (int i =1;i<=ans;i++)
                    {
                        System.out.print("\n"+i+" Day:       ");
                        day = input.nextInt();
                        while (day<=0 || day>31)
                        {
                            System.out.println("Invalid day... Enter Again..day must be in between 1 and 31 (1-31)");
                            System.out.print("\n"+i+" Day:       ");
                            day = input.nextInt();
                        }
                        System.out.print("  Entries:     ");
                        entries = input.nextInt();
                        r.PutEntry(day, entries);
                    }
                    System.out.println("\n\t"+ans+" no. of Entries are saved in the logbook calendar. \n");
                    System.out.print("\n\n\t *-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
                    System.out.print("\n\t What do you Want to?"
                        + "\n\t Enter '1' to make entries "
                        + "\n\t Enter '2' to see calendar"
                        + "\n\t Enter '3' to back"
                        + "\n Enter:   ");
                    answer=input.nextInt();
                }

                while (answer==2)
                {
                    System.out.print("\n\n\t CALENDAR");

                    r.DisplayCalendar();


                    System.out.print("\n\n\t *-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n"
                            + "\t *-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");

                    System.out.print("\n\t What do you Want to?"
                        + "\n\t Enter '1' to make entries "
                        + "\n\t Enter '2' to see calendar"
                        + "\n\t Enter '3' to back"
                        + "\n Enter:   ");
                    answer=input.nextInt();

                    if (answer==2)
                    {
                        System.out.print("\n\n\t would you like to see Calendar for another month and year?"
                            + "\n\t If 'yes', enter 'y'"
                            + "\n\t If 'no', enter 'n'"
                            + "\n Enter:   ");
                        String choice =input.next();
                        while (choice.equalsIgnoreCase("Y"))
                        {
                             System.out.print("\n Year:     ");
                                year = input.nextInt();

                                System.out.print(" Month:     ");
                                month = input.nextInt();

                                LogBook obj = new LogBook(month,year);
                                obj.DisplayCalendar();
                                
                                System.out.print("\n\n\t would you like to see Calendar for another month and year?"
                                        + "\n\t If 'yes', enter 'y'"
                                        + "\n\t If 'no', enter 'n'"
                                        + "\n Enter:   ");
                                        choice =input.next();
                        }
                    }
                }
                System.out.print("\n\n\t *-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n"
                                + "\t *-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
            }
            else if (wish==4)
            {
                 System.out.println("\n\t Test 4    'Coffee Shop :  by user default entries'"
                + "\n\t             This test uses method overloading and put entry for todays...current day.   \n");
                 
                LogBook obj = new LogBook();
                System.out.print("Entry:    ");
                int entry = input.nextInt();
                obj.PutEntry(entry);              
                obj.DisplayCalendar();
                
                System.out.print("\n\n\t *-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n"
                                + "\t *-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
            }
            else if  (wish==5)
            {
                System.out.println("\n\t Test 5    'Coffee Shop :  by user input entries'"
                + "\n\t             This test uses plus operation.  \n");
                
                System.out.println("\n\t By default month: 9 , year 2002"
                        + "\n\t The entries in logbook logDay100 are equal to ( 100 * day ) "
                        + "\n\t and the entries in logbook logDay200 are equal to ( 200 * day )\n");
                LogBook citySales = new LogBook(9, 2002); // City sales
                LogBook suburbSales = new LogBook(9, 2002);     // Suburban sales
                LogBook salesTotals = new LogBook(9, 2002); // Combined sales for September 2002
                for (int i=1;i<=citySales.DaysInMonth();i++)  //filling the entries
                {
                    citySales.PutEntry(i, i*100);
                    suburbSales.PutEntry(i, i*200);
                }
                salesTotals.Plus(citySales,suburbSales,salesTotals) ;

                salesTotals.DisplayCalendar( );
                
                System.out.print("\n\n\t *-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n"
                        + "\t *-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
            }
            else if (wish==6)
            {
                
                System.out.println("\n\n\t THANK YOU!");
                System.out.print("\n\n\t *-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n"
                                + "\t *-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
                break;
            }
            System.out.print("\n\t What do you Want to?"
                + "\n\t Enter '1' for Test 1    "
                + "\n\t Enter '2' for Test 2    "
                + "\n\t Enter '3' for Test 3    "
                + "\n\t Enter '4' for Test 4    "
                + "\n\t Enter '5' for Test 5    "
                + "\n\t Enter '6' to Exit. \n"
                + "\n Enter:   ");
        wish =input.nextInt();
        }           
    }
    static void Instructions()
        {
            System.out.println("\t\t\t\t\t Instructions");
            System.out.println("    ._____________________________________________________________________________________________.");
            System.out.println("    |    Test       |          Methods          |             How it works?                       |");
            System.out.println("    |_____________________________________________________________________________________________|");
            System.out.println("    |    Test 1     |  LogBook(month,year)      |   Enter 1...it will ask you to enter month      |"
                           + "\n    |               |  GetMonth(),GetYear()     |  and year and gives you the number of days      |"
                           + "\n    |               |  DaysInMonth()            |  along entries... If the user enters invalid    |"
                           + "\n    |               |                           |  month,then month and year would be set to      |"
                           + "\n    |               |                           |  default( to cureent month & year)              |");
            System.out.println("    |_____________________________________________________________________________________________|");
            System.out.println("    |    Test 2     |  PutEntry(day,value)      |   Enter 2... it will show you four options      |"
                           + "\n    |               |  GetEntry(day)            | to record the entries on specific days of month |");
            System.out.println("    |_____________________________________________________________________________________________|");
            System.out.println("    |    Test 3     |  DisplayCalendar()        |   Enter 3... it will show you two options:      |"
                           + "\n    |               |                           |   1. to make entry... 2.to see calendar         |");
            System.out.println("    |_____________________________________________________________________________________________|");
            System.out.println("    |    Test 4     |  Method Overloading:      |   Enter 4... it will ask you to enter the value |"
                           + "\n    |               |  LogBook( )               |  that wil be stored for todays'date.            |"
                           + "\n    |               |  PutEntry(value)          |                                                 |");
            System.out.println("    |_____________________________________________________________________________________________|");
            System.out.println("    |    Test 5     |  Plus( )                  |  Enter 5... it will show u the plus operation   |"
                           + "\n    |               |                           | for default entries logday*100 and logday*200...|"
                           + "\n    |               |                           |   and will dipslay the combined calendar        |");
            System.out.println("    |_____________________________________________________________________________________________|");
        }  
    
           
}
