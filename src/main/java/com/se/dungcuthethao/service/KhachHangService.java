package com.se.dungcuthethao.service;

import java.util.List;

import com.se.dungcuthethao.entity.KhachHang;


public interface KhachHangService {
	public List<KhachHang> findAdd();
	public KhachHang findById(int id);
	public void save(KhachHang khachHang);
	public void deleteById(int id);


}
