package Flatmate.example.DTO;

public class LeaderboardDTO {
    private String email;
    private int karmaPoints;

    public LeaderboardDTO(String email, int karmaPoints) {
        this.email = email;
        this.karmaPoints = karmaPoints;
    }

    // Getters and Setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getKarmaPoints() {
        return karmaPoints;
    }

    public void setKarmaPoints(int karmaPoints) {
        this.karmaPoints = karmaPoints;
    }
}
