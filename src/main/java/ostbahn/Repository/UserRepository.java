package ostbahn.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import ostbahn.Entity.Benutzer;

@Component
public interface UserRepository extends JpaRepository<Benutzer,Long> {
    Benutzer findByEMail(String s);

}