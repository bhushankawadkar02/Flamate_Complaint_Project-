package Flatmate.example.Repositary;

import Flatmate.example.Enities.Complaint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ComplaintRepo extends JpaRepository<Complaint,Long> {


    List<Complaint> findTop3ByOrderByVoteDesc();

    long countByResolved(boolean resolved);

    // Custom query to count complaints by type
    @Query("SELECT c.complaintType, COUNT(c) FROM Complaint c GROUP BY c.complaintType")
    List<Object[]> countComplaintsByType();
}
