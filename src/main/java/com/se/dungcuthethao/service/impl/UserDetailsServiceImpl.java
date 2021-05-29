package com.se.dungcuthethao.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.se.dungcuthethao.entity.TaiKhoan;
import com.se.dungcuthethao.repository.TaiKhoanRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	@Autowired
	private TaiKhoanRepository TaiKhoanRepository;
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		TaiKhoan taiKhoan = TaiKhoanRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("Không tồn tại tại khoản: "+username));
		return UserDetailsImpl.build(taiKhoan);
	}

}
