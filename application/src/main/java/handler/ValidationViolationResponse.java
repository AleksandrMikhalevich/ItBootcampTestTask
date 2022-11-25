package handler;

import java.util.List;

/**
 * @author Alex Mikhalevich
 * @created 2022-10-30 12:36
 */

public record ValidationViolationResponse(List<Violation> violations) {

    public record Violation(String fieldName, String message) {

    }
}

