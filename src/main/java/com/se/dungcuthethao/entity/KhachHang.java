package com.se.dungcuthethao.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "KhachHang")
public class KhachHang implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "tenKH")
	private String tenKH;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "soDienThoai")
	private String soDienThoai;
	
	@Column(name = "loaiKH")
	private String loaiKH;
	
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "IDTaiKhoan")
	private TaiKhoan taiKhoan;

	public KhachHang(int id, String tenKH, String email, String soDienThoai, String loaiKH, TaiKhoan taiKhoan) {
		super();
		this.id = id;
		this.tenKH = tenKH;
		this.email = email;
		this.soDienThoai = soDienThoai;
		this.loaiKH = loaiKH;
		this.taiKhoan = taiKhoan;
	}
	
	public KhachHang(int id, String tenKH, String email, String soDienThoai, String loaiKH) {
		super();
		this.id = id;
		this.tenKH = tenKH;
		this.email = email;
		this.soDienThoai = soDienThoai;
		this.loaiKH = loaiKH;
	}

	public KhachHang() {
		super();
		this.tenKH = "Không xác định";
		this.email = "Chưa có email";
		this.soDienThoai = "Chưa có số điện thoại";
		this.loaiKH = "cơ bản";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTenKH() {
		return tenKH;
	}

	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getLoaiKH() {
		return loaiKH;
	}

	public void setLoaiKH(String loaiKH) {
		this.loaiKH = loaiKH;
	}

	public TaiKhoan getTaiKhoan() {
		return taiKhoan;
	}

	public void setTaiKhoan(TaiKhoan taiKhoan) {
		this.taiKhoan = taiKhoan;
	}

	@Override
	public String toString() {
		return "KhachHang [id=" + id + ", tenKH=" + tenKH + ", email=" + email + ", soDienThoai=" + soDienThoai
				+ ", loaiKH=" + loaiKH + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KhachHang other = (KhachHang) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
}
