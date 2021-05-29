package com.se.dungcuthethao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.se.dungcuthethao.entity.KhachHang;

@RepositoryRestResource(path = "khachhangs")
public interface KhachHangRepository extends JpaRepository<KhachHang, Integer>{

}
