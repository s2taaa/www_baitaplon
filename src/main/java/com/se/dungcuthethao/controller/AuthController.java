package com.se.dungcuthethao.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.se.dungcuthethao.entity.KhachHang;
import com.se.dungcuthethao.entity.TaiKhoan;
import com.se.dungcuthethao.jwt.JwtUtils;
import com.se.dungcuthethao.payload.request.LoginRequest;
import com.se.dungcuthethao.payload.request.SignupRequest;
import com.se.dungcuthethao.payload.response.JwtResponse;
import com.se.dungcuthethao.payload.response.MessageResponse;
import com.se.dungcuthethao.repository.TaiKhoanRepository;
import com.se.dungcuthethao.service.impl.UserDetailsImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth/")
public class AuthController {
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private TaiKhoanRepository taiKhoanRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private JwtUtils jwtUtils;
	
	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);
		
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
		TaiKhoan taiKhoan = userDetails.getTaiKhoan();
		KhachHang khachHang = userDetails.getTaiKhoan().getKhachHang();
		
		return ResponseEntity.ok(new JwtResponse(jwt, khachHang, taiKhoan));
	}
	
	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
		if (taiKhoanRepository.existsByUsername(signUpRequest.getUsername())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Lỗi: Tài khoản đã tồn tại!"));
		}

		// Create new user's account
		TaiKhoan taiKhoan = new TaiKhoan();
		taiKhoan.setUsername(signUpRequest.getUsername());
		taiKhoan.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
		taiKhoan.setKhachHang(new KhachHang());

		taiKhoanRepository.save(taiKhoan);

		return ResponseEntity.ok(new MessageResponse("Đăng ký thành công!"));
	}
}
