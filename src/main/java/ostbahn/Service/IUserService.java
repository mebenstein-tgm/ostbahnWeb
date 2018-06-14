package ostbahn.Service;

import ostbahn.Entity.Benutzer;

public interface IUserService {
    public Benutzer findUserByEMail(String email);
    public void saveUser(Benutzer user);
}
