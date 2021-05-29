package com.se.dungcuthethao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.se.dungcuthethao.entity.SanPham;

@RepositoryRestResource(path = "sanphams")
public interface SanPhamRepository extends JpaRepository<SanPham, Integer>{

}
