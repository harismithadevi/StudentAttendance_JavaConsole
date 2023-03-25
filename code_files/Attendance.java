import java.util.*;
class Attendance
{
    //Composition - Attendance cannot exist without Subject
    public int totalDays, present, absent;
    float percentage;
    
    Attendance()
    {
        totalDays = 0;
        present = 0;
        absent = 0;
        percentage = 0;
    }
    Attendance(int totalDays, int present, int absent)
    {
        this.totalDays = totalDays;
        this.present = present;
        this.absent = absent;
        this.percentage = 0;     
    }
    float getPercentage()
    {
        percentage = ((float)present/totalDays)*100;
        return percentage;
    }
    public String toString()
    {
        return ""+totalDays+"\t\t"+present+"\t\t"+absent+"\t\t"+getPercentage()+"%";
    }
}