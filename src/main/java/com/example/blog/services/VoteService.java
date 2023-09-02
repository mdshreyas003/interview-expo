package com.example.blog.services;

import com.example.blog.entities.Vote;
import com.example.blog.repositories.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VoteService {
    private final VoteRepository voteRepository;

    @Autowired
    public VoteService(VoteRepository voteRepository) {
        this.voteRepository = voteRepository;
    }

    public Vote createVote(Vote vote) {
        return voteRepository.save(vote);
    }

    public Vote updateVote(Vote vote) {
        return voteRepository.save(vote);
    }

    public void deleteVote(Long voteId) {
        voteRepository.deleteById(voteId);
    }

    public Optional<Vote> getVoteById(Long voteId) {
        return voteRepository.findById(voteId);
    }

    public List<Vote> getAllVotes() {
        return voteRepository.findAll();
    }
    public List<Vote> getVotesByPid(Long pid) {
        return voteRepository.findByPost_Pid(pid);
    }
}
