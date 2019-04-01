package bohdan.papizhanskiy.laptops.repository;

import bohdan.papizhanskiy.laptops.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Optional<Customer> findByLoginEquals(String login);
}
