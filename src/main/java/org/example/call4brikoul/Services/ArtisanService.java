package org.example.call4brikoul.Services;

import jakarta.transaction.Transactional;
import org.example.call4brikoul.Repository.AddressRepository;
import org.example.call4brikoul.Repository.ArtisanRepository;
import org.example.call4brikoul.Repository.SpecialiteRepository;
import org.example.call4brikoul.Repository.VilleRepository;
import org.example.call4brikoul.models.Artisan;
import org.example.call4brikoul.models.Specialite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ArtisanService {
    private final ArtisanRepository artisanRepository;
    private final SpecialiteRepository specialiteRepository;
    private final VilleRepository villeRepository;
    private final AddressRepository addressRepository;

    @Autowired
    public ArtisanService(ArtisanRepository artisanRepository,AddressRepository addressRepository,SpecialiteRepository specialiteRepository,VilleRepository villeRepository ) {
        this.artisanRepository=artisanRepository;
        this.specialiteRepository=specialiteRepository;
        this.villeRepository=villeRepository;
        this.addressRepository=addressRepository;
    }

    public List<Artisan> getAllArtisans() {
        return artisanRepository.findAll();
    }

    public Artisan getArtisanById(Long id) {
        return artisanRepository.findById(id).orElse(null);
    }

    @Transactional
    public Artisan createArtisan(Artisan artisan) {
        // Enregistrer les spécialités de l'artisan
        if (artisan.getSpecialites() != null) {
            artisan.getSpecialites().forEach(specialiteRepository::save);
        }

        // Enregistrer la ville de l'artisan
        if (artisan.getVille() != null) {
            villeRepository.save(artisan.getVille());
        }

        // Enregistrer l'adresse de l'artisan
        if (artisan.getAdresse() != null) {
            addressRepository.save(artisan.getAdresse());
        }

        // Enregistrer l'artisan lui-même
        return artisanRepository.save(artisan);
    }


    public Artisan updateArtisan(Long id, Artisan artisanDetails) {
        Artisan artisan = artisanRepository.findById(id).orElse(null);
        if (artisan == null) {
            return null;
        }
        artisan.setNom(artisanDetails.getNom());
        artisan.setPrenom(artisanDetails.getPrenom());
        artisan.setEmail(artisanDetails.getEmail());
        artisan.setTelephone(artisanDetails.getTelephone());
        artisan.setAnneesExperience(artisanDetails.getAnneesExperience());
        artisan.setDateEnregistrement(artisanDetails.getDateEnregistrement());
        artisan.setSpecialites(artisanDetails.getSpecialites());
        artisan.setPhotos(artisanDetails.getPhotos());
        artisan.setCommentaires(artisanDetails.getCommentaires());
        return artisanRepository.save(artisan);
    }

    public void deleteArtisan(Long id) {
        artisanRepository.deleteById(id);
    }

    public List<Artisan> findArtisansByVille(String villeNom) {
        return artisanRepository.findByVilleNom(villeNom);
    }

    public List<Artisan> findArtisansBySpecialite(String specialiteNom) {
        return artisanRepository.findBySpecialitesNom(specialiteNom);
    }
}

