package Flatmate.example.DTO;

public class ComplaintDto {


        private String title;
        private String description;
        private String complaintType;
        private String severityLevel;
        private String userEmail; // Email of the user submitting the complaint

        // Constructor
        public ComplaintDto(String title, String description, String complaintType, String severityLevel, String userEmail) {
            this.title = title;
            this.description = description;
            this.complaintType = complaintType;
            this.severityLevel = severityLevel;
            this.userEmail = userEmail;
        }

        // Getters and Setters
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

        public String getUserEmail() {
            return userEmail;
        }

        public void setUserEmail(String userEmail) {
            this.userEmail = userEmail;
        }
    }



