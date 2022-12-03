package kai.study.controllers;

import kai.study.dao.ClientDAO;
import kai.study.models.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/start")
public class StartWithoutUserController {
    private final ClientDAO clientDAO;
    // Если был выполнен вход или регистрация
    private boolean isUser = false;
    private Client currentUser;

    @Autowired
    public StartWithoutUserController(ClientDAO clientDAO) {
        this.clientDAO = clientDAO;
    }

    // Самая начальная страница, без пользователя
    @GetMapping()
    public String start(Model model){
        model.addAttribute("user", isUser);
        if(currentUser != null){
            model.addAttribute("currentUser", currentUser);
        }
        return "start";
    }

    // Страница входа
    @GetMapping("/logIn")
    public String logIn(Model model){
        model.addAttribute("client", new Client());
        return "logIn";
    }

    // Страница регистрации
    @GetMapping("/signUp")
    public String signUp(Model model){
        model.addAttribute("client", new Client());
        return "signUp";
    }

    // Получаем данные с регистрации и выполняем добавление нового пользователя
    @PostMapping("/signup")
    public String signUpNewUser(@ModelAttribute("client") Client client){
        clientDAO.save(client);
        isUser = true;
        return "redirect:/start";
    }

    // Проверяем введённые данные и ищем такого поьзователя
    @PostMapping("/login")
    public String loginUser(@ModelAttribute("client") Client client){
        currentUser = clientDAO.read(client.getPassword());
        isUser = true;
        return "redirect:/start";
    }
}
