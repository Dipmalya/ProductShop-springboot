package com.example.product.controller;

import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.product.model.AuthRequest;
import com.example.product.model.LoginResponse;
import com.example.product.model.User;
import com.example.product.repository.UserRepository;
import com.example.product.service.UserService;
import com.example.product.util.EncryptString;
import com.example.product.util.JwtUtil;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private AuthenticationManager authenticationManager;
    
	@Autowired
	private UserService service;
	
	@Autowired
	private UserRepository repository;

	@Value(value = "signingSecret")
    private String secret;
	
	@PostMapping("/login")
    public ResponseEntity<LoginResponse> generateToken(@RequestBody AuthRequest authRequest) throws Exception {
		LoginResponse loginObj = new LoginResponse();
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUserEmail(), EncryptString.encryptPwd(authRequest.getUserPwd()))
            );
        } catch (Exception ex) {
            throw new Exception("inavalid username/password");
        }
        loginObj.setToken(jwtUtil.generateToken(authRequest.getUserEmail()));
        loginObj.setUser(repository.findByUserEmail(authRequest.getUserEmail()));
        
        return new ResponseEntity<LoginResponse>(loginObj, HttpStatus.OK);
    }
	
	@GetMapping("/test")
	public String test() {
		return "Welcome!!";
	}
	
	@PostMapping("/register")
	public ResponseEntity<Boolean> registerUser(@RequestBody User user) {
		String pwd = user.getUserPwd();
		try {
			user.setUserPwd(EncryptString.encryptPwd(pwd));
			service.registerUser(user);
		} catch (NoSuchAlgorithmException e) {
			return new ResponseEntity<Boolean>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}
}
