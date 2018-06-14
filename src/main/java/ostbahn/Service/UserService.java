package ostbahn.Service;

import ostbahn.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ostbahn.Entity.Benutzer;

import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository repo;

    @Autowired
    private BCryptPasswordEncoder bCrypt;


    @Override
    public Benutzer findUserByEMail(String email) {
        return repo.findByEMail(email);
    }

    @Override
    public void saveUser(Benutzer user) {
        user.setPasswort(bCrypt.encode(user.getPasswort()));
        user.setActive(1);
        repo.save(user);
    }

    public List<Benutzer> getAll(){
        return repo.findAll();
    }
}
