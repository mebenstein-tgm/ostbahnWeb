package ostbahn.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import ostbahn.Entity.Bahnhof;

@Component
public interface BahnhofRepository extends JpaRepository<Bahnhof,Long> {

    Bahnhof findByName(String s);

}