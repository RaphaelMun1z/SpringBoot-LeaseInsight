package com.rm.myadmin.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_rental_history")
public class RentalHistory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private LocalDate rental_start_date;
	private LocalDate rental_end_date;
	private String payment_status;

	@ManyToOne
	@JoinColumn(name = "contract_id")
	private Contract contract;

	public RentalHistory() {

	}

	public RentalHistory(Long id, LocalDate rental_start_date, LocalDate rental_end_date, String payment_status,
			Contract contract) {
		super();
		this.id = id;
		this.rental_start_date = rental_start_date;
		this.rental_end_date = rental_end_date;
		this.payment_status = payment_status;
		this.contract = contract;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getRental_start_date() {
		return rental_start_date;
	}

	public void setRental_start_date(LocalDate rental_start_date) {
		this.rental_start_date = rental_start_date;
	}

	public LocalDate getRental_end_date() {
		return rental_end_date;
	}

	public void setRental_end_date(LocalDate rental_end_date) {
		this.rental_end_date = rental_end_date;
	}

	public String getPayment_status() {
		return payment_status;
	}

	public void setPayment_status(String payment_status) {
		this.payment_status = payment_status;
	}

	public Contract getContract() {
		return contract;
	}

	public void setContract(Contract contract) {
		this.contract = contract;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RentalHistory other = (RentalHistory) obj;
		return Objects.equals(id, other.id);
	}

}
