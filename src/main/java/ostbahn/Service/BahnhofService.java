package ostbahn.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import ostbahn.Repository.BahnhofRepository;
import ostbahn.Entity.Bahnhof;

import java.util.List;

@Service
public class BahnhofService {
    @Autowired
    BahnhofRepository repo;

    public Bahnhof save(Bahnhof S){
        return repo.save(S);
    }

    @ModelAttribute("bahnhofs")
    public List<Bahnhof> getAll(){
        return repo.findAll();
    }


    public Bahnhof findByName(String s){
        return repo.findByName(s);
    }
}
