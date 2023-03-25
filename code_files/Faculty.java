import java.util.ArrayList;
import java.util.*;

class Faculty extends Login
{
    String fname,dept;
    String[] subjects = new String[3];
    public static Map<String, ArrayList<String[]>> msgDict = new HashMap<>();
    Faculty()
    {

    }
    Faculty(String fid, String pass, String fname, String dept)
    {
        super(fid,pass);
        this.fname = fname;
        this.dept = dept;
    }
    Faculty(String fid, String pass, String fname, String dept,String[] subjects)
    {
        super(fid,pass);
        this.fname = fname;
        this.dept = dept;
        this.subjects = subjects;
    }
    String getDept()
    {
        return dept;
    }
    
    void markAttendance(String subCode)
    {
        int flag=0;
        Scanner sc= new Scanner(System.in);
        
        for(String sub : subjects) //search for the subject in faculty's subject array
        {
            System.out.println("subCode: "+subCode+" | sub: "+sub);
            if(sub.equals(subCode))
            {
                flag=1;
                System.out.println("MARKING ATTENDANCE FOR "+subCode);

                if(Subject.subStudDict.get(subCode)!=null) //get the students list from dictionary
                {
                    ArrayList<Student> stList = new ArrayList<>();
                    stList = Subject.subStudDict.get(subCode);
                    for(Student s : stList) //traversing though all student from student list
                    {
                        for(Subject sb: s.subjects) // searching the subcode in student's subject array
                        {
                            if(sb.getSubCode().equals(subCode)) //finding the subject code from student list
                            {
                                System.out.print(s+" : ");
                                int attend;
                                try{
                                    attend = sc.nextInt();
                                    if(attend!=1 || attend!=0)
                                    {
                                        throw new AttendanceValueException(); //userdefined exception
                                    }
                                    else{
                                        sb.att.totalDays++;
                                        if(attend==1)
                                        {
                                            sb.att.present++;
                                        }
                                        else if(attend==0)
                                        {
                                            sb.att.absent++;
                                        }
                                    }
                                }
                                catch(AttendanceValueException e)
                                {
                                    System.out.println("Value must be 1 or 0..");
                                }                                                       
                            }
                        }                        
                    }
                }
                else
                {
                    System.out.println("Array List is null..");
                }
                break;
            }
        }
        if(flag==0)
        {
            System.out.println("--Incorrect Subject Code!--");
        }
    }
    void editAttendance(String subCode)
    {
        int flag=0;
        Scanner sc= new Scanner(System.in);
        for(String sub : subjects) 
        {
            System.out.println("subCode: "+subCode+" | sub: "+sub);
            if(sub.equals(subCode))
            {
                flag=1;
                if(Subject.subStudDict.get(subCode)!=null)
                {
                    ArrayList<Student> stList = new ArrayList<>();
                    stList = Subject.subStudDict.get(subCode);
                    System.out.print(" Enter student id: ");
                    String stId = sc.next();
                    for(Student s : stList)
                    {
                        if(stId.equals(s.getId()))
                        {
                            for(Subject sb: s.subjects)
                            {
                                if(sb.getSubCode().equals(subCode))
                                {
                                    System.out.print(s+" : ");
                                    try{
                                        int attend = sc.nextInt();
                                        if(attend!=1 || attend!=0)
                                        {
                                            throw new AttendanceValueException(); //userdefined exception
                                        }
                                        else{
                                            sb.att.totalDays++;
                                            if(attend==1)
                                            {
                                                sb.att.present++;
                                                sb.att.absent--;
                                            }
                                            else if(attend==0)
                                            {
                                                sb.att.absent++;
                                                sb.att.present--;
                                            }
                                        }                                        
                                    }
                                    catch(AttendanceValueException e)
                                    {
                                        System.out.println("Value must be 1 or 0..");
                                    }
                                }
                            }
                            break;                    
                        }
                        else
                        {
                            System.out.println("\t --Incorrect Student ID!--");
                        }
                    }
                }
                else
                {
                    System.out.println("\n Student List is empty...");
                }
                break;
            }
        }
        if(flag==0)
        {
            System.out.println("\t --Incorrect Subject Code!--");
        }
    }
    
    void viewAttendance(String subCode)
    {
        int flag=0;
        for(String sub : subjects) 
        {
            if(sub.equals(subCode))
            {
                flag=1;
                System.out.println("\n REG.NO \t\t TOTAL_DAYS | DAYS PRESENT | DAYS ABSENT | PERCENTAGE");
                System.out.println("--------------------------------------------------------------------------------------");
                if(Subject.subStudDict.get(subCode)!=null)
                {
                    ArrayList<Student> stList = new ArrayList<>();
                    stList = Subject.subStudDict.get(subCode);
                    for(Student s : stList)
                    {
                        for(Subject sb: s.subjects) 
                        {
                            if(sb.getSubCode().equals(subCode))
                            {
                                if(sb.att.getPercentage()<85)
                                {
                                    System.out.println("\u001B[31m"+s+" \t\t "+sb.getAttendance()+"\u001B[0m");
                                }
                                else
                                    System.out.println(s+" \t\t "+sb.getAttendance());
                            }
                        }                        
                    }
                }
                else
                {
                    System.out.println(" Array List is null..");
                }
                break;
            }
        }
        if(flag==0)
        {
            System.out.println("--Incorrect Subject Code!--");
        }
        
    }
    void viewMessage()
    {
        System.out.println(" MESSAGES: ");
        for(String sub : subjects) //search for the subject in faculty's subject array
        {
            System.out.println("\n Subject: "+sub);
            if(msgDict.get(sub)!=null) //get msg from dictionary subcode wise
            {
                ArrayList<String[]> msgList = new ArrayList<>();
                msgList = msgDict.get(sub);
                for(String[] m : msgList) //traversing though all messages from msg list
                {
                    System.out.println("\t Reg.no: "+m[0]+ "  Day: "+m[1]+ "  Message: "+m[2]);
                }
            }
            else
            {
                System.out.println("\t --- Message Box is Empty... ---");
            }
        }
    }
    
}

class AttendanceValueException extends Exception
{

}