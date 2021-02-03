package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domain.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {

}
