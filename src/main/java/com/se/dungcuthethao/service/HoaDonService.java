package com.se.dungcuthethao.service;

import java.util.List;

import com.se.dungcuthethao.entity.HoaDon;


public interface HoaDonService {
	public List<HoaDon> findAdd();
	public HoaDon findById(int id);
	public void save(HoaDon hoaDon);
	public void deleteById(int id);


}
