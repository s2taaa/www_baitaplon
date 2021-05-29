package com.se.dungcuthethao.service;

import java.util.List;

import com.se.dungcuthethao.entity.TaiKhoan;

public interface TaiKhoanService {
	public List<TaiKhoan> findAdd();
	public TaiKhoan findById(int id);
	public void save(TaiKhoan taiKhoan);
	public void deleteById(int id);

}
