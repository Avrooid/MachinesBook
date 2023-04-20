package ru.Burakov.MachinesBook.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.Burakov.MachinesBook.models.CarBrand;
import ru.Burakov.MachinesBook.services.CarBrandService;

import java.io.IOException;
import java.util.List;

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
