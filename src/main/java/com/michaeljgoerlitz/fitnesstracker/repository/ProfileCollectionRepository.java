package com.michaeljgoerlitz.fitnesstracker.repository;

import com.michaeljgoerlitz.fitnesstracker.model.Profile;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ProfileCollectionRepository {

    private final List<Profile> profiles = new ArrayList<>();

    public ProfileCollectionRepository() {

    }

    public List<Profile> findAll() {
        return profiles;
    }

    public Optional<Profile> findById(Integer id) {
        return profiles.stream().filter(c -> c.id().equals(id)).findFirst();
    }

    public boolean existsById(Integer id) {
        return profiles.stream().filter(c -> c.id().equals(id)).count() == 1;
    }

    public void save(Profile profile) {
        profiles.removeIf(c -> c.id().equals(profile.id()));
        profiles.add(profile);
    }

    public void delete(Integer id) {
        profiles.removeIf(c -> c.id().equals(id));
    }

    @PostConstruct
    private void init() {
        Profile p = new Profile(1, "michael", 2500);

        profiles.add(p);
    }
}
