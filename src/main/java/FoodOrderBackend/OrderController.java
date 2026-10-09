package FoodOrderBackend;

import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/orders")
@CrossOrigin(origins = {"http://localhost:5173" , "https://24eg107h23.netlify.app"})
public class OrderController {

    private final OrderRepository orderRepository;

    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @PostMapping
    public Order placeOrder(@RequestBody Order order) {
        return orderRepository.save(order);
    }
    @GetMapping
public List<Order> getAllOrders() {
    return orderRepository.findAll();
}
@PutMapping("/{id}/status")
public Order updateOrderStatus(
        @PathVariable Long id,
        @RequestParam OrderStatus status) {

    Order order = orderRepository.findById(id).orElse(null);

    if (order == null) {
        return null;
    }

    order.setStatus(status);

    return orderRepository.save(order);
}
}