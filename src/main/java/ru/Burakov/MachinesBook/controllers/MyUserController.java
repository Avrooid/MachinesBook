package ru.Burakov.MachinesBook.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.Burakov.MachinesBook.requests.RegisterRequest;
import ru.Burakov.MachinesBook.services.MyUserService;

@Controller
@RequiredArgsConstructor
public class MyUserController {
    private final MyUserService userService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/registration")
    public String getRegisterPage(Model model) {
        model.addAttribute("request", new RegisterRequest());
        return "registration";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute("request") RegisterRequest request) {
        userService.register(request);
        return "redirect:/login";
    }
}
