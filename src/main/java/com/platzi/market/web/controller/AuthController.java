package com.platzi.market.web.controller;

import com.platzi.market.domain.dto.AuthRequestDTO;
import com.platzi.market.domain.dto.AuthResponseDTO;
import com.platzi.market.domain.service.PlatziUserDetailsService;
import com.platzi.market.web.security.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PlatziUserDetailsService platziUserDetailsService;

    @Autowired
    private JWTUtil jwtUtil;

    @PostMapping(value = "/authenticate")
    public ResponseEntity<AuthResponseDTO> createToken(@RequestBody AuthRequestDTO request) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUser(), request.getPassword()));
            UserDetails userDetails = platziUserDetailsService.loadUserByUsername(request.getUser());
            String jwt = jwtUtil.generateToken(userDetails);
            return new ResponseEntity<>(new AuthResponseDTO(jwt), HttpStatus.OK);
        } catch (BadCredentialsException e) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }
}
