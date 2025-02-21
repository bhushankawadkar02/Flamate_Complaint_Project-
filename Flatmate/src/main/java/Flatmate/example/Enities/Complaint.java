package Flatmate.example.Enities;


import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Optional;

@Entity
@Table(name = "Complaints")
public class Complaint {




        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String title;
        private String description;

    private boolean resolved = false;

    public boolean isResolved() {
        return resolved;
    }

    public void setResolved(boolean resolved) {
        this.resolved = resolved;
    }

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }

    public Complaint() {
    }

    private String complaintType;
        private String severityLevel;
        private LocalDateTime timestamp;

        private String useremail;

        private int vote=0;

    public int getVote() {
        return vote;
    }

    public void setVote(int vote) {
        this.vote = vote;
    }

    // Constructor
        public Complaint(String title, String description, String complaintType, String severityLevel, LocalDateTime timestamp, String useremail) {
            this.title = title;
            this.description = description;
            this.complaintType = complaintType;
            this.severityLevel = severityLevel;
            this.timestamp = timestamp;
            this.useremail = useremail;
        }

        // Getters and Setters
        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getComplaintType() {
            return complaintType;
        }

        public void setComplaintType(String complaintType) {
            this.complaintType = complaintType;
        }

        public String getSeverityLevel() {
            return severityLevel;
        }

        public void setSeverityLevel(String severityLevel) {
            this.severityLevel = severityLevel;
        }

        public LocalDateTime getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(LocalDateTime timestamp) {
            this.timestamp = timestamp;
        }

        public String getUser() {
            return useremail;
        }

        public void setUser(String useremail) {
            this.useremail = useremail;
        }
    }



