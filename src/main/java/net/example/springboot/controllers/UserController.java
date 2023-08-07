package net.example.springboot.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import net.example.springboot.dto.UserDTO;
import net.example.springboot.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/users")
@Tag(
        name = "User Controller",
        description = "User Controller Exposes REST APIs for User-Service"
)
public class UserController {

    private UserService userService;

    @PostMapping()
    @Operation(
            summary = "Save User REST API",
            description = "Save User REST API is used to save user object in a database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 CREATED"
    )
    public ResponseEntity<UserDTO> createUser(@RequestBody @Valid UserDTO user){
        UserDTO savedUser = userService.createUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Get User REST API",
            description = "Get User REST API is used to get employee object from a database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 OK"
    )
    public ResponseEntity<UserDTO> getUserById(@PathVariable("id") Long userId){
        UserDTO user = userService.getUserById(userId);
        return  new ResponseEntity<>(user,HttpStatus.OK);
    }

    @GetMapping()
    @Operation(
            summary = "Get All Users REST API",
            description = "Get All Users REST API is used to get employees objects from a database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 OK"
    )
    public ResponseEntity<List<UserDTO>> getAllUsers(){
        List<UserDTO> users = userService.getAllUsers();
        return new ResponseEntity<>(users,HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @Operation(
            summary = "Update User REST API",
            description = "Update User REST API is used to update user object in a database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 OK"
    )
    public ResponseEntity<UserDTO> updateUser(@RequestBody @Valid UserDTO user,@PathVariable("id") Long userId)
    {
        user.setId(userId);
        UserDTO updatedUser = userService.updateUser(user);
        return new ResponseEntity<>(updatedUser,HttpStatus.OK);
    }

    @DeleteMapping ("/{id}")
    @Operation(
            summary = "Delete User REST API",
            description = "Delete User REST API is used to delete user object in a database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 OK"
    )
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId){
        userService.deleteUser(userId);
        return new ResponseEntity<>("User successfully deleted!",HttpStatus.OK);
    }
}
