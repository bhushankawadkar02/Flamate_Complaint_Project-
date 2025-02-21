package Flatmate.example.Service;


import Flatmate.example.DTO.UserDto;
import Flatmate.example.Enities.Flat;
import Flatmate.example.Enities.User;

import Flatmate.example.Repositary.FlatRepo;
import Flatmate.example.Repositary.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private FlatRepo flatRepo;


   public List<User> list = new ArrayList<>();

   public  UserService(){

   }

   public List<User> getallUser(){

       return userRepo.findAll();
   }


//   public User createUser(UserDto user1){
//       user1.setId(UUID.randomUUID().toString());
//       System.out.println("yaha aa gya");
//       user1.setPassword(passwordEncoder.encode(user1.getPassword()) );
//       return userRepo.save(user1);
//   }

    public boolean registerUser(UserDto userDto) {
        // Fetch flat by flatCode
       Flat flat1 = new Flat();
        int nu= userDto.getFlatCode();

        System.out.println(nu);
        flat1.setFlatCode(nu);
       Flat flat=flatRepo.save(flat1);
        userDto.setId(UUID.randomUUID().toString());
        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()) );
        if (flat == null) {
            System.out.println("fali fklat");
            return false; // Flat not found
        }

        // Create new User
        User newUser = new User(userDto.getId(),userDto.getUsername(), userDto.getPassword(), userDto.getEmail(), 0, flat);

     User saveuser=   userRepo.save(newUser);
     if(saveuser != null) {// Save user to the database
         return true;
     }
     else {
         System.out.println("fali user");
         return false;
     }
    }
}
