package org.example.call4brikoul.Controllers;

import org.example.call4brikoul.Services.ArtisanService;
import org.example.call4brikoul.models.Artisan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/artisans")
@CrossOrigin("*")
public class ArtisanController {
    private final ArtisanService artisanService;

    @Autowired
    public ArtisanController(ArtisanService artisanService) {
        this.artisanService = artisanService;
    }

    @GetMapping
    public List<Artisan> getAllArtisans() {
        return artisanService.getAllArtisans();
    }

    @GetMapping("/{id}")
    public Artisan getArtisanById(@PathVariable Long id) {
        return artisanService.getArtisanById(id);
    }

    @PostMapping
    public Artisan createArtisan(@RequestBody Artisan artisan) {
        return artisanService.createArtisan(artisan);
    }

    @PutMapping("/{id}")
    public Artisan updateArtisan(@PathVariable Long id, @RequestBody Artisan artisanDetails) {
        return artisanService.updateArtisan(id, artisanDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteArtisan(@PathVariable Long id) {
        artisanService.deleteArtisan(id);
    }

    @GetMapping("/ville/{villeNom}")
    public List<Artisan> findArtisansByVille(@PathVariable String villeNom) {
        return artisanService.findArtisansByVille(villeNom);
    }

    @GetMapping("/specialite/{specialiteNom}")
    public List<Artisan> findArtisansBySpecialite(@PathVariable String specialiteNom) {
        return artisanService.findArtisansBySpecialite(specialiteNom);
    }
}
