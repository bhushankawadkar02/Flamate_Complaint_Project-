package Flatmate.example.DTO;

public class UserDto {

    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private String username;
        private String password;
        private String email;
        private int flatCode;  // FlatCode to associate the user with a flat

        // Getters and Setters
        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public int getFlatCode() {
            return flatCode;
        }

        public void setFlatCode(int flatCode) {
            this.flatCode = flatCode;
        }


}


