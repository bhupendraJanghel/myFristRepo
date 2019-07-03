package com.Bhuppi.maven_hibernate_inheritance;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="car")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING,name="car_type")
@DiscriminatorValue("Base car")
public class Car implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="car_color")
	private String carColor;
	@Column(name="make_year")
	private String makeYear;
	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Car(String carColor, String makeYear) {
		super();
		this.carColor = carColor;
		this.makeYear = makeYear;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCarColor() {
		return carColor;
	}
	public void setCarColor(String carColor) {
		this.carColor = carColor;
	}
	public String getMakeYear() {
		return makeYear;
	}
	public void setMakeYear(String makeYear) {
		this.makeYear = makeYear;
	}
	@Override
	public String toString() {
		return "Car [id=" + id + ", carColor=" + carColor + ", makeYear=" + makeYear + "]";
	}
	
	
	

}
