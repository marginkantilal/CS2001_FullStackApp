package com.example.ecofriend.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity()
@Table(name = "Donation")
public class Donation implements Serializable {

	private static final long serialVersionUID = -6435794314307778923L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "Description",nullable = false, length = 100)
	@Size(min = 2, max = 100)
	private String description;
	
	@Column(name = "Quantity", nullable = false, length = 10)
	private int quantity;
	
	 @ManyToOne(cascade = CascadeType.ALL)
	 @JoinColumn(name = "restaurant_Id",nullable = false)  
	private Restaurant restaurant;

    public Donation() {
	}

	public Donation(@Size(min = 2, max = 100) String description, int quantity) {
		super();
		this.description = description;
		this.quantity = quantity;
	}

	//getters and setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	@Override
	public String toString() {
		return "Donation [id=" + id + ", description=" + description + ", quantity=" + quantity + "]";
	}

}


