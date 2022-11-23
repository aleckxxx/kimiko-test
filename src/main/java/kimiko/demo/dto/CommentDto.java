package kimiko.demo.dto;

import kimiko.demo.entity.Car;
import kimiko.demo.entity.User;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.sql.Timestamp;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentDto {
    private int id;
    @NotEmpty(message="Le contenu du commentaire ne doit pas être vide.")
    private String content;
    private Timestamp createdAt;
    private UserDto user;
    private int carId;
}
