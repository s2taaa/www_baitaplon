package com.se.dungcuthethao.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.se.dungcuthethao.entity.KhachHang;
import com.se.dungcuthethao.repository.KhachHangRepository;
import com.se.dungcuthethao.service.KhachHangService;

@Service
public class KhachHangServiceImpl implements KhachHangService {
	@Autowired
	private KhachHangRepository khachHangRepository;
		
		
		@Override
		public List<KhachHang> findAdd() {
			return khachHangRepository.findAll();
		}

		@Override
		public KhachHang findById(int id) {
			Optional<KhachHang> rs = khachHangRepository.findById(id);
			KhachHang khachHang =null;
			if (rs.isPresent()) {
				khachHang = rs.get();
			} else {
				throw new RuntimeException("Không tìm thấy khách hàng - " + id);
			}
			return khachHang;	
			}

		@Override
		public void save(KhachHang khachHang) {
			khachHangRepository.save(khachHang);
		}

		@Override
		public void deleteById(int id) {
			Optional<KhachHang> rs = khachHangRepository.findById(id);
			if (rs.isPresent()) {
				khachHangRepository.deleteById(id); // xóa nhà khách hàng
			} else {
				throw new RuntimeException("Không tìm thấy khách hàng - " + id);
			}
		}
			

	}
