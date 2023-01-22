package com.ocheejeh.socialmedia.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL) //ignore any null value/field in this class
public class ErrorDetails {
    /**
     *  Default spring error details is of this form.
     *  if you intend to customize, you can do so with this class
     *  and let the comment details guide you
     *
     *      "timestamp": "2023-01-22T18:44:34.521+00:00",
     *     "status": 404,
     *     "error": "Not Found",
     *     "message": "No message available"
     */
    private LocalDate date;
    private Integer status;
    private String error;
    private String description;

    public ErrorDetails(LocalDate date, String error, String description) {
        this.date = date;
        this.error = error;
        this.description = description;
    }
}
