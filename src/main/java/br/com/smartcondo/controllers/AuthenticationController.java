package br.com.smartcondo.controllers;

import br.com.smartcondo.enums.UserRole;
import br.com.smartcondo.models.Users;
import br.com.smartcondo.records.AuthenticationDTO;
import br.com.smartcondo.records.LoginResponseDTO;
import br.com.smartcondo.records.RegisterDTO;
import br.com.smartcondo.repositories.UsersRepository;
import br.com.smartcondo.services.EmployeeService;
import br.com.smartcondo.services.ResidentService;
import br.com.smartcondo.services.SyndicateService;
import br.com.smartcondo.services.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    SyndicateService syndicateService;

    @Autowired
    EmployeeService employeeService;

    @Autowired
    ResidentService residentService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);
        var token = tokenService.generateToken((Users) auth.getPrincipal());

        Users user = usersRepository.findByLogin(data.login());

        Object entity;
        String role = user.getRole().toString();
        if (user.getRole() == UserRole.MORADOR) {
            entity = residentService.findById(user.getUser_id());
        } else if (user.getRole() == UserRole.FUNCIONARIO) {
            entity = employeeService.findById(user.getUser_id());
        } else if (user.getRole() == UserRole.SINDICO) {
            entity = syndicateService.findById(user.getUser_id());
        } else {
            token = "";
            entity = null;
            role = "ERROR";
        }

        return ResponseEntity.ok(new LoginResponseDTO(token, role, entity));
    }

    @PostMapping(value = "/register", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity register(@RequestBody @Valid RegisterDTO data) {
        if (this.usersRepository.findByLogin(data.login()) != null) return ResponseEntity.badRequest().build();

        String encrypetedPassword = new BCryptPasswordEncoder().encode(data.password());
        Users newUser = new Users(data.login(), encrypetedPassword, data.role(), data.user_id());

        this.usersRepository.save(newUser);

        return ResponseEntity.ok().build();
    }
}
