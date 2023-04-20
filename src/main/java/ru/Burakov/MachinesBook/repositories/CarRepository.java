package ru.Burakov.MachinesBook.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.Burakov.MachinesBook.models.Car;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findCarByCarBrandId(Long id);
}
