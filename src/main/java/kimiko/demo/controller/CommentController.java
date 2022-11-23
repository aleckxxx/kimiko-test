package kimiko.demo.controller;

import kimiko.demo.dto.CommentDto;
import kimiko.demo.mapper.CommentMapper;
import kimiko.demo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.security.Principal;

@Controller
public class CommentController {
    @Autowired
    private CommentService commentService;

    @Autowired
    private CommentMapper commentMapper;
    @RequestMapping(value = "/comments", method = RequestMethod.POST)
    public String addComment(@Valid @ModelAttribute("newComment")CommentDto comment, BindingResult binding,
                             Principal principal){
        if(binding.hasErrors()){
            return "redirect:/cars/"+comment.getCarId()+"?error="+binding.getFieldError("content").getDefaultMessage();
        }
        commentService.save(commentMapper.toComment(comment), principal.getName());
        return "redirect:/cars/"+comment.getCarId();
    }
}
