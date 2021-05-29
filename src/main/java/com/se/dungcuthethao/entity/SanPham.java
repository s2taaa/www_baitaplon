package com.se.dungcuthethao.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "SanPham")
public class SanPham implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "tenSP")
	private String tenSP;
	
	@Column(name = "soLuong")
	private int soLuong;
	
	@Column(name = "donGia")
	private float donGia;
	
	@Column(name = "loaiSP")
	private String loaiSP;
	
	@Column(name = "kichThuoc")
	private String kichThuoc;
	
	@Column(name = "mauSac")
	private String mauSac;
	
	@Column(name = "xuatSu")
	private String xuatSu;
	
	@Column(name = "images")
	private String images;
	
	@ManyToOne
	@JoinColumn(name = "idNhaCungCap")
	private NhaCungCap nhaCungCap;

	public SanPham(int id, String tenSP, int soLuong, float donGia, String loaiSP, String kichThuoc, String mauSac,
			String xuatSu, String images, NhaCungCap nhaCungCap) {
		super();
		this.id = id;
		this.tenSP = tenSP;
		this.soLuong = soLuong;
		this.donGia = donGia;
		this.loaiSP = loaiSP;
		this.kichThuoc = kichThuoc;
		this.mauSac = mauSac;
		this.xuatSu = xuatSu;
		this.images = images;
		this.nhaCungCap = nhaCungCap;
	}

	public SanPham(int id, String tenSP, int soLuong, float donGia, String loaiSP, String kichThuoc, String mauSac,
			String xuatSu, String images) {
		super();
		this.id = id;
		this.tenSP = tenSP;
		this.soLuong = soLuong;
		this.donGia = donGia;
		this.loaiSP = loaiSP;
		this.kichThuoc = kichThuoc;
		this.mauSac = mauSac;
		this.xuatSu = xuatSu;
		this.images = images;
	}

	public SanPham() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTenSP() {
		return tenSP;
	}

	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public float getDonGia() {
		return donGia;
	}

	public void setDonGia(float donGia) {
		this.donGia = donGia;
	}

	public String getLoaiSP() {
		return loaiSP;
	}

	public void setLoaiSP(String loaiSP) {
		this.loaiSP = loaiSP;
	}

	public String getKichThuoc() {
		return kichThuoc;
	}

	public void setKichThuoc(String kichThuoc) {
		this.kichThuoc = kichThuoc;
	}

	public String getMauSac() {
		return mauSac;
	}

	public void setMauSac(String mauSac) {
		this.mauSac = mauSac;
	}

	public String getXuatSu() {
		return xuatSu;
	}

	public void setXuatSu(String xuatSu) {
		this.xuatSu = xuatSu;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public NhaCungCap getNhaCungCap() {
		return nhaCungCap;
	}

	public void setNhaCungCap(NhaCungCap nhaCungCap) {
		this.nhaCungCap = nhaCungCap;
	}

	@Override
	public String toString() {
		return "SanPham [id=" + id + ", tenSP=" + tenSP + ", soLuong=" + soLuong + ", donGia=" + donGia + ", loaiSP="
				+ loaiSP + ", kichThuoc=" + kichThuoc + ", mauSac=" + mauSac + ", xuatSu=" + xuatSu + ", images="
				+ images + "]";
	}
	
	
}
