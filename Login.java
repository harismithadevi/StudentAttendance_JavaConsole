import java.util.*;
import java.io.*;

class Login
{
    private String id, password;
    Login()
    {
        id = "";
        password = "";
    }
    Login(String user, String pass)
    {
        id = user;
        password = pass;
    }
    public String getId()
    {
        return this.id;
    }
    public String getPass()
    {
        return this.password;
    }
    int checkStudCredentials(ArrayList list)
    {
        Console consol = System.console();
        Scanner sc = new Scanner(System.in);

        System.out.print("\n Enter Username: ");
        String uname = sc.next();
        char[] paswd = consol.readPassword(" Enter Password: ");
        String pwd = String.valueOf(paswd);
        
        //have to search for the username,password in array of object then check :')
        for(int i=0; i < list.size();i++)
        {
            if((uname.equals(((Student)list.get(i)).getId())) && (pwd.equals(((Student)list.get(i)).getPass())))
            {
                return i; //returning only the index value
            }
        }
        return -1;
    }
    int checkFactCredentials(ArrayList list)
    {
        Console consol = System.console();
        Scanner sc = new Scanner(System.in);

        System.out.print("\n Enter Username:");
        String uname = sc.next();
        char[] paswd = consol.readPassword(" Enter Password: ");
        String pwd = String.valueOf(paswd);
        
        for(int i=0; i < list.size();i++)
        {
            //idek anymoree :')
            if((uname.equals(((Faculty)list.get(i)).getId())) && (pwd.equals(((Faculty)list.get(i)).getPass())))
            {
                return i;
            }
        }
        return -1;
    }
    public String toString()
    {
        return " "+id;
    }
}