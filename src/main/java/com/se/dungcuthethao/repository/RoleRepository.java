package com.se.dungcuthethao.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.se.dungcuthethao.entity.Role;
import com.se.dungcuthethao.entity.enumEntity.RoleEnum;

@RepositoryRestResource(path = "roles")
public interface RoleRepository extends JpaRepository<Role, Integer>{
	Optional<Role> findByRole(RoleEnum role);
}
