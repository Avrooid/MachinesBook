package ru.Burakov.MachinesBook.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.Burakov.MachinesBook.models.CarBrand;
import ru.Burakov.MachinesBook.services.CarBrandService;

@Controller
@RequiredArgsConstructor
public class CarBrandController {
    private final CarBrandService carBrandService;

    @GetMapping("/brands")
    public String getBrands(Model model) {
        model.addAttribute("brands", carBrandService.getAllBrands());
        return "brands";
    }

    @GetMapping("/brands/add")
    public String getForm(Model model) {
        model.addAttribute("carBrand", new CarBrand());
        return "addBrand";
    }

    @PostMapping("/brands/add")
    public String addBrand(@ModelAttribute("carBrand") CarBrand carBrand) {
        carBrandService.addBrand(carBrand);
        return "redirect:/brands";
    }
}
