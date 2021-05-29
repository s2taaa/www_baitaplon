package com.se.dungcuthethao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.se.dungcuthethao.entity.HoaDon;

@RepositoryRestResource(path="hoadons")
public interface HoaDonRepository extends JpaRepository<HoaDon, Integer>{

}
