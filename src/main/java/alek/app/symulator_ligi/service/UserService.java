package alek.app.symulator_ligi.service;

import alek.app.symulator_ligi.exceptions.MyException;
import alek.app.symulator_ligi.model.User;
import alek.app.symulator_ligi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.servlet.http.HttpServletRequest;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void registerUser(User user, HttpServletRequest request) {

        if (user == null) {
            throw new MyException("USER IS NULL");
        }

        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            throw new MyException("USERNAME ALREADY EXISTS");
        }

        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new MyException("EMAIL ALREADY EXISTS");
        }

        String password = user.getPassword();
        String passwordConfirmation = user.getPasswordConfirmation();
        if (!password.equals(passwordConfirmation)) {
            throw new MyException("PASSWORD AND PASSWORD CONFIRMATION DON'T MATCH");
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEnabled(true);
        userRepository.save(user);
    }


}
