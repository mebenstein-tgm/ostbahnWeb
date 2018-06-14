package ostbahn.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ostbahn.Repository.ZugRepository;
import ostbahn.Entity.Strecke;
import ostbahn.Entity.Zug;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ZugService  {
    @Autowired
    ZugRepository repo;

    public Zug save(Zug z){
        return repo.save(z);
    }

    public List<Zug> getZugsForReservation(Strecke s){
        System.out.println(repo.findAll().size());
        return repo.findAll().stream().filter(z -> ( z.getStart() == s.getStart() && z.getEnde() == s.getEnde())).collect(Collectors.toList());
    }

    public Zug getByID(Long l){
        return repo.findById(l).get();
    }

    public List<Zug> getAll(){
        return repo.findAll();
    }
}
