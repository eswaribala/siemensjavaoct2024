package com.siemens.webstore.webstoreapi.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
@Entity
@Table(name="SubProduct")
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
public class SubProduct  extends Product{
    @Column(name="Ingredients", nullable = false,length = 200)
    private String ingredients;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name="Expiry_Date")
    private LocalDate expiryDate;

}
