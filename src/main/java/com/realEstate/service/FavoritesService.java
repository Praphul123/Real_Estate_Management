package com.realEstate.service;

import com.realEstate.dto.FavoritesRequest;
import com.realEstate.entity.Client;
import com.realEstate.entity.Favorites;
import com.realEstate.entity.Property;
import com.realEstate.repository.ClientRepository;
import com.realEstate.repository.FavoritesRepository;
import com.realEstate.repository.PropertyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoritesService {

    private final FavoritesRepository favoritesRepository;
    private final ClientRepository clientRepository;
    private final PropertyRepository propertyRepository;

    public FavoritesService(FavoritesRepository favoritesRepository, ClientRepository clientRepository, PropertyRepository propertyRepository) {
        this.favoritesRepository = favoritesRepository;
        this.clientRepository = clientRepository;
        this.propertyRepository = propertyRepository;
    }

    public Favorites saveFavorites(Long clientId, List<Long> propertyIds) {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Client not found"));

        List<Property> properties = propertyRepository.findAllById(propertyIds);

        Favorites favorites = new Favorites();
        favorites.setClient(client);
        favorites.setProperties(properties);

        return favoritesRepository.save(favorites);
    }

    public void removeFromFavorites(Long clientId, Long propertyId) {
        Favorites favorites = favoritesRepository.findByClientId(clientId)
                .orElseThrow(() -> new RuntimeException("Favorites not found"));

        favorites.getProperties().removeIf(property -> property.getId().equals(propertyId));
        favoritesRepository.save(favorites);
    }

    public Favorites getFavorites(Long clientId) {
        return favoritesRepository.findByClientId(clientId)
                .orElseThrow(() -> new RuntimeException("Favorites not found"));
    }
}
