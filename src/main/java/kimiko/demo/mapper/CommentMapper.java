package kimiko.demo.mapper;

import kimiko.demo.dto.CommentDto;
import kimiko.demo.entity.Car;
import kimiko.demo.entity.Comment;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor

public class CommentMapper {

    @Autowired
    private UserMapper userMapper;


    public CommentDto toCommentDto(Comment comment){
        return new CommentDto().builder()
                .id(comment.getId())
                .createdAt(comment.getCreatedAt())
                .content(comment.getContent())
                .user(userMapper.toUserDto(comment.getUser()))
                .build();
    }

    public Comment toComment(CommentDto comment){
        Car car = new Car();
        car.setId(comment.getCarId());
        return new Comment().builder()
                .car(car)
                .content(comment.getContent())
                .build();
    }
}
