package com.gmail.fomenkoc.domain;

import java.sql.Date;
import java.util.Objects;

public class Bucket {

	private Integer id;
	private User user;
	private Periodical periodical;
	private Date purchaseDate;

	public Bucket() {
		super();
	}

	public Bucket(User user, Periodical periodical, Date purchaseDate) {
		super();
		this.user = user;
		this.periodical = periodical;
		this.purchaseDate = purchaseDate;
	}

	public Bucket(Integer id, User user, Periodical periodical,
			Date purchaseDate) {
		super();
		this.id = id;
		this.user = user;
		this.periodical = periodical;
		this.purchaseDate = purchaseDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Periodical getPeriodical() {
		return periodical;
	}

	public void setPeriodical(Periodical periodical) {
		this.periodical = periodical;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, periodical, purchaseDate, user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bucket other = (Bucket) obj;
		return Objects.equals(id, other.id)
				&& Objects.equals(periodical, other.periodical)
				&& Objects.equals(purchaseDate, other.purchaseDate)
				&& Objects.equals(user, other.user);
	}

	@Override
	public String toString() {
		return "Bucket [id=" + id + ", user=" + user + ", periodical="
				+ periodical + ", purchaseDate=" + purchaseDate + "]";
	}

}
