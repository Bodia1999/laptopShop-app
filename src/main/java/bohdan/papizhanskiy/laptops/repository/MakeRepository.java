package bohdan.papizhanskiy.laptops.repository;

import bohdan.papizhanskiy.laptops.entity.Laptop;
import bohdan.papizhanskiy.laptops.entity.Make;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MakeRepository extends JpaRepository<Make, Long> {

    List<Make> findAllByName(String name);
    List<Make> findAllByNameLike(String name);
}
