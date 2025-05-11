package com.badr.task_app.domain.dto;

public record ErrorResponse(
        int status,
        String message,
        String details
) {
}
