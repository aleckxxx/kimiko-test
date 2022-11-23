package kimiko.demo.api.controller;

import kimiko.demo.api.error.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.stream.Collectors;

@RestController
public class BaseController {

    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleInvalidRequestException(MethodArgumentNotValidException exception){

        return new ErrorResponse(HttpStatus.BAD_REQUEST.value(),exception.getBindingResult()
                                                                .getFieldErrors()
                                                                .stream()
                                                                .map(value ->value.getDefaultMessage())
                                                                .collect(Collectors.toList()));
    }
}
