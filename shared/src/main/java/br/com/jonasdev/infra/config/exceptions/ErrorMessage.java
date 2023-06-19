package br.com.jonasdev.infra.config.exceptions;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(Include.NON_NULL)
class ErrorMessage {

    @JsonProperty("timestamp")
    @NotNull
    private OffsetDateTime timestamp;

    @JsonProperty("status")
    @NotNull
    private Integer status;

    @JsonProperty("error")
    @NotNull
    private String error;

    @JsonProperty("message")
    @NotNull
    @Size(max = 255)
    private String message;

    @JsonProperty("path")
    private String path;

}

