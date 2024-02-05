package com.michaeljgoerlitz.fitnesstracker.repository;

import com.michaeljgoerlitz.fitnesstracker.model.Profile;
import org.springframework.data.repository.ListCrudRepository;

public interface ProfileRepository extends ListCrudRepository<Profile, Integer> {
}
