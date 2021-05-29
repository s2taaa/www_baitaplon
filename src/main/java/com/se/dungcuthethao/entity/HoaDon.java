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

import com.se.dungcuthethao.entity.enumEntity.PaymentMethodEnum;
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
	private int id;

	@Column(name = "orderDate")
	private LocalDate orderDate;

	@Enumerated(EnumType.STRING)
	@Column(name = "payment_menthod")
	private PaymentMethodEnum paymentMethod;

	@Column(name = "ship_adress")
	private String shipAdress;

	@Enumerated(EnumType.STRING)
	@Column(name = "status")
	private StatusEnum status;

	@Column(name = "total")
	private float total;

	@OneToMany(mappedBy = "hoaDon", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<ChiTietHoaDon> chiTietHoaDons;

	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinColumn(name = "IDKhachHang")
	private KhachHang khachHang;

	public HoaDon(int id, LocalDate orderDate, PaymentMethodEnum paymentMethod, String shipAdress, StatusEnum status,
			float total) {
		super();
		this.id = id;
		this.orderDate = orderDate;
		this.paymentMethod = paymentMethod;
		this.shipAdress = shipAdress;
		this.status = status;
		this.total = total;
	}
	
	
	public HoaDon(int id, LocalDate orderDate, PaymentMethodEnum paymentMethod, String shipAdress, StatusEnum status,
			float total, List<ChiTietHoaDon> chiTietHoaDons, KhachHang khachHang) {
		super();
		this.id = id;
		this.orderDate = orderDate;
		this.paymentMethod = paymentMethod;
		this.shipAdress = shipAdress;
		this.status = status;
		this.total = total;
		this.chiTietHoaDons = chiTietHoaDons;
		this.khachHang = khachHang;
	}


	public HoaDon() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public PaymentMethodEnum getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(PaymentMethodEnum paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getShipAdress() {
		return shipAdress;
	}

	public void setShipAdress(String shipAdress) {
		this.shipAdress = shipAdress;
	}

	public StatusEnum getStatus() {
		return status;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
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
		return "HoaDon [id=" + id + ", orderDate=" + orderDate + ", paymentMethod=" + paymentMethod + ", shipAdress="
				+ shipAdress + ", status=" + status + ", total=" + total + "]";
	}

	@PrePersist
	public void prePersist() {
		orderDate = LocalDate.now();
		status = StatusEnum.PENDING;
		sumTotal();
	}

	public Double sumTotal() {
		total = 0;
		if (!chiTietHoaDons.isEmpty()) {
			chiTietHoaDons.forEach(detail -> total += detail.tongHoaDon());
		}
		return (double) total;
	}
}
