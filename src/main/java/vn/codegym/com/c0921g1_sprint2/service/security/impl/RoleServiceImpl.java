package vn.codegym.com.c0921g1_sprint2.service.security.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.com.c0921g1_sprint2.model.security.Role;
import vn.codegym.com.c0921g1_sprint2.repository.security.RoleRepository;
import vn.codegym.com.c0921g1_sprint2.service.security.RoleService;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<Role> getAll() {
        return roleRepository.getAll();
    }
}
