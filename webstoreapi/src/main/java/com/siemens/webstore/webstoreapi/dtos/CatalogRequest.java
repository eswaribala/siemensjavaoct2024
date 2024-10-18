package com.siemens.webstore.webstoreapi.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CatalogRequest {

    private long catalogId;
    @NotNull(message = "Catalog name cannot be null")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Catalog Name must contain only alphabets")

    private String catalogName;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate createdOn;
}
