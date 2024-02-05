package com.michaeljgoerlitz.fitnesstracker.controller;

import com.michaeljgoerlitz.fitnesstracker.model.Profile;
import com.michaeljgoerlitz.fitnesstracker.repository.ProfileCollectionRepository;
import com.michaeljgoerlitz.fitnesstracker.repository.ProfileRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/profiles")
@CrossOrigin(origins = "http://localhost:5173") // Allow CORS for all endpoints in this controller
public class ProfileController {

    // private final ProfileCollectionRepository repository;
    private final ProfileRepository repository;

    public ProfileController(ProfileRepository repository) {
        this.repository = repository;
    }

    @GetMapping("")
    public List<Profile> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Profile findById(@PathVariable Integer id) {
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found!"));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void create(@RequestBody Profile profile) {
        repository.save(profile);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@RequestBody Profile profile, @PathVariable Integer id) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found");
        }
        repository.save(profile);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        repository.deleteById(id);
    }
}
