package com.se.dungcuthethao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.se.dungcuthethao.entity.NhaCungCap;



@RepositoryRestResource(path = "nhacungcaps")
public interface NhaCungCapRepository extends JpaRepository<NhaCungCap, Integer> {
	
}
