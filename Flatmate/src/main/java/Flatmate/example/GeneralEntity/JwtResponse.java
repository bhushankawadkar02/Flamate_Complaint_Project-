package Flatmate.example.GeneralEntity;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Builder
public class JwtResponse {

    private String jwtToken;
    private String username;

    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    public String getUsername() {
        return username;
    }

    public JwtResponse(String jwtToken, String username) {
        this.jwtToken = jwtToken;
        this.username = username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
