package com.se.dungcuthethao.service;

import java.util.List;

import com.se.dungcuthethao.entity.Role;

public interface RoleService {
	public List<Role> findAdd();
	public Role findById(int id);
	public void save(Role role);
	public void deleteById(int id);

}
