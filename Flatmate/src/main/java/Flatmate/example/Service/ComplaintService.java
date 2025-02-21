package Flatmate.example.Service;


import Flatmate.example.DTO.ComplaintDto;
import Flatmate.example.GeneralEntity.ComplaintStatistics;
import Flatmate.example.DTO.LeaderboardDTO;
import Flatmate.example.Enities.Complaint;
import Flatmate.example.Enities.User;
import Flatmate.example.Repositary.ComplaintRepo;
import Flatmate.example.Repositary.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class ComplaintService {

    @Autowired
    private ComplaintRepo complaintRepo;

    @Autowired
    private UserRepo userRepo;
    public String getComplaint(ComplaintDto complaintDto){


        Complaint complaint = new Complaint(
                complaintDto.getTitle(),
                complaintDto.getDescription(),
                complaintDto.getComplaintType(),
                complaintDto.getSeverityLevel(),
                LocalDateTime.now(),
                complaintDto.getUserEmail()
        );
        complaintRepo.save(complaint);
        System.out.println("save hogi ");

        return "Complaint registered successfully!";
    }

    public List<Complaint> getAllCompliant(){
       return complaintRepo.findAll();
    }

    public String ResolveComplaint(Long id,String email){
       Complaint complaint= complaintRepo.findById(id).orElse(null);
     Optional<User> user=  userRepo.findByEmail(email);
     if(user.isPresent()){
        User existingUser = user.get();
        existingUser.setKarmaPoints(existingUser.getKarmaPoints()+10);
        userRepo.save(existingUser);
     }
       if(complaint != null){
           complaint.setResolved(true);
           complaintRepo.save(complaint);
           return "Resolve Successfully";
       }
       else {
           return "Cannot find a Compalint id";
       }
    }

    public String votetoup(Long id) {
        Complaint complaint= complaintRepo.findById(id).orElse(null);
        if(complaint != null){
        int num=  complaint.getVote();
        complaint.setVote(num+1);
            complaintRepo.save(complaint);
            return "Upvote done";
        }
        else {
            return "upvote cannot done";
        }
    }

    public String votetodown(Long id) {
        Complaint complaint= complaintRepo.findById(id).orElse(null);
        if(complaint != null){
            int num=  complaint.getVote();

            complaint.setVote(num-1);
            complaintRepo.save(complaint);
            return "downvote done";
        }
        else {
            return "downvote cannot done";
        }
    }
    public List<Complaint> trendingComplaint(){
        return complaintRepo.findTop3ByOrderByVoteDesc();
    }

    public List<LeaderboardDTO> getUserOnKarmaPoints() {
        List<User> users = userRepo.findAllByOrderByKarmaPointsDesc();

        // Create a list to hold the LeaderboardDTO objects
        List<LeaderboardDTO> leaderboard = new ArrayList<LeaderboardDTO>();

        // Iterate over the users list and populate the leaderboard
        for (User user : users) {
            LeaderboardDTO dto = new LeaderboardDTO(user.getEmail(), user.getKarmaPoints());
            leaderboard.add(dto);
        }

        // Return the populated leaderboard
        return leaderboard;
    }

    public ComplaintStatistics getComplaintStatistics() {

        // Get total number of complaints
        long totalComplaints = complaintRepo.count();

        // Get the number of resolved complaints
        long resolvedComplaints = complaintRepo.countByResolved(true);

        // Get the number of unresolved complaints
        long unresolvedComplaints = complaintRepo.countByResolved(false);

        // Get the number of complaints by each type (Noise, Cleanliness, etc.)
        List<Object[]> complaintsByType = complaintRepo.countComplaintsByType();

        // Map to hold complaints by type
        Map<String, Long> complaintsByTypeMap = new HashMap<>();
        for (Object[] row : complaintsByType) {
            complaintsByTypeMap.put((String) row[0], (Long) row[1]);
        }

        // Return all statistics in one object
        return new ComplaintStatistics(totalComplaints, resolvedComplaints, unresolvedComplaints, complaintsByTypeMap);
    }
}
