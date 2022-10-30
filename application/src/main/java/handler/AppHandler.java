package handler;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Alex Mikhalevich
 * @created 2022-10-30 13:23
 */
@RestControllerAdvice
public class AppHandler {

    private static final Logger logger = LogManager.getLogger(AppHandler.class);

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler
    public ErrorResponse handleGlobalExceptions(Exception e, WebRequest request) {
        logger.error("При обработке запроса возникла ошибка со статусом 500.");
        return new ErrorResponse(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                new Date(),
                e.getMessage(),
                request.getDescription(false));
    }


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ValidationViolationResponse handleValidationViolation(MethodArgumentNotValidException e) {
        final List<ValidationViolationResponse.Violation> violations = e.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> new ValidationViolationResponse.Violation(error.getField(), error.getDefaultMessage()))
                .collect(Collectors.toList());
        logger.warn("Для создания пользователя использованы невалидные данные.");
        return new ValidationViolationResponse(violations);
    }
}
