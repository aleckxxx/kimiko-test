package kimiko.demo.service;

import kimiko.demo.dto.CommentDto;
import kimiko.demo.entity.Car;
import kimiko.demo.entity.Comment;
import kimiko.demo.entity.User;
import kimiko.demo.repository.CarRepository;
import kimiko.demo.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    private CommentRepository commentRepository;
    private UserService userService;

    @Autowired
    public CommentService(CommentRepository commentRepository,UserService userService){
        this.commentRepository = commentRepository;
        this.userService = userService;
    }

    public void save(Comment comment, String sender){
        User user = userService.findUserByEmail(sender);
        comment.setUser(user);
        commentRepository.save(comment);
    }
}

