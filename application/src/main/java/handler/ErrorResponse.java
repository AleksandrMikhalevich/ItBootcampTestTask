package handler;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

/**
 * @author Alex Mikhalevich
 * @created 2022-10-30 14:01
 */
@AllArgsConstructor
@Getter
public class ErrorResponse {

    private int statusCode;
    private Date timestamp;
    private String message;
    private String description;
}
