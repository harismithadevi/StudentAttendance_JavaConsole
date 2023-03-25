import java.util.*;

class Subject
{
	private String scode,sname;
	Attendance att = new Attendance();
	public static Map<String, ArrayList<Student>> subStudDict = new HashMap<>();

	Subject(String scode,String sname)
	{
		this.scode = scode;
		this.sname = sname;
	}
	Subject(String scode,String sname,Student st)
	{
		this.scode = scode;
		this.sname = sname;
		
		if (subStudDict.containsKey(scode))
		{
			ArrayList<Student> stuList = subStudDict.get(scode);
			stuList.add(st);
			subStudDict.put(scode, stuList);
		}
		else{
			ArrayList<Student> stuList = new ArrayList<>();
			stuList.add(st);
			subStudDict.put(scode, stuList);
		}
	}
	
	String getSubCode()
	{
		return scode;
	}
	void setAttendance(Attendance att)
	{
		this.att = att;
	}
	Attendance getAttendance()
	{
		return att;
	}
	public String toString()
	{
		return " "+scode+" | "+sname+" \t\t\t "+att;
	}

	
}