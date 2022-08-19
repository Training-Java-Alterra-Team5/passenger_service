package com.passenger.passenger.repositories;

import com.passenger.passenger.models.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesRepository extends JpaRepository<Roles, Long> {
    Roles findRolesById(Integer roleId);
    Roles findRolesByName(String roleName);
}
