package com.gmail.fomenkoc.domain;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "periodical")
public class Periodical {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String name;
	private String description;
	private Double price;
	@Lob
	private String encodedImage;

	public Periodical() {
		super();
	}

	public Periodical(String name, String description, Double price,
			String encodedImage) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
		this.encodedImage = encodedImage;
	}

	public Periodical(Integer id, String name, String description, Double price,
			String encodedImage) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.encodedImage = encodedImage;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getEncodedImage() {
		return encodedImage;
	}

	public void setEncodedImage(String encodedImage) {
		this.encodedImage = encodedImage;
	}

	@Override
	public int hashCode() {
		return Objects.hash(description, encodedImage, id, name, price);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Periodical other = (Periodical) obj;
		return Objects.equals(description, other.description)
				&& Objects.equals(encodedImage, other.encodedImage)
				&& Objects.equals(id, other.id)
				&& Objects.equals(name, other.name)
				&& Objects.equals(price, other.price);
	}

	@Override
	public String toString() {
		return "Periodical [id=" + id + ", name=" + name + ", description="
				+ description + ", price=" + price + "]";
	}

}
