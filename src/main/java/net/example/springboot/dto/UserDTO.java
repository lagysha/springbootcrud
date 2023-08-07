package net.example.springboot.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Schema(
        description = "User Informational Model"
)
public class UserDTO {
    private Long id;
    @NotEmpty(message = "User first name should not be null or empty")
    @Schema(
            description = "User First Name"
    )
    private String firstName;
    @NotEmpty(message = "User last name should not be null or empty")
    @Schema(
            description = "User Last Name"
    )
    private String lastName;
    @NotEmpty(message = "User email should not be null or empty")
    @Email(message = "Email address must be valid")
    @Schema(
            description = "User Email"
    )
    private String email;
}