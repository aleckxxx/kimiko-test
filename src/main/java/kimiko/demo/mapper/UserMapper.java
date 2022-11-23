package kimiko.demo.mapper;

import kimiko.demo.dto.UserDto;
import kimiko.demo.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor

public class UserMapper {

    public UserDto toUserDto(User user){
        return new UserDto().builder()
                .id(user.getId())
                .firstname(user.getFirstname())
                .lastname(user.getLastname())
                .email(user.getEmail())
                .build();
    }
}
