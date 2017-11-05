package models;
import java.util.Date;
import java.util.ArrayList;


public class Gift{
	
	private String name;
	private String description;
	private Date given;
	
	public Gift(){
		
	}
	
	public Gift(String name,String  description,Date given){
		this.name=name;
		this.description=description;
		this.given=given;
	}

	// Getters and Setters
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name=name;
	}
	
	public String getDescription(){
		return description;
	}
	
	public void setDescription(String description){
		this.description=description;
	}
	
	public Date getGiven(){
		return given;
	}
	
	public void setGiven(Date given){
		this.given=given;
	}
	public void printAll(ArrayList<Gift> gifts){
		for(Gift g: gifts){
			System.out.println(g);
		}
	}
	public String toString(){
		return name+"\n"+description+"\n"+given.toString();
	}
	public int hwManyGifts(ArrayList<Gift> gifts){
		return gifts.size();
	}

}