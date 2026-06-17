package com.example.homerodoh.auth;

import com.example.homerodoh.security.JwtService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final JwtService jwtService;

    public AuthController(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(
            @RequestBody AuthRequest request) {

        if (!"admin".equals(request.getUsername())
                || !"admin123".equals(request.getPassword())) {

            return ResponseEntity.status(401).build();
        }

        String token =
                jwtService.generateToken(
                        request.getUsername()
                );

        return ResponseEntity.ok(
                new AuthResponse(token)
        );
    }
}