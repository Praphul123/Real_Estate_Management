package com.realEstate.controller;


import com.realEstate.dto.FavoritesRequest;
import com.realEstate.entity.Favorites;
import com.realEstate.service.FavoritesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/favorites")
public class FavoritesController {

    private final FavoritesService favoritesService;

    public FavoritesController(FavoritesService favoritesService) {
        this.favoritesService = favoritesService;
    }

    @PostMapping("/add")
    public ResponseEntity<Favorites> addToFavorites(@RequestBody FavoritesRequest request) {
        Favorites favorites = favoritesService.saveFavorites(request.getClientId(), request.getPropertyIds());
        return ResponseEntity.ok(favorites);
    }

    @DeleteMapping("/remove/{clientId}/{propertyId}")
    public ResponseEntity<Void> removeFromFavorites(@PathVariable Long clientId, @PathVariable Long propertyId) {
        favoritesService.removeFromFavorites(clientId, propertyId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{clientId}")
    public ResponseEntity<Favorites> getFavorites(@PathVariable Long clientId) {
        Favorites favorites = favoritesService.getFavorites(clientId);
        return ResponseEntity.ok(favorites);
    }
}
