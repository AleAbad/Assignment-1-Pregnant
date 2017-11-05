import java.util.Date;
import java.util.ArrayList;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.text.ParseException;

import models.Baby;
import models.Gift;

public class BabyRegister{
	public static void main (String args[]){
		
		ArrayList<Baby> baby=new ArrayList<Baby>();
		ArrayList<Gift> gifts=new ArrayList<Gift>();
		Scanner scanner = new Scanner(System.in);
		SimpleDateFormat dateFormat = new SimpleDateFormat("d/M/y_H:m");
		
		System.out.println("System Baby registrer");
		System.out.println("Student: Abad Sojos Maria Alejandra");
		System.out.println("Press add to Add a Baby");
		System.out.println("Press listage to List Babies by age");
		System.out.println("Press listname to List Babies by name");
		System.out.println("Press addgift to Add gift");
		System.out.println("Press listgifts to List gifts");
		Date dateGivenGift= new Date();
		Gift gi1 =new Gift("cuna","cuna para bebe",dateGivenGift);
		gifts.add(gi1);
		Gift gi2 =new Gift("ropa","camisas para bebe",dateGivenGift);
		gifts.add(gi2);
		String myUserAsked= args[0];
		while(!myUserAsked.equalsIgnoreCase("exit")){
			switch(myUserAsked){
				case "add":
					Baby b =new Baby();
					System.out.println("what is the baby name?");
					b.setName(scanner.next());
					System.out.println("what is the baby gender F or M?");
					b.setGender(scanner.next().charAt(0));
					System.out.println("Date of Baby birthday format (dd/MM/yyyy_HH:mm)");
					Date birthday = new Date();

					boolean validDate = false;
					while(!validDate){
						try{
							String fecha=scanner.next();
							System.out.println(fecha);
							birthday = dateFormat.parse(fecha);
							validDate = true;
						}catch(ParseException e){
							System.out.println("Invalid date, type it again use this format (dd/MM/yyyy_HH:mm)");
							validDate = false;
						}
					}
					
					b.setBirthday(birthday);
					baby.add(b);
					System.out.println("the have  "+b.hwManyBabies(baby)+" babies");
				break;
				
				case "listage":
					Baby b1 =new Baby();
					b1.printAll(b1.sortAge(baby));
				break;
				
				case "listname":
					Baby b2 =new Baby();
					b2.printAll(b2.sort(baby));
				break;
				
				case "addgift":
					
					System.out.println("what is the gift name?");
					String giftName =scanner.next();
					System.out.println("Description of the gift");
					String giftDescription =scanner.next();
					System.out.println("Date of given  format (dd/MM/yyyy_HH:mm)");
					Date given = new Date();

					boolean validDateGifts = false;
					while(!validDateGifts){
						try{
							String fecha=scanner.next();
							given = dateFormat.parse(fecha);
							validDateGifts = true;
						}catch(ParseException e){
							System.out.println("Invalid date, type it again use this format (dd/MM/yyyy_HH:mm)");
							validDateGifts = false;
						}
					}
					Gift g =new Gift(giftName,giftDescription,given);
					
					gifts.add(g);
					System.out.println("the have  "+g.hwManyGifts(gifts)+" gift");
				break;
				
				case "listgifts":
					Gift g2 =new Gift();
					g2.printAll(gifts);
				break;
				
				
			}
			myUserAsked=scanner.next();
		}
		
		
		
	}
	
	
}

