package models;
import java.util.Date;
import java.util.ArrayList;

public class Baby {
	private String name;
	private char  gender;
	private Date birthday;
	private ArrayList<Gift> gifts;
	

	public Baby(){
		gifts = new ArrayList<Gift>();
	}

	// My constructor with all arguments
	public Baby(String name, Date birthday,char gender) {
		this.name = name;
		this.birthday = birthday;
		this.gender = gender;
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
		}
	}
	
	public String toString(){
		return name+"\n"+gender+"\n"+birthday.toString();
	}
	
	public boolean isOlder(Baby baby){
		return true;
		
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
	
	public ArrayList sort(ArrayList<Baby> babies){	
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
	
	public ArrayList sortAge(ArrayList<Baby> babies){	
		for(int i=0; i<babies.size()-1; i++){
			for(int j=i+1; j<babies.size(); j++){
				Baby s1 = babies.get(i);
				Baby s2 = babies.get(j);
				if(s1.howOld() > s2.howOld()){
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