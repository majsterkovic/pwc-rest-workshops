package put.poznan.pwcrestworkshops.dto;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record ExceptionResponse(
        LocalDateTime timestamp,
        String message
) {
}
