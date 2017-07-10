package com.hibernateDemo.hibernateDemo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="alien")
public class alien {
	@Id
	private int id;
	private Name name;
	private String color;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public Name getName() {
		return name;
	}
	public void setName(Name name) {
		this.name = name;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	@Override
	public String toString() {
		return "alien [id=" + id + ", name=" + name + ", color=" + color + "]";
	}

}
