package EmailApplication;
import java.util.Scanner;

public class Email {
	
	Scanner s = new Scanner(System.in);
	
	private String firstName;
	private String lastName;
	private String Company="company1";
	private String Department;
	private String Password;
	private String alternateEmail=null;
	private int maxMailCapacity=1000;
	private int defaultpasswordlen=10;
	private String PrimaryEmail;
	
	Email()
	{
		this.firstName=setFirstName();
		this.lastName=setLastName();
		this.Department = setDepartment();
		this.Password = randomPassword(defaultpasswordlen);
		this.PrimaryEmail = String.format(this.firstName.toLowerCase()+"."+this.lastName.toLowerCase()+"@"+this.Department+"."+this.Company+".com");
	}
	
	private String setFirstName()
	{
		System.out.print("First Name: ");
		return s.nextLine();
		
	}
	
	private String setLastName()
	{
		System.out.print("Last Name: ");
		return s.nextLine();
	}

	private String setDepartment() 
	{
		System.out.print("Department Codes:\n1 Sales \n2 Development \n3 Accounting \n0 None \nEnter The Department Code:");
		int dchoice=0;
		dchoice=s.nextInt();
		switch(dchoice)
		{
			case 1:
				this.Department="sales";
				break;
			case 2:
				this.Department="development";
				break;
			case 3:
				this.Department="accounting";
				break;
			default:
				this.Department=null;
				break;
		}
		return this.Department;
	}
	
	private String randomPassword(int lenght)
	{
		String setPassword="ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890{}:;?$#@";
		char[] password = new char[lenght];
		for(int i=0;i<lenght;i++)
		{
			int rand = (int) (Math.random()*setPassword.length());
			password[i] = setPassword.charAt(rand);
		}
		return new String(password);
	}
	
//	public String toString()
//	{
//		return String.format("\n\nName: "+this.firstName+" "+this.lastName+"\nDepartment Name: "+this.Department
//				+"\nPassword: "+this.Password+"\nE-Mail: "+this.PrimaryEmail);
//	}

	public String getPassword() {
		return Password;
	}

	public void ChangePassword(String password) {
		Password = password;
	}

	public String getAlternateEmail() {
		return alternateEmail;
	}

	public void setAlternateEmail(String alternateEmail) {
		this.alternateEmail = alternateEmail;
	}
	public String showinfo()
	{
		return String.format("\n\nName: "+this.firstName+" "+this.lastName+"\nDepartment Name: "+this.Department
				+"\nE-Mail: "+this.PrimaryEmail+"\nEmail Capacity: "+this.maxMailCapacity);
	}
	

}
