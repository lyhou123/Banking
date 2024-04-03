package org.pratice.banking.adviser;
import org.pratice.banking.utils.BaseRespone;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;
import org.yaml.snakeyaml.constructor.DuplicateKeyException;

import javax.xml.datatype.DatatypeConfigurationException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
@RestControllerAdvice
public class UserAdvisor {
    @ExceptionHandler(NoSuchElementException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    BaseRespone<?> handleNoSuchElementException(NoSuchElementException e)
    {
       return BaseRespone.NotFound()
               .setMetadata(e.getMessage())
               .setStatus(HttpStatus.NOT_FOUND.value());
    }
    // image format ,image size, image exception ,
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public BaseRespone<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException e)
    {
        Map<String,Object> errors=new HashMap<>();
        e.getBindingResult().getFieldErrors().forEach(error->
                errors.put(error.getField(),error.getDefaultMessage()));
        return BaseRespone.NotFound()
                .setMetadata(errors)
                .setStatus(HttpStatus.BAD_REQUEST.value());
    }
    //handle other exception
    @ExceptionHandler(DatatypeConfigurationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public BaseRespone<?> handleException(Exception e)
    {
        System.out.println("Exception: "+e.getMessage());
     return BaseRespone.NotFound()
             .setMetadata(e.getMessage())
             .setMetadata("Email is already exist");
    }
    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<?> handleResponseStatusException(ResponseStatusException e)
    {
       return new ResponseEntity<>(e.getReason(),e.getStatusCode());
    }

}
