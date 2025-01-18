package com.hotela.Hotela.Controllers;

import com.hotela.Hotela.DTO.RequestAuthDTO;
import com.hotela.Hotela.Model.Users;
import com.hotela.Hotela.Service.UsersService;
import com.hotela.Hotela.Utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:3000", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class AuthController {

    @Autowired
    UsersService usersService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtUtil jwtUtil;

    @PostMapping("/register")
    public ResponseEntity<String> register (@RequestBody Users user){
        String email = user.getEmail();

        if(usersService.existsByEmail(email)){
            return new ResponseEntity<>("Email already exists !", HttpStatus.BAD_REQUEST);
        }

        Users newUser = usersService.registerUser(user);
        return new ResponseEntity<>("Register successful!", HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody RequestAuthDTO requestAuthDTO) {
        String email = requestAuthDTO.getEmail();
        String password = requestAuthDTO.getPassword();

        Optional<Users> user = usersService.findByEmail(email);

        if (user.isPresent() && passwordEncoder.matches(password, user.get().getPassword())) {
            // Tạo token khi đăng nhập thành công
            String token = jwtUtil.generateToken(email);

            return new ResponseEntity<>(token, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Tên người dùng hoặc mật khẩu không hợp lệ", HttpStatus.UNAUTHORIZED);
        }
    }


}
