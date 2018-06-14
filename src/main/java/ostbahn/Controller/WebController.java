package ostbahn.Controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ostbahn.FakeDataGenerator;
import ostbahn.Repository.ZugRepository;
import ostbahn.Service.BahnhofService;
import ostbahn.Service.ZugService;
import ostbahn.Entity.*;
import ostbahn.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;
import javax.persistence.ManyToOne;
import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class WebController {


    @Autowired
    private UserService userService;

    @Autowired
    private BahnhofService bahnhofRepo;

    @Autowired
    private ZugService zugRepo;

    @PostConstruct
    public void init() {
        Benutzer s = new Benutzer();
        s.setNachName("admin");
        s.seteMail("ad@min.at");
        s.setPasswort("1234");

        userService.saveUser(s);

        ArrayList<Bahnhof> bahnhofs = new ArrayList<>();

        for (String a : FakeDataGenerator.bahnhofNames)
            bahnhofs.add(bahnhofRepo.save(new Bahnhof(a, (int) (Math.random() * 200), (int) (Math.random() * 1000), (int) (Math.random() * 6000), false)));

        for (int i = 0; i < 30; ++i)
            for (Bahnhof a : bahnhofs)
                for (Bahnhof b : bahnhofs)
                    if (a.getName() != b.getName()) {
                        Date date = new Date(new Date().getTime() + (int) (Math.random() * i * 3600 * 48 * 1000));
                        zugRepo.save(new Zug(date, (int) (Math.random() * 500), (int) (Math.random() * 40), (int) (Math.random() * 20), a, b));
                    }


    }

    @GetMapping("/{page}")
    public ModelAndView rice(@PathVariable("page") String page){
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        Benutzer user = userService.findUserByEMail((String)auth.getPrincipal());

        modelAndView.setViewName(page);
        return modelAndView;
    }

    @GetMapping(value = {"/shops/{type}"})
    public ModelAndView shops(@PathVariable("type") String type) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("shops/"+type);

        modelAndView.addObject("bahnhofs",bahnhofRepo.getAll());


        return modelAndView;
    }

    @GetMapping(value="/admin")
    public ModelAndView admin(){
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("admin");
            List<Benutzer> benutzer = userService.getAll();

            System.out.println(benutzer.size());

            modelAndView.addObject("benutzers",benutzer);
            modelAndView.addObject("benutzer",new Benutzer());

            return modelAndView;
    }

    @PostMapping(value = "/admin",produces = "application/json", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ModelAndView adminAddUser(@RequestBody Benutzer b){
        userService.saveUser(b);

        return admin();
    }

    @GetMapping("/zugs")
    public List<Zug> getZugs(@RequestParam("from") String start, @RequestParam("to") String ende){
        Strecke s = new Strecke(bahnhofRepo.findByName(start.replace("'","")),bahnhofRepo.findByName(ende.replace("'","")));
        return zugRepo.getZugsForReservation(s);
    }

    @GetMapping("/zug")
    public Zug getZug(@RequestParam("id")String id){
        return zugRepo.getByID(Long.parseLong(id));
    }
}
