package com.se.dungcuthethao.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.se.dungcuthethao.entity.TaiKhoan;

@RepositoryRestResource(path = "taikhoans")
public interface TaiKhoanRepository extends JpaRepository<TaiKhoan, Integer> {
	Optional<TaiKhoan> findByUsername(String username);

	Boolean existsByUsername(String username);
}
