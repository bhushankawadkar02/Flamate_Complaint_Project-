package Flatmate.example.Controller;


import Flatmate.example.DTO.ComplaintDto;
import Flatmate.example.GeneralEntity.ComplaintStatistics;
import Flatmate.example.DTO.LeaderboardDTO;
import Flatmate.example.Enities.Complaint;
import Flatmate.example.GeneralEntity.VoteRequest;
import Flatmate.example.Service.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apis")
public class ComplaintController {


    @Autowired
    private ComplaintService complaintService;

    @PostMapping("/complaints")
    public ResponseEntity<String> getUser(@RequestBody ComplaintDto complaintDto, Authentication authentication) {
        String loggedInUserEmail = authentication.getName();


        complaintDto.setUserEmail(loggedInUserEmail);

        System.out.println("Logged-in user's email: " + loggedInUserEmail);
        return new ResponseEntity<>(complaintService.getComplaint(complaintDto), HttpStatus.OK);

    }

    @GetMapping("/complaints")
    public ResponseEntity<List<Complaint>> getAllComplaint() {
        return new ResponseEntity<>(complaintService.getAllCompliant(), HttpStatus.ACCEPTED);
    }

    @PutMapping("/complaints/{id}/resolve")
    public ResponseEntity<String> resolveComplaint(@PathVariable("id") Long id,@RequestParam String email) {

        return new ResponseEntity<>(complaintService.ResolveComplaint(id,email), HttpStatus.CREATED);
    }

    @PostMapping("/complaints/{id}/vote")
    public ResponseEntity<String> votingto(@PathVariable("id") Long id, @RequestBody VoteRequest vote) {
        String check = vote.getVote().toLowerCase();

        if (check.equals("upvote")) {
            return new ResponseEntity<>(complaintService.votetoup(id), HttpStatus.ACCEPTED);
        } else {

            return new ResponseEntity<>(complaintService.votetodown(id), HttpStatus.ACCEPTED);
        }

    }
    @GetMapping("/complaints/trending")
    public  ResponseEntity<List<Complaint>> getTrendingComplaint(){
        return new ResponseEntity<>(  complaintService.trendingComplaint(),HttpStatus.ACCEPTED);
    }

    @GetMapping("/leaderboard")
    public  ResponseEntity<List<LeaderboardDTO>> getleaderboard(){
        return new ResponseEntity<>( complaintService.getUserOnKarmaPoints(),HttpStatus.ACCEPTED);
    }
    @GetMapping("/statistics")
    public ResponseEntity<ComplaintStatistics> getComplaintStatistics() {
        ComplaintStatistics stats = complaintService.getComplaintStatistics();
        return new ResponseEntity<>(stats, HttpStatus.OK);
    }

}
