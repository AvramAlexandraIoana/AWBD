package com.awbd.proiect.services;

import com.awbd.proiect.domain.Location;
import com.awbd.proiect.domain.Role;
import com.awbd.proiect.repositories.LocationRepository;
import com.awbd.proiect.repositories.RoleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements  RoleService{
    private final Logger log = LoggerFactory.getLogger(RoleServiceImpl.class);

    RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> findAll(){
        List<Role> roles = new LinkedList<>();
        roleRepository.findAll().iterator().forEachRemaining(roles::add);
        log.info("Find all roles ...", roles);
        return roles;
    }

    @Override
    public Role findById(Long l) {
        Optional<Role> roleOptional =
                roleRepository.findById(l);
        if (!roleOptional.isPresent()) {
            throw new RuntimeException("Role not found!");
        }
        log.info("Find by id ...", roleOptional.get());
        return roleOptional.get();
    }
}
