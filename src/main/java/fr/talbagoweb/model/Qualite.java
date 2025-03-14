package fr.talbagoweb.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "qualites")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Qualite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String description;
}
