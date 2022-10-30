package handlers;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

/**
 * @author Alex Mikhalevich
 * @created 2022-10-30 12:36
 */
@RequiredArgsConstructor
@Getter
public class ValidationViolationResponse {

    private final List<Violation> violations;


    @RequiredArgsConstructor
    @Getter
    public static class Violation{

        private final String fieldName;
        private final String message;

    }
}

