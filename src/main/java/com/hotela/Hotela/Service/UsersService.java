package com.hotela.Hotela.Service;


import com.hotela.Hotela.Model.Users;
import com.hotela.Hotela.Repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsersService {
    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Đăng ký người dùng mới
    public Users registerUser(Users user) {
        String passwordEncoded = passwordEncoder.encode(user.getPassword());
        user.setPassword(passwordEncoded);
        return usersRepository.save(user);
    }

    // Kiểm tra sự tồn tại của username
    public boolean existsByEmail(String email) {
        return usersRepository.existsByEmail(email);
    }

    // Tìm người dùng theo username
    public Optional<Users> findByEmail(String email) {
        return usersRepository.findByEmail(email);  // Thay đổi để trả về Optional<Users>
    }
}
