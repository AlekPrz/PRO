package alek.app.symulator_ligi.exceptions;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ExceptionInfo {
    private String exceptionException;
    private LocalDateTime exceptionDateTime;

    public ExceptionInfo(String exceptionException) {
        this.exceptionException = exceptionException;
        this.exceptionDateTime = LocalDateTime.now();
    }

}
