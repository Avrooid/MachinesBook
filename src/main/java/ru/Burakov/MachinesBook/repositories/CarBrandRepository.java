package ru.Burakov.MachinesBook.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.Burakov.MachinesBook.models.CarBrand;

public interface CarBrandRepository extends JpaRepository<CarBrand, Long> {

}
