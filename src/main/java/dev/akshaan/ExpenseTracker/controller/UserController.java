package dev.akshaan.ExpenseTracker.controller;

import dev.akshaan.ExpenseTracker.dtos.UserRegistrationRequestDTO;
import dev.akshaan.ExpenseTracker.exception.UserRegistrationImproperDataException;
import dev.akshaan.ExpenseTracker.exception.UserRegistrationInvalidDataException;
import dev.akshaan.ExpenseTracker.mapper.EntityDTOMapper;
import dev.akshaan.ExpenseTracker.models.User;
import dev.akshaan.ExpenseTracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.regex.Pattern;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/signUp")
    public ResponseEntity signUp(@RequestBody UserRegistrationRequestDTO userRegistrationRequestDTO){
        validateUserRegistrationRequestDTO(userRegistrationRequestDTO);
        User savedUser = userService.signUp(userRegistrationRequestDTO.getName(), userRegistrationRequestDTO.getEmail(), userRegistrationRequestDTO.getPassword());
        return ResponseEntity.ok(EntityDTOMapper.toDTO(savedUser));
    }

    private void validateUserRegistrationRequestDTO(UserRegistrationRequestDTO requestDTO){
        if(requestDTO.getName() == null ||
            requestDTO.getEmail() == null ||
            requestDTO.getPassword() == null){
            throw new UserRegistrationInvalidDataException("Invalid sign up data is given!!");
        }

        String emailRegexPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        String passwordRegexPattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\\\S+$).{8,20}$";

        if(!Pattern.compile(emailRegexPattern).matcher(requestDTO.getEmail()).matches() ||
            !Pattern.compile(passwordRegexPattern, Pattern.CASE_INSENSITIVE).matcher(requestDTO.getPassword()).matches()){
            throw new UserRegistrationImproperDataException("Email or password is not meeting the requirement!!");
        }
    }
}