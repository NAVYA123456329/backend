package FoodOrderBackend;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "food_orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String address;

    @Column(name = "order_time")
    private LocalDateTime orderTime;

    private String payment;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    private double total;

    @Column(name = "user_id")
    private Long userId;

    public Order() {
    }

    public Long getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public String getPayment() {
        return payment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public double getTotal() {
        return total;
    }

    public Long getUserId() {
        return userId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}