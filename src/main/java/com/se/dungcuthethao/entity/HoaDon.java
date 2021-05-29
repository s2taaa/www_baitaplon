package com.se.dungcuthethao.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import com.se.dungcuthethao.entity.enumEntity.ThanhToan;
import com.se.dungcuthethao.entity.enumEntity.StatusEnum;

@Entity
@Table(name = "HoaDon")
public class HoaDon implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "ngayDatHang")
	private LocalDate ngayDatHang;

	@Enumerated(EnumType.STRING)
	@Column(name = "thanhToan")
	private ThanhToan thanhToan;

	@Column(name = "diaChiGiaoHang")
	private String diaChiGiaoHang;

	@Enumerated(EnumType.STRING)
	@Column(name = "trangThai")
	private StatusEnum trangThai;

	@Column(name = "tong")
	private float tong;

	@OneToMany(mappedBy = "hoaDon", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<ChiTietHoaDon> chiTietHoaDons;

	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinColumn(name = "khachHangID")
	private KhachHang khachHang;

	public HoaDon(Long id, LocalDate ngayDatHang, ThanhToan thanhToan, String diaChiGiaoHang, StatusEnum trangThai,
			float tong) {
		super();
		this.id = id;
		this.ngayDatHang = ngayDatHang;
		this.thanhToan = thanhToan;
		this.diaChiGiaoHang = diaChiGiaoHang;
		this.trangThai = trangThai;
		this.tong = tong;
	}
	


	public HoaDon(Long id, LocalDate ngayDatHang, ThanhToan thanhToan, String diaChiGiaoHang, StatusEnum trangThai,
			float tong, List<ChiTietHoaDon> chiTietHoaDons, KhachHang khachHang) {
		super();
		this.id = id;
		this.ngayDatHang = ngayDatHang;
		this.thanhToan = thanhToan;
		this.diaChiGiaoHang = diaChiGiaoHang;
		this.trangThai = trangThai;
		this.tong = tong;
		this.chiTietHoaDons = chiTietHoaDons;
		this.khachHang = khachHang;
	}



	public HoaDon() {
		super();
	}
	
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public LocalDate getNgayDatHang() {
		return ngayDatHang;
	}



	public void setNgayDatHang(LocalDate ngayDatHang) {
		this.ngayDatHang = ngayDatHang;
	}



	public ThanhToan getThanhToan() {
		return thanhToan;
	}



	public void setThanhToan(ThanhToan thanhToan) {
		this.thanhToan = thanhToan;
	}



	public String getDiaChiGiaoHang() {
		return diaChiGiaoHang;
	}



	public void setDiaChiGiaoHang(String diaChiGiaoHang) {
		this.diaChiGiaoHang = diaChiGiaoHang;
	}



	public StatusEnum getTrangThai() {
		return trangThai;
	}



	public void setTrangThai(StatusEnum trangThai) {
		this.trangThai = trangThai;
	}



	public float getTong() {
		return tong;
	}



	public void setTong(float tong) {
		this.tong = tong;
	}



	public List<ChiTietHoaDon> getChiTietHoaDons() {
		return chiTietHoaDons;
	}


	public void setChiTietHoaDons(List<ChiTietHoaDon> chiTietHoaDons) {
		this.chiTietHoaDons = chiTietHoaDons;
	}


	public KhachHang getKhachHang() {
		return khachHang;
	}


	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}


	
	@Override
	public String toString() {
		return "HoaDon [id=" + id + ", ngayDatHang=" + ngayDatHang + ", thanhToan=" + thanhToan + ", diaChiGiaoHang="
				+ diaChiGiaoHang + ", trangThai=" + trangThai + ", tong=" + tong + "]";
	}



	@PrePersist
	public void prePersist() {
		ngayDatHang = LocalDate.now();
		trangThai = StatusEnum.PENDING;
		sumTotal();
	}

	public Double sumTotal() {
		tong = 0;
		if (!chiTietHoaDons.isEmpty()) {
			chiTietHoaDons.forEach(detail -> tong += detail.tongHoaDon());
		}
		return (double) tong;
	}
}
