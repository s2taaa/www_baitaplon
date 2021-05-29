package com.se.dungcuthethao.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.se.dungcuthethao.entity.SanPham;
import com.se.dungcuthethao.repository.SanPhamRepository;
import com.se.dungcuthethao.service.SanPhamService;

@Service
public class SanPhamServiceImpl implements SanPhamService {
	@Autowired
	private SanPhamRepository sanPhamRepository;

	@Override
	public List<SanPham> findAdd() {
		return sanPhamRepository.findAll();
	}

	@Override
	public SanPham findById(int id) {
		Optional<SanPham> rs = sanPhamRepository.findById(id);
		SanPham sanPham = null;
		if (rs.isPresent()) {
			sanPham = rs.get();
		} else {
			throw new RuntimeException("Không tìm thấy sản phẩm - " + id);
		}
		return sanPham;
	}

	@Override
	public void save(SanPham sanPham) {
		sanPhamRepository.save(sanPham);
	}

	@Override
	public void deleteById(int id) {
		Optional<SanPham> rs = sanPhamRepository.findById(id);
		if (rs.isPresent()) {
			sanPhamRepository.deleteById(id); // xóa sản phẩm
		} else {
			throw new RuntimeException("Không tìm thấy sản phẩm - " + id);
		}
	}

}
