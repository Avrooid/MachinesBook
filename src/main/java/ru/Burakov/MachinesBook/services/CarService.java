package ru.Burakov.MachinesBook.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.Burakov.MachinesBook.models.Car;
import ru.Burakov.MachinesBook.repositories.CarRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarService {
    private final CarRepository carRepository;

    public List<Car> getCarsByBrandId(Long id) {
        return carRepository.findCarByCarBrandId(id);
    }

    public void saveCar(Car car) {
        carRepository.saveAndFlush(car);
    }
}
