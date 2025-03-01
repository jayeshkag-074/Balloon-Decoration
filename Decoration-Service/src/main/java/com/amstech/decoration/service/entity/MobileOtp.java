package com.amstech.decoration.service.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.Date;


/**
 * The persistent class for the mobile_otp database table.
 * 
 */
@Entity
@Table(name="mobile_otp")
@NamedQuery(name="MobileOtp.findAll", query="SELECT m FROM MobileOtp m")
public class MobileOtp implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="ganrated_at")
	private Date ganratedAt;

	private String number;

	private int otp;

	public MobileOtp() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getGanratedAt() {
		return this.ganratedAt;
	}

	public void setGanratedAt(Date ganratedAt) {
		this.ganratedAt = ganratedAt;
	}

	public String getNumber() {
		return this.number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public int getOtp() {
		return this.otp;
	}

	public void setOtp(int otp) {
		this.otp = otp;
	}

}