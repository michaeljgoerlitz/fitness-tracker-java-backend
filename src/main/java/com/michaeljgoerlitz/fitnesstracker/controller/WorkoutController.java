package com.michaeljgoerlitz.fitnesstracker.controller;

import com.michaeljgoerlitz.fitnesstracker.model.Workout;
import com.michaeljgoerlitz.fitnesstracker.repository.WorkoutRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/workouts")
@CrossOrigin(origins = "http://localhost:5173")
public class WorkoutController {

    private final WorkoutRepository repository;

    public WorkoutController(WorkoutRepository repository) {
        this.repository = repository;
    }

    @GetMapping("")
    public List<Workout> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Workout findById(@PathVariable Integer id) {
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found!"));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void create(@RequestBody Workout workout) {
        repository.save(workout);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@RequestBody Workout workout, @PathVariable Integer id) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found");
        }
        repository.save(workout);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        repository.deleteById(id);
    }

}
