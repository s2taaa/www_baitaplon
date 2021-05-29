package com.se.dungcuthethao.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "NhaCungCap")
public class NhaCungCap implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "tenNCC")
	private String tenNCC;
	
	@Column(name = "diaChi")
	private String diaChi;
	
	@Column(name = "soDienThoai")
	private String soDienThoai;
	
	@Column(name = "email")
	private String email;

	public NhaCungCap(int id, String tenNCC, String diaChi, String soDienThoai, String email) {
		super();
		this.id = id;
		this.tenNCC = tenNCC;
		this.diaChi = diaChi;
		this.soDienThoai = soDienThoai;
		this.email = email;
	}

	public NhaCungCap() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTenNCC() {
		return tenNCC;
	}

	public void setTenNCC(String tenNCC) {
		this.tenNCC = tenNCC;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "NhaCungCap [id=" + id + ", tenNCC=" + tenNCC + ", diaChi=" + diaChi + ", soDienThoai=" + soDienThoai
				+ ", email=" + email + "]";
	}
	
	
}
