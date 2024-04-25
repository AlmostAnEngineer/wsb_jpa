package com.capgemini.wsb.persistence.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "address")
public class AddressEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", nullable = false)
	private Long id;

	@Column(nullable = false)
	private String city;

	@Column(nullable = false)
	private String addressLine1;

	@Column(nullable = true)
	private String addressLine2;

	@Column(nullable = false)
	private String postalCode;

	@OneToMany(mappedBy = "address", fetch = FetchType.EAGER)
	Collection<DoctorToAdress> doctorToAddress;

	public Collection<DoctorToAdress> getDoctorToAdresses() {
		return doctorToAddress;
	}

	public void setDoctorToAdresses(Collection<DoctorToAdress> doctorToAdresses) {
		this.doctorToAddress = doctorToAdresses;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

}
