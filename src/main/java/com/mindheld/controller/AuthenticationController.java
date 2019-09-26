package com.mindheld.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import com.mindheld.model.AuthToken;
import com.mindheld.model.LoginUser;
import com.mindheld.model.ResponseObject;
import com.mindheld.service.PersonService;
import com.mindheld.util.TokenProvider;
import com.mindheld.util.Utils;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/token")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenProvider jwtTokenUtil;
    
    @Autowired
	@Qualifier("personService")
    private PersonService personService;
    
    @Autowired
    private com.mindheld.repository.pruebaRepository pruebaRepository;


    @PostMapping("/generate-token")
    public ResponseEntity<?> register(@RequestBody LoginUser loginUser) throws AuthenticationException {

        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginUser.getUsername(),
                        loginUser.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final String token = jwtTokenUtil.generateToken(authentication);
        var role = Utils.getFirstRoleFromAuthorities(SecurityContextHolder.getContext().getAuthentication().getAuthorities());
        var personData = personService.findPersonBasicByUser(loginUser.getUsername());
        var response = new ResponseObject();
        response.setResult(Boolean.TRUE);
		response.setMessage(ResponseObject.OK_MESSAGE);
		response.setStatus(ResponseObject.OK);
		response.setResult(new AuthToken(token, role, personData));
        return ResponseEntity.ok(response);
        
    }
    
    @GetMapping("/wea")
    public ResponseEntity<?> wea() throws AuthenticationException {
        var response = new ResponseObject();
        response.setResult(Boolean.TRUE);
		response.setMessage(ResponseObject.OK_MESSAGE);
		response.setStatus(ResponseObject.OK);
		response.setResult(pruebaRepository.buscar());
        return ResponseEntity.ok(response);
        
    }
    
    

}
