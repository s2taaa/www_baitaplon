package com.se.dungcuthethao.service;

import java.util.List;

import com.se.dungcuthethao.entity.NhaCungCap;


public interface NhaCungCapService {
	public List<NhaCungCap> findAdd();
	public NhaCungCap findById(int id);
	public void save(NhaCungCap nhaCungCap);
	public void deleteById(int id);

}
