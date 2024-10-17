package com.siemens.webstore.webstoreapi.models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Table(name="Catalog")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Catalog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="Catalog_Id")
    @Schema(hidden = true)
    private long catalogId;
    @Column(name="Catalog_Name",nullable = false,length = 50)
    private String catalogName;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name="Created_On")
    private LocalDate createdOn;

}
