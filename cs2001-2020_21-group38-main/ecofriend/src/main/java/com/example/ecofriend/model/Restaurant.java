package com.example.ecofriend.model;


import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity()
@Table(name = "Restaurant")
public class Restaurant implements Serializable {


	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private Long id;

	@Column(name = "Name", nullable = false, unique = true, length = 50)
	@Size(min = 5, max = 100)
	private String name;
	@Size(min = 5, max = 100)
	@Column(name = "Address", nullable = false, unique = false, length = 100)
	private String address;
	@Size(min = 10, max = 50)
	@Column(name = "Phone_No", nullable = false, unique = false, length = 100)
	private String phonenumber;

	@OneToMany(mappedBy = "restaurant", fetch = FetchType.LAZY,
			cascade = CascadeType.ALL)
	@JsonBackReference
	private Set<Donation> donationList;


	public Restaurant() {
	}

	public Restaurant(@Size(min = 5, max = 100) String name, @Size(min = 5, max = 100) String address,
			@Size(min = 10, max = 50) String phonenumber, Set<Donation> donationList) {
		super();
		this.name = name;
		this.address = address;
		this.phonenumber = phonenumber;
		this.donationList = donationList;
	}

	//getters and setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public Set<Donation> getDonationList() {
		return donationList;
	}

	public void setDonationList(Set<Donation> donationList) {
		this.donationList = donationList;
	}

	@Override
	public String toString() {
		return "Restaurant [id=" + id + ", name=" + name + ", address=" + address + ", phonenumber=" + phonenumber
				+ "]";
	}

}


