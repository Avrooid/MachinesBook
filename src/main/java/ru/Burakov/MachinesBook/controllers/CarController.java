package ru.Burakov.MachinesBook.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.Burakov.MachinesBook.models.Car;
import ru.Burakov.MachinesBook.services.CarBrandService;
import ru.Burakov.MachinesBook.services.CarService;

@Controller
@RequestMapping("/brands")
@RequiredArgsConstructor
public class CarController {
    private final CarService carService;
    private final CarBrandService carBrandService;


    @GetMapping("/{id}")
    public String showBrand(@PathVariable Long id, Model model) {
        model.addAttribute("cars", carService.getCarsByBrandId(id));
        return "brandCars";
    }

    @GetMapping("/{id}/add")
    public String getFormForCar(@PathVariable Long id,  Model model) {
        Car car = new Car();
        car.setCarBrand(carBrandService.getBrandById(id));
        model.addAttribute("car", car);
        return "addCar";
    }

    @PostMapping("/car/add")
    public String saveCar(Car car) {
        carService.saveCar(car);
        return "redirect:/brands";
    }
}
