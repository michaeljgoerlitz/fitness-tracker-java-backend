package com.michaeljgoerlitz.fitnesstracker.repository;

import com.michaeljgoerlitz.fitnesstracker.model.FitnessData;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class FitnessDataCollectionRepository {

    private final List<FitnessData> fitnessData = new ArrayList<>();

    public FitnessDataCollectionRepository() {

    }

    public List<FitnessData> findAll() {
        return fitnessData;
    }

    public Optional<FitnessData> findById(Integer id) {
        return fitnessData.stream().filter(c -> c.id().equals(id)).findFirst();
    }

    public List<FitnessData> findByProfileId(Integer profileId) {
        return fitnessData.stream().filter(c -> c.profileId().equals(profileId)).toList();
    }

    public boolean existsById(Integer id) {
        return fitnessData.stream().filter(c -> c.id().equals(id)).count() == 1;
    }

    public boolean existsByProfileId(Integer profileId) {
        return fitnessData.stream().anyMatch(c -> c.profileId().equals(profileId));
    }

    public void save(FitnessData data) {
        fitnessData.removeIf(c -> c.id().equals(data.id()));
        fitnessData.add(data);
    }

    public void delete(Integer id) {
        fitnessData.removeIf(c -> c.id().equals(id));
    }

    @PostConstruct
    private void init() {
        FitnessData d = new FitnessData(1, 1, "2024-01-01", 1300, 200);

        fitnessData.add(d);
    }
}
