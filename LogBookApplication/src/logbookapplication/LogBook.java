package logbookapplication;

import java.util.*;

class LogBook
{
    //Data Members
    private int LogYear, LogMonth; //
    private int [ ] Entry = new int[31]; //aray of logbook entries
    private GregorianCalendar LogCalendar; //Java's built-in class of calendar
    
    //Constructor
    
    LogBook ( int month, int year)      //creates logBook
    {
        int i;  //loop counter
        // Verify that a valid month value was entered
        
        if (month>0 && month<=12)
        {
            LogCalendar = new GregorianCalendar(year, month+1, 1);
            LogMonth = month;
            LogYear = year;
        }
        // If not, setup logbook for today’s date
        else {
            System.out.println("Invalid month is entered... "+"Set to Default month");
        
            LogCalendar=new GregorianCalendar();
            LogYear=LogCalendar.get(Calendar.YEAR);
            LogMonth=LogCalendar.get(Calendar.MONTH)+1;
        }
        for (i=0;i<31;i++)
        {
            Entry[i]=0;
        }
    }

    
    //LogBook marketing operations /methods
    public void PutEntry( int day, int value )      //store entry for a day
    {
        if (day>0 && day<=DaysInMonth())
        {
            Entry[day-1]=value;
        }
    }
    
    public int GetEntry(int day)       //return entry for a day
    {
        int entry=0;
        if (day>0 && day<=DaysInMonth())
        {
            entry =  Entry[day-1];
        }
        else 
        {
            System.out.println("    Invalid date    ");
        }
        return entry;
    }
    
    //LogBook general Options
    public int GetMonth()    //return year
    {
        return LogMonth;
    }
    
    public int GetYear()    //return year
    {
        return LogYear;
    }
    
    public int DaysInMonth()    //return Number of Days in Month
    {
        int Days=0;
        int [] DaysPerMonth = {31,28,31,30,31,30,31,31,30,31,30,31}; 
        if (LogMonth!=2)       //if month is other than of febuary
        {
            Days=DaysPerMonth[LogMonth-1];
        }
        // we can also usee leapYear() method to check directly whether the year is leap or not
        else if (LogMonth==2)      //[f month is of febuary
        {
            if ((LogYear % 400 ==0 ) || ((LogYear % 4 == 0) && (LogYear % 100 != 0))) 
            {
                Days = 29;
            }
            else 
            {
                Days = 28;
            }
        }
        return Days;
    }
    
    private Boolean LeapYear()  //method to check whether the year is leap or not
    {
        return ( LogCalendar.isLeapYear(LogYear));
    }
    
    int DaysOfWeek(int day)
    {
        LogCalendar.set(LogYear,LogMonth-1,day);
        return (LogCalendar.get(Calendar.DAY_OF_WEEK)-1);
    }
    
    void DisplayCalendar()
    {
        
        System.out.println("\n");
        System.out.println("Date:"+"    "+LogMonth +"  /   "+LogYear+"\n\n");
        System.out.println("Sun"+"\t"+"Mon"+"\t"+"Tue"+"\t"+"Wed"+"\t"+"Thu"+"\t"+"Fri"+"\t"+"Sat");
        for (int i=0;i<DaysOfWeek(1);i++)
        {
            System.out.print(" \t");
        }
        for (int j=1;j<=DaysInMonth();j++)
        {
            System.out.print(j+" "+GetEntry(j)+"\t");
            if (DaysOfWeek(j+1)==0)
            {
                System.out.println();
            } 
        }
    }
    public void putEntry ( int value )
    {

        if( (LogYear==LogCalendar.get(Calendar.YEAR)) && ( LogMonth==LogCalendar.get(Calendar.MONTH)))

        {

        int x=LogCalendar.get(Calendar.DAY_OF_WEEK)-1;

        Entry[x]=value;
        }
    }
    //TEST:4
    public LogBook()
    {
        LogCalendar=new GregorianCalendar();
        LogYear=LogCalendar.get(Calendar.YEAR);
        LogMonth=LogCalendar.get(Calendar.MONTH)+1;
    }
    //record entry for today
    public void PutEntry ( int value )
    {
        
        if(LogYear==LogCalendar.get(Calendar.YEAR) && LogMonth==LogCalendar.get(Calendar.MONTH)+1)
        {
           int x=LogCalendar.get(Calendar.DAY_OF_WEEK)+2;
            Entry[x]=value;
            System.out.println("\n\t\t Current Month"
                + "\n\t\t Record entry for today "
                + (LogCalendar.get(Calendar.DAY_OF_WEEK)+3));
        }
    }
    public void Plus(LogBook obj1,LogBook obj2,LogBook obj3)
    {
        int entry =0 ;
        for (int i=1;i<=obj1.DaysInMonth();i++)
        {
            entry = obj1.GetEntry(i)+ obj2.GetEntry(i);
            obj3.PutEntry( i, entry );
        }
    }
    
        
}


		