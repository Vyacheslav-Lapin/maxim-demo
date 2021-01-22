package ru.vlapin.demo.maximdemo.dao;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.vlapin.demo.maximdemo.model.Cat;

public interface CatRepository extends JpaRepository<Cat, UUID> {
}
