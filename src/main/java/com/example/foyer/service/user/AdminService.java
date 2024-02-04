package com.example.foyer.service.user;

import com.example.foyer.entity.Admin;
import com.example.foyer.entity.User;
import com.example.foyer.repository.AdminRepository;
import com.example.foyer.repository.UserInfoRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@Slf4j
@AllArgsConstructor
@NoArgsConstructor
public class AdminService {

    @Autowired
    AdminRepository adminRepository;

    @Autowired
    UserInfoRepository userRepository;

    @Autowired
    private PasswordEncoder encoder;
    public Admin getAdminByEmail(String email){
        return this.adminRepository.findAdminByUserEmail(email);
    }


    public String addAdmin(Map<String, String> data) {
        User user = new User();
        user.setEmail(data.get("email"));
        user.setPassword(data.get("password"));
        user.setRole(data.get("role"));
        Admin admin = new Admin();
        admin.setUser(user);
        //etudiant.setCin(Long.parseLong(data.get("cin")));
        user.setPassword(encoder.encode(user.getPassword()));
        userRepository.save(user);
        adminRepository.save(admin);
        return "admin Added Successfully";
    }
}
