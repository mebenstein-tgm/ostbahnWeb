package ostbahn.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import ostbahn.Entity.Bahnhof;
import ostbahn.Entity.Zug;

@Repository
public interface ZugRepository extends JpaRepository<Zug,Long> {


  

}