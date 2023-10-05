package ru.Burakov.MachinesBook.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.Burakov.MachinesBook.models.CarBrand;
import ru.Burakov.MachinesBook.repositories.CarBrandRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarBrandService {
    private final CarBrandRepository carBrandRepository;

    public List<CarBrand> getAllBrands() {
        return carBrandRepository.findAll();
    }
    public void addBrand(CarBrand carBrand) {
        carBrandRepository.saveAndFlush(carBrand);
    }

    public CarBrand getBrandById(Long id) {
        return carBrandRepository.getById(id);
    }
}
