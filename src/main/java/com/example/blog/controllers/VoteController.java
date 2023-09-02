package com.example.blog.controllers;


import com.example.blog.entities.Vote;
import com.example.blog.services.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/votes")
public class VoteController {
    private final VoteService voteService;

    @Autowired
    public VoteController(VoteService voteService) {
        this.voteService = voteService;
    }

    @PostMapping
    public ResponseEntity<Vote> createVote(@RequestBody Vote vote) {
        Vote createdVote = voteService.createVote(vote);
        return new ResponseEntity<>(createdVote, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vote> updateVote(@PathVariable("id") Long id, @RequestBody Vote vote) {
        if (!voteService.getVoteById(id).isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        vote.setId(id);
        Vote updatedVote = voteService.updateVote(vote);
        return new ResponseEntity<>(updatedVote, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVote(@PathVariable("id") Long id) {
        if (!voteService.getVoteById(id).isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        voteService.deleteVote(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vote> getVoteById(@PathVariable("id") Long id) {
        return voteService.getVoteById(id)
                .map(vote -> new ResponseEntity<>(vote, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @GetMapping
    public ResponseEntity<List<Vote>> getAllVotes() {
        List<Vote> votes = voteService.getAllVotes();
        return new ResponseEntity<>(votes, HttpStatus.OK);
    }

    @GetMapping("/bypid/{pid}")
    public ResponseEntity<List<Vote>> getVotesByPid(@PathVariable("pid") Long pid) {
        List<Vote> votes = voteService.getVotesByPid(pid);
        return new ResponseEntity<>(votes, HttpStatus.OK);
    }
}
