package ru.Burakov.MachinesBook.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.Burakov.MachinesBook.models.MyUser;

public interface MyUserRepository extends JpaRepository<MyUser, Long> {
    MyUser findByUsername(String username);
}
