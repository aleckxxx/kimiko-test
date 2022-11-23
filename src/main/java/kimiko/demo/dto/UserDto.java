package kimiko.demo.dto;


import kimiko.demo.entity.User;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.modelmapper.ModelMapper;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Getter
@Builder
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private int id;
    @NotEmpty(message = "Le prénom ne devrait pas être vide.")
    private String firstname;
    @NotEmpty(message = "Le nom ne devrait pas être vide.")
    private String lastname;
    @NotEmpty(message = "L'adresse électronique ne devrait pas être vide.")
    @Email(message = "Veuillez choisir un email valide.")
    private String email;
    @Length(min=8, message="Le mot de passe devrait faire au moins 8 charactères.")
    private String password;

    public User toUser(){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(this, User.class);
    }

}

