/*This is backend code of a password generator software.
 * encoding and decoding algorithm is developed by me(SUBHAJIT DAS).
 * The main purpose of this code is to generate a password according  to the  data a user can easily remember.
 * I had free time so I was playing with java code.:)  */


package test;
import java.util.Scanner;
import java.util.Random;


public class PasswordGenetr {

	public static void main(String[] args) {
		System.out.println("::::PASSWORD GENERATOR::::");
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("\nEnter your name");
		String nam=sc.nextLine();
		System.out.println("\nEnter your date of birth/car no (last 4 digit)/any 4 digit no that you can remember well");
		int num=sc.nextInt();
		
		System.out.println("Enter the choice::");
		System.out.println("Password Strength::\n1.Easy\n2.Strong");
		int ch=sc.nextInt();
		//userInfo();
		
		
		Generate ob=new Generate();
		
		switch(ch)
		{
		case 1:String password=ob.Easytype(nam,num);
				System.out.println("Your password is:"+password);
				break;
				
		case 2: System.out.println("\nAddition Informaion");
				System.out.println("\nEnter a special character");
				char spchar=sc.next().charAt(0);
				userInfo();
				String passwordS=ob.Strongtype(nam,num,spchar);
				System.out.println("your password is:"+passwordS);
				break;
				
				
				
		default:System.out.println("Wrong input (enter the option which is given above) ");
			
		}
		
	}

//method to gathering information
	static void userInfo()
	{
		Scanner scc=new Scanner(System.in);
		System.out.println("Enter your pet name");
		String pnam=scc.nextLine();
		
	}
}

//class to perform/generate  password
class Generate
{
	
	int sum=0;
	String pass;
	Random rand=new Random();//random class for random number(in a range)
	//for easy type password creating :::
	String Easytype(String num,int digit)
	{
		//encoding String part
		for(int i=0;i<num.length();i++)
			
		{
			if(num.charAt(i)=='a'||num.charAt(i)=='s'||num.charAt(i)=='i'||num.charAt(i)=='t'||num.charAt(i)=='A'||num.charAt(i)=='S'||num.charAt(i)=='I')
			{
				
				num=num.replace('a','@');
				num=num.replace('A','@');
				num=num.replace('s','$');
				num=num.replace('S','$');
				num=num.replace('i','!');
				num=num.replace('I', '!');
				num=num.replace('t','+');
				num=num.replace('T','+');
			}
		}
			//encoding digit part
			for(int i=1;i<=2;i++)
			{
				int r=digit%10;
				digit=digit/10;
				sum=sum+r;
			}
			pass=num+sum;
			
		
		
		return (pass);
	}
	
//for Strong type password creating
	String Strongtype(String num,int digit,char schar)
	{
		//encoding String part
		for(int i=0;i<num.length();i++)
					
			{
				if(num.charAt(i)=='a'||num.charAt(i)=='s'||num.charAt(i)=='i'||num.charAt(i)=='t'||num.charAt(i)=='A'||num.charAt(i)=='S'||num.charAt(i)=='I')
				{
						num=num.replace('a','@');
						num=num.replace('A','@');
						num=num.replace('s','$');
						num=num.replace('S','$');
						num=num.replace('i','!');
						num=num.replace('I', '!');
						num=num.replace('t','+');
						num=num.replace('T','+');
				}
			}
		//encoding digit part
		for(int i=1;i<=2;i++)
		{
			int r=digit%10;
			digit=digit/10;
			sum=sum+r;
		}
	
		//encoding special character
		int value=schar;
		
		int randNumber=(int)getRandomNumber(value,sum);
		
		//concatinating password
		pass=num+randNumber;
		
		return (pass);
	}
	
	//to get a random number 
	double getRandomNumber(double max,double min)
	{
		double x=(int)(Math.random()*((max-min)+1))+min;
		return x;
	}
	
	
}