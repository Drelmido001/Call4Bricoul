package org.example.call4brikoul.Repository;

import org.example.call4brikoul.models.Artisan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArtisanRepository extends JpaRepository<Artisan, Long> {
    List<Artisan> findByVilleNom(String villeNom);
    List<Artisan> findBySpecialitesNom(String specialiteNom);
}

