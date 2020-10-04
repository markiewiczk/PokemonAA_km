package pl.sdaacademy.PokemonAcademyApi.common.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import pl.sdaacademy.PokemonAcademyApi.common.NoPokemonFoundExeption;

@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(value = NoPokemonFoundExeption.class)
    public ResponseEntity<Object> noSuchElementExeption(NoPokemonFoundExeption e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
}


