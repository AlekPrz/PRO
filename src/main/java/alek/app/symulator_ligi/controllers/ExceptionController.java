package alek.app.symulator_ligi.controllers;

import alek.app.symulator_ligi.exceptions.MyException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(MyException.class)
    public String myExceptionHandler(MyException e, Model model) {
        model.addAttribute("exceptionMessage", e.getMessage());
        return "exceptionPage";
    }

}
