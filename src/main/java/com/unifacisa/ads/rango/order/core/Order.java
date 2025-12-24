package com.unifacisa.ads.rango.order.core;

import com.unifacisa.ads.rango.costumer.core.Costumer;
import com.unifacisa.ads.rango.infrastructure.exceptions.BadRequestException;
import com.unifacisa.ads.rango.item.core.Item;
import com.unifacisa.ads.rango.payment.core.Payment;
import com.unifacisa.ads.rango.payment.core.PaymentStatusEnum;
import com.unifacisa.ads.rango.product.core.Product;
import com.unifacisa.ads.rango.restaurant.core.Restaurant;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class Order {

    private UUID id;

    private Costumer costumer;

    private Restaurant restaurant;

    private List<Item> items = new ArrayList<>();

    private OrderStatusEnum orderStatus;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private BigDecimal totalValue;

    private Payment payment;


    public static Order create(Costumer costumer, Restaurant restaurant){
        return new Order(costumer, restaurant, OrderStatusEnum.DRAFT, LocalDateTime.now());
    }

    public void setStautsWaitPayment(){
        if (this.orderStatus != OrderStatusEnum.DRAFT) throw new BadRequestException("Invalid operation");
        this.orderStatus = OrderStatusEnum.WAIT_PAYMENT;
        this.updatedAt = LocalDateTime.now();
    }

    public void setStautsConfirmed(){
        if (this.orderStatus != OrderStatusEnum.WAIT_PAYMENT) throw new BadRequestException("Invalid operation");
        if (this.payment.getStatus() != PaymentStatusEnum.CONFIRMED) throw new BadRequestException("Payment not confirmed");
        this.orderStatus = OrderStatusEnum.CONFIRMED;
        this.updatedAt = LocalDateTime.now();
    }

    public void setStautsBeingPrepared(){
        if (this.orderStatus != OrderStatusEnum.CONFIRMED) throw new BadRequestException("Invalid operation");
        this.orderStatus = OrderStatusEnum.BEING_PREPARED;
        this.updatedAt = LocalDateTime.now();
    }

    public void setStautsReady(){
        if (this.orderStatus != OrderStatusEnum.BEING_PREPARED) throw new BadRequestException("Invalid operation");
        this.orderStatus = OrderStatusEnum.READY;
        this.updatedAt = LocalDateTime.now();
    }

    public void setStautsFinished(){
        if (this.orderStatus != OrderStatusEnum.READY) throw new BadRequestException("Invalid operation");
        this.orderStatus = OrderStatusEnum.FINISHED;
        this.updatedAt = LocalDateTime.now();
    }

    public void setStautsCanceled(){
        if (this.orderStatus == OrderStatusEnum.DRAFT) throw new BadRequestException("Invalid operation");
        this.orderStatus = OrderStatusEnum.CANCELED;
        this.updatedAt = LocalDateTime.now();
    }

    public void addItem(Product product, int quantity, Restaurant restaurant) {
        // Business rule: Do not add items to an order that is not DRAFT
        if (this.orderStatus != OrderStatusEnum.DRAFT) throw new BadRequestException("You can't add items to an order that isn't in draft.");


        // Business rule: Ensures that the item is from the same restaurant as the order
        if (this.restaurant == null) {
            this.restaurant = restaurant;
            // If it's the first item, set the restaurant of the order
        } else if (!this.restaurant.getId().equals(restaurant.getId())) {
            throw new BadRequestException("It is not possible to add products from different restaurants in the same order.");
        }

        // 2. Looks for the item already in the list
        Optional<Item> existingItem = findItemByProductId(product.getId());

        if (existingItem.isPresent()) {
            // If the item exists, it only updates the quantity
            existingItem.get().increaseQuantity(quantity);
        } else {
            // If it does not exist, creates a new ItemOrder and adds it to the list
            Item newItem = new Item(product, quantity);
            if (!(this.items instanceof ArrayList)) {
                this.items = new ArrayList<>(this.items);
            }
            this.items.add(newItem);
        }
        calculateTotalValue();
    }

    public void removeItem(Product product, Restaurant restaurant) {
        // Business rule: Do not add items to an order that is not DRAFT
        if (this.orderStatus != OrderStatusEnum.DRAFT) throw new BadRequestException("You can't remove items from an order that isn't in draft.");

        //Business rule: Ensures that the item is from the same restaurant as the order
        if (this.restaurant == null) {
            this.restaurant = restaurant;
            // If it's the first item, set the restaurant of the order
        } else if (!this.restaurant.getId().equals(restaurant.getId())) {
            throw new BadRequestException("It is not possible to remove products from different restaurants in the same order.");
        }

        // 2. Looks for the item already in the list
        Optional<Item> existingItem = findItemByProductId(product.getId());

        if (existingItem.isEmpty()) throw new BadRequestException("Item not found in order");

        if (existingItem.get().getQuantity() > 1) {
            // 3a. If there is more than one item, decrease the quantity
            existingItem.get().decreaseQuantity();
        } else {
            // 3b. If there is only one item, remove from the list

            if (!(this.items instanceof ArrayList)) {
                this.items = new ArrayList<>(this.items);
            }
            this.items.remove(existingItem);
        }
        calculateTotalValue();
    }

    // Private helper method to find the item
    private Optional<Item> findItemByProductId(UUID productId) {
        return this.items.stream()
                .filter(item -> item.getProduct().getId().equals(productId))
                .findFirst();
    }

    // Private method to keep the total up to date
    private void calculateTotalValue() {
        this.totalValue = this.items.stream()
                .map(Item::getSubtotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public Order() {
    }

    public Order(Costumer costumer, Restaurant restaurant, OrderStatusEnum orderStatus, LocalDateTime createdAt) {
        this.costumer = costumer;
        this.restaurant = restaurant;
        this.orderStatus = orderStatus;
        this.createdAt = createdAt;
    }

    public Order(UUID id, Costumer costumer, Restaurant restaurant, List<Item> items, OrderStatusEnum orderStatus, LocalDateTime createdAt, LocalDateTime updatedAt, BigDecimal totalValue, Payment payment) {
        this.id = id;
        this.costumer = costumer;
        this.restaurant = restaurant;
        this.items = items;
        this.orderStatus = orderStatus;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.totalValue = totalValue;
        this.payment = payment;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Costumer getCostumer() {
        return costumer;
    }

    public void setCostumer(Costumer costumer) {
        this.costumer = costumer;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public OrderStatusEnum getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatusEnum orderStatus) {
        this.orderStatus = orderStatus;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public BigDecimal getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(BigDecimal totalValue) {
        this.totalValue = totalValue;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}
