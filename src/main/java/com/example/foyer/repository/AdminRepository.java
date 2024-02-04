package com.example.foyer.repository;

import com.example.foyer.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {

    Admin findAdminByUserEmail(String email);

}
