package Flatmate.example.Repositary;

import Flatmate.example.Enities.Flat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FlatRepo extends JpaRepository<Flat,Long> {
    Flat findByFlatCode(int flatCode);
}
