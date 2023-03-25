import java.util.*;
import java.lang.String;

class Student extends Login
{
    String sname,course;
    ArrayList<Subject> subjects = new ArrayList<>();
    Student()
    {

    }
    Student(String sid, String dob, String sname, String course)
    {
        super(sid,dob);
        this.sname = sname;
        this.course = course;
        if(course=="1PG")
        {
            Subject sub1= new Subject("DB25", "Database Management",this);
            Subject sub2= new Subject("AA24", "Analysis of Alogrithms",this);
            Subject sub3= new Subject("OO24", "Object Oriented Prog",this);
            subjects.add(sub1);
            subjects.add(sub2);
            subjects.add(sub3);
        }
        else if(course=="2PG")
        {
            Subject sub1= new Subject("CT45", "Cloud Computing",this);
            Subject sub2= new Subject("DS48", "Dissertation/Project",this);
            subjects.add(sub1);
            subjects.add(sub2);
        }
    }
    String getStuCourse()
    {
        return course;
    }
    ArrayList getStuSubject()
    {
        return subjects;
    }
    void viewAttendance()
    {
        System.out.println("\n CODE | SUB_NAME \t\t\t TOTAL_DAYS | DAYS_PRESENT | DAYS_ABSENT | PERCENTAGE");
        System.out.println("--------------------------------------------------------------------------------------");
        for(Subject sb:subjects)
        {
            if(sb.att.getPercentage()<85)
            {
                System.out.println("\u001B[31m"+sb+"\u001B[0m");
            }
            else
                System.out.println(sb);
        }
    }
    void sendMessage()
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("\n Enter Subject Code: ");
        String subCode = sc.next();
        System.out.print(" Enter Date: ");
        String day = sc.next();
        System.out.print(" Enter Message: ");
        String msg = sc.next();

        String[] message = {this.getId(), day, msg};
        if (Faculty.msgDict.containsKey(subCode))
		{
            ArrayList<String[]> msgArray = Faculty.msgDict.get(subCode);
            msgArray.add(message);
            Faculty.msgDict.put(subCode,msgArray);
        }
        else
        {
            ArrayList<String[]> msgArray = new ArrayList<>();
            msgArray.add(message);
            Faculty.msgDict.put(subCode,msgArray);
        }
    }
    
}
