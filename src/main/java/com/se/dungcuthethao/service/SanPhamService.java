package com.se.dungcuthethao.service;

import java.util.List;

import com.se.dungcuthethao.entity.SanPham;

public interface SanPhamService {
	public List<SanPham> findAdd();
	public SanPham findById(int id);
	public void save(SanPham sanPham);
	public void deleteById(int id);
}
