import java.util.*;
import java.io.Console;

class AttendanceMain
{
    public static void main(String[] args)
    {
        Login l = new Login();        

        // existing data - faculty
        ArrayList<Faculty> facultyList = new ArrayList<>();
        
        String[] f1s = {"AA24","DS48"};
        Faculty f1 = new Faculty("CS/101", "sanju@123", "Sanjana","CS",f1s);
        String[] f2s = {"DB25","CT45"};
        Faculty f2 = new Faculty("CS/105", "renuka@123", "Renuka","CS",f2s);
        facultyList.add(f1);
        facultyList.add(f2);

        // student data
        ArrayList<Student> studentList = new ArrayList<>();
        
        Student s1 = new Student("22/PCSA/113", "10/05/2002", "Amina Shahana","1PG");
        Attendance s1a1 = new Attendance(20,17,3);
        Attendance s1a2 = new Attendance(22,19,3);
        Attendance s1a3 = new Attendance(15,15,0);
        s1.subjects.get(0).setAttendance(s1a1); s1.subjects.get(1).setAttendance(s1a2);  s1.subjects.get(2).setAttendance(s1a3);

        Student s2 = new Student("22/PCSA/110", "20/10/2002", "Amanda","1PG");
        Attendance s2a1 = new Attendance(20,15,5);
        Attendance s2a2 = new Attendance(22,21,1);
        Attendance s2a3 = new Attendance(15,13,2);
        s2.subjects.get(0).setAttendance(s2a1); s2.subjects.get(1).setAttendance(s2a2);  s2.subjects.get(2).setAttendance(s2a3);

        Student s3 = new Student("21/PCSA/110", "30/03/2000", "Joyce","2PG");
        Attendance s3a1 = new Attendance(20,17,3);
        Attendance s3a2 = new Attendance(22,20,2);
        s3.subjects.get(0).setAttendance(s3a1); s3.subjects.get(1).setAttendance(s3a2); 

        Student s4 = new Student("22/PCSA/105", "10/03/2002", "Renuka","1PG");
        Attendance s4a1 = new Attendance(20,17,3);
        Attendance s4a2 = new Attendance(22,19,3);
        Attendance s4a3 = new Attendance(15,10,5);
        s4.subjects.get(0).setAttendance(s4a1); s4.subjects.get(1).setAttendance(s4a2);  s4.subjects.get(2).setAttendance(s4a3);
        
        Student s5 = new Student("22/PCSA/107", "13/01/2002", "Harismitha Devi","1PG");
        Attendance s5a1 = new Attendance(20,17,3);
        Attendance s5a2 = new Attendance(22,19,3);
        Attendance s5a3 = new Attendance(15,14,1);
        s5.subjects.get(0).setAttendance(s5a1); s5.subjects.get(1).setAttendance(s5a2);  s5.subjects.get(2).setAttendance(s5a3);

        Student s6 = new Student("21/PCSA/102", "16/08/2001", "Vanisha Sonnet","2PG");
        Attendance s6a1 = new Attendance(20,17,3);
        Attendance s6a2 = new Attendance(21,19,2);
        s6.subjects.get(0).setAttendance(s6a1); s6.subjects.get(1).setAttendance(s6a2);  
            
        Student s7 = new Student("22/PCSA/102", "30/11/1999", "Sajitha","1PG");
        Attendance s7a1 = new Attendance(20,17,3);
        Attendance s7a2 = new Attendance(22,17,5);
        Attendance s7a3 = new Attendance(15,10,5);
        s7.subjects.get(0).setAttendance(s7a1); s7.subjects.get(1).setAttendance(s7a2);  s7.subjects.get(2).setAttendance(s7a3);

        Student s8 = new Student("22/PCSA/111", "13/01/2002", "Akshaya","1PG");
        Attendance s8a1 = new Attendance(20,17,3);
        Attendance s8a2 = new Attendance(22,19,3);
        Attendance s8a3 = new Attendance(15,15,0);
        s8.subjects.get(0).setAttendance(s8a1); s8.subjects.get(1).setAttendance(s8a2);  s8.subjects.get(2).setAttendance(s8a3);

        Student s9 = new Student("22/PCSA/112", "13/01/2002", "Kottiswari","1PG");
        Attendance s9a1 = new Attendance(20,19,1);
        Attendance s9a2 = new Attendance(22,20,2);
        Attendance s9a3 = new Attendance(15,15,0);
        s9.subjects.get(0).setAttendance(s9a1); s9.subjects.get(1).setAttendance(s9a2);  s9.subjects.get(2).setAttendance(s9a3);
        
        Student s10 = new Student("22/PCSA/101", "26/09/1999", "Sanjana Saju","1PG");
        Attendance s10a1 = new Attendance(20,17,3);
        Attendance s10a2 = new Attendance(22,19,3);
        Attendance s10a3 = new Attendance(15,15,0);
        s10.subjects.get(0).setAttendance(s10a1); s10.subjects.get(1).setAttendance(s10a2);  s10.subjects.get(2).setAttendance(s10a3);


        studentList.add(s1);
		studentList.add(s2);
        studentList.add(s3);
		studentList.add(s4);
        studentList.add(s5);
        studentList.add(s6);
        studentList.add(s7);
        studentList.add(s8);
        studentList.add(s9);
        studentList.add(s10);

        // ==========================================
        
        Scanner sc = new Scanner(System.in);
        int login,exit=0;

        while(exit==0){
            System.out.println("\n\n\t\t SELECT LOGIN");
            System.out.println("\t\t--------------");
            System.out.println("\t\t 1. Student Login \n\t\t 2. Faculty Login  \n\t\t 3. Exit");
            System.out.print(" Enter your Choice: ");
            login = sc.nextInt();        

            switch(login)
            {
                case 1:
                        int log1 = l.checkStudCredentials(studentList);
                        if(log1>-1)
                        {
                            int flag=0;
                            while(flag==0)
                            {
                                System.out.println("\n\n\t\t STUDENT LOGIN");
                                System.out.println("\t\t--------------");
                                System.out.println("\t\t 1. View Attendance");
                                System.out.println("\t\t 2. Send Message to Faculty");
                                System.out.println("\t\t 3. Exit");
                                System.out.print(" Enter your Choice: ");
                                int studLogin = sc.nextInt();
                                switch(studLogin)
                                {
                                    case 1:
                                        studentList.get(log1).viewAttendance();
                                        break;
                                    case 2:
                                        studentList.get(log1).sendMessage();
                                        break;
                                        
                                    default:
                                        flag=1;
                                        break;
                                }
                            }
                        }
                        else
                        {
                            System.out.println("INVALID CREDENTIALS!!");
                        }
                        break;

                case 2:                        
                        int log2 = l.checkFactCredentials(facultyList);
                        if(log2 > -1)
                        {
                            int flag=0;
                            while(flag==0)
                            {
                                System.out.println("\n\n\t\t FACULTY LOGIN");
                                System.out.println("\t\t--------------");
                                System.out.println("\t\t 1. Mark Attendance");
                                System.out.println("\t\t 2. Edit Attendance");
                                System.out.println("\t\t 3. View Attendance");
                                System.out.println("\t\t 4. View Messages");
                                System.out.println("\t\t 5. Exit");
                                System.out.print(" Enter your Choice: ");
                                int facLogin = sc.nextInt();
                                switch(facLogin)
                                {
                                    case 1:
                                        System.out.print(" Enter subject code: ");
                                        String sub1 = sc.next();
                                        facultyList.get(log2).markAttendance(sub1);
                                        break;

                                    case 2:
                                        System.out.print(" Enter subject code: ");
                                        String sub2 = sc.next();
                                        facultyList.get(log2).editAttendance(sub2);
                                        break;

                                    case 3:
                                        System.out.print(" Enter subject code: ");
                                        String sub3 = sc.next();
                                        facultyList.get(log2).viewAttendance(sub3);
                                        break;
                                    
                                    case 4:
                                        facultyList.get(log2).viewMessage();
                                        break;

                                    default:
                                        flag=1;
                                        break;
                                }
                            }
                        }
                        else
                        {
                            System.out.println("INVALID CREDENTIALS!!");
                        }
                        break;
                        
                default:
                        exit=1;
                        break;

            }
        }
    }
}