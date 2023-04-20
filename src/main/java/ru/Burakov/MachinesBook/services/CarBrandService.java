package ru.Burakov.MachinesBook.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.Burakov.MachinesBook.models.CarBrand;
import ru.Burakov.MachinesBook.repositories.CarBrandRepository;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
