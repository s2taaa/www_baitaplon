package com.se.dungcuthethao.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.se.dungcuthethao.entity.HoaDon;
import com.se.dungcuthethao.repository.HoaDonRepository;
import com.se.dungcuthethao.service.HoaDonService;


@Service
public class HoaDonServiceImpl implements HoaDonService{
	@Autowired
	private HoaDonRepository hoaDonRepository;

	@Override
	public List<HoaDon> findAdd() {
		return hoaDonRepository.findAll();
	}

	@Override
	public HoaDon findById(int id) {
		Optional<HoaDon> rs = hoaDonRepository.findById(id);
		HoaDon hoaDon = null;
		if (rs.isPresent()) {
			hoaDon = rs.get();
		} else {
			throw new RuntimeException("Không tìm thấy hóa đơn - " + id);
		}
		return hoaDon;
	}

	@Override
	public void save(HoaDon hoaDon) {
		hoaDonRepository.save(hoaDon);
	}

	@Override
	public void deleteById(int id) {
		Optional<HoaDon> rs = hoaDonRepository.findById(id);
		if (rs.isPresent()) {
			hoaDonRepository.deleteById(id); // xóa Hóa đơn
		} else {
			throw new RuntimeException("Không tìm thấy Hóa đơn - " + id);
		}
	}

}
