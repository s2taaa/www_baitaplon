package com.se.dungcuthethao.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.se.dungcuthethao.entity.NhaCungCap;
import com.se.dungcuthethao.repository.NhaCungCapRepository;
import com.se.dungcuthethao.service.NhaCungCapService;

@Service
public class NhaCungCapServiceImpl implements NhaCungCapService {
@Autowired
private NhaCungCapRepository nhaCungCapRepository;
	
	
	@Override
	public List<NhaCungCap> findAdd() {
		return nhaCungCapRepository.findAll();
	}

	@Override
	public NhaCungCap findById(int id) {
		Optional<NhaCungCap> rs = nhaCungCapRepository.findById(id);
		NhaCungCap nhaCungCap =null;
		if (rs.isPresent()) {
			nhaCungCap = rs.get();
		} else {
			throw new RuntimeException("Không tìm thấy nhà cung cấp - " + id);
		}
		return nhaCungCap;	
		}

	@Override
	public void save(NhaCungCap nhaCungCap) {
		nhaCungCapRepository.save(nhaCungCap);
	}

	@Override
	public void deleteById(int id) {
		Optional<NhaCungCap> rs = nhaCungCapRepository.findById(id);
		if (rs.isPresent()) {
			nhaCungCapRepository.deleteById(id); // xóa nhà cung cấp
		} else {
			throw new RuntimeException("Không tìm thấy nhà cung cấp - " + id);
		}
	}
		

}
