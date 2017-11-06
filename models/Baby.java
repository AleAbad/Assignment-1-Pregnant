package models;
import java.util.Date;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.text.ParseException;


public class Baby {
	private String name;
	private char  gender;
	private Date birthday;
	private ArrayList<Gift> gifts;
	SimpleDateFormat dateFormat = new SimpleDateFormat("d/M/y H:m");


	public Baby(){
		gifts = new ArrayList<Gift>();
	}

	// My constructor with all arguments
	public Baby(String name, Date birthday,char gender) {
		this.name = name;
		this.birthday = birthday;
		this.gender = gender;
	}
	
	public Baby(String name, String birthday,char gender) {
		this.name = name;
		this.gender = gender;
			try{
				this.birthday = dateFormat.parse(birthday);
			}catch(ParseException e){
				System.out.println("Invalid date, type it again use this format (dd/MM/yyyy HH:mm)");
			}
		
	}


  // Getters and Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}
	
	public Date getBirthday(){
		return this.birthday;
	}

	public void setBirthday(Date birthday){
		this.birthday = birthday;
	}

	
	public boolean equals(Baby other) {
		if (this.name != other.name)
			return false;
		if (this.birthday != other.birthday)
			return false;

		return true;
	}
	
	public void printAll(ArrayList<Baby> babies){
		for(Baby b: babies){
			System.out.println(b);
			if(b.gifts.size()>0){
				System.out.println("-----Gifts---");
				for(Gift g: b.gifts){
				System.out.println(g);
				}
			}
			System.out.println("---------------");
		}
	}
	
	public String toString(){
		return "Name:"+name+"\n Gender:"+gender+"\n Birthday:"+dateFormat.format(birthday).toString();
	}
	
	public boolean isOlder(Baby baby){
		if(this.howOld() > baby.howOld()){
		return true;
		}else{
		return false;
		}
		
	}
	
	public int howOld(){
		Date now=new Date();
		int daysdiff=0;
		long diff = now.getTime() - birthday.getTime();
		long diffDays = diff / (24 * 60 * 60 * 1000)+1;
		 daysdiff = (int) diffDays;
		return daysdiff;
		
	}
	public int hwManyBabies(ArrayList<Baby> babies){
		return babies.size();
	}
	
	public ArrayList<Baby> sort(ArrayList<Baby> babies){	
		for(int i=0; i<babies.size()-1; i++){
			for(int j=i+1; j<babies.size(); j++){
				Baby s1 = babies.get(i);
				Baby s2 = babies.get(j);
				if(s1.getName().compareTo(s2.getName())>0){
					Baby aux = s1;
					babies.set(j,aux);
					babies.set(i, s2);
				}
				
			}
		}
		return babies;
	}
	
	public ArrayList<Baby> sortAge(ArrayList<Baby> babies){	
		for(int i=0; i<babies.size()-1; i++){
			for(int j=i+1; j<babies.size(); j++){
				Baby s1 = babies.get(i);
				Baby s2 = babies.get(j);
				if(s1.isOlder(s2)){
					Baby aux = s1;
					babies.set(j,aux);
					babies.set(i, s2);
				}
				
			}
		}
		return babies;
	}
	
	public void setGift(ArrayList<Gift> gifts){
		this.gifts = gifts;
	}
	
	public ArrayList<Gift> getGift(){
		return gifts;
	}
	
	public void addGift(Gift newgift){
		gifts.add(newgift);
	}
	
	
	

}