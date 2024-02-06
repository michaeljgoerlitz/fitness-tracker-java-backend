package com.michaeljgoerlitz.fitnesstracker.controller;

import com.michaeljgoerlitz.fitnesstracker.model.FitnessData;
import com.michaeljgoerlitz.fitnesstracker.repository.FitnessDataRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/fitness")
@CrossOrigin(origins = "http://localhost:5173") // Allow CORS for all endpoints in this controller
public class FitnessDataController {

    private final FitnessDataRepository repository;

    public FitnessDataController(FitnessDataRepository repository) {
        this.repository = repository;
    }

    @GetMapping("")
    public List<FitnessData> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public FitnessData findById(@PathVariable Integer id) {
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found!"));
    }

    @GetMapping("/{profileId}")
    public FitnessData findByProfileId(@PathVariable Integer profileId) {
        return repository.findById(profileId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found!"));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void create(@RequestBody FitnessData fitnessData) {
        repository.save(fitnessData);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@RequestBody FitnessData fitnessData, @PathVariable Integer id) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found");
        }
        repository.save(fitnessData);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        repository.deleteById(id);
    }
}
