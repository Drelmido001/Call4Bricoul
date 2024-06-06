package org.example.call4brikoul.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity

    public class Artisan extends User {

        @Column(name = "date_enregistrement")
        private LocalDate dateEnregistrement;

        @Column(name = "annees_experience")
        private Integer anneesExperience;

        @ManyToMany
        @JoinTable(
                name = "artisan_specialite",
                joinColumns = @JoinColumn(name = "artisan_id"),
                inverseJoinColumns = @JoinColumn(name = "specialite_id")
        )
        @JsonIgnore
        private List<Specialite> specialites;

        @OneToMany(mappedBy = "artisan")
        @JsonIgnore
        private List<Photo> photos;

        @OneToMany(mappedBy = "artisan")
        @JsonIgnore
        private List<Commentaire> commentaires;

        @ManyToOne
        @JoinColumn(name = "ville_id")
        @JsonIgnore
        private Ville ville;

    }
