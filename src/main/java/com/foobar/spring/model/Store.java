package com.foobar.spring.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.ToString;


@Entity
@Table(name="Stores")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Store {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO,generator="native")
	private int store_id;
	private String store_name;
	private String phone;
	private String email;
	private String street;
	private String city;
	private String state;
	private String zip_code;
	
	public Store()
	{
//		System.out.println("Hi this is Default ConstruCtor");
	}
	
	public Store(String store_name,String phone,String email,String street,String city,String state,String zip_code)
	{
		this.store_name = store_name;
		this.phone = phone;
		this.email = email;
		this.street =street;
		this.city = city;
		this.state = state;
		this.zip_code=zip_code;
	}
	
	public void setEmail(String newEmail)
	{
		this.email=newEmail;
	}
	
	public String toString()
	{
		StringBuilder sb  = new StringBuilder();
		sb.append("\n");
		sb.append("Store id : "+this.store_id);
		sb.append("\n");
	
		sb.append("Store name : "+this.store_name);
		sb.append("\n");
		
		sb.append("Store email : "+this.email);
		sb.append("\n");
		
		sb.append("Store phone nummber : "+this.phone);
		sb.append("\n");
		
		sb.append("Store street : "+this.street);
		sb.append("\n");
		
		sb.append("Store city : "+this.city);
		sb.append("\n");
		
		sb.append("Store state : "+this.state);
		sb.append("\n");
		
		sb.append("Store zip code : "+this.zip_code);
		sb.append("\n");
		
		return sb.toString();
	}
}
