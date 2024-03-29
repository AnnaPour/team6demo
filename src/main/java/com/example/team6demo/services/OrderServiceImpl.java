package com.example.team6demo.services;


import com.example.team6demo.model.Customer;
import com.example.team6demo.model.Order;
import com.example.team6demo.model.OrderItem;
import com.example.team6demo.model.Product;
import com.example.team6demo.model.*;
import com.example.team6demo.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public abstract class OrderServiceImpl extends BaseServiceImpl<Order> implements OrderService {
	private final OrderRepository orderRepository;

	@Override
	protected JpaRepository<Order, Long> getRepository() {
		return orderRepository;
	}

	@Override
	public Order initiateOrder(final Customer customer) {
		return Order.builder().customer(customer).build();
	}

	@Override
	public void addItem(final Order order, final Product product, final int quantity) {
		if (checkNullability(order, product)) {
			return;
		}

		boolean increasedQuantity = false;

		// If product is already contained in the order, don't add it again, just increase the quantity accordingly
		for (OrderItem oi : order.getOrderItems()) {
			if (oi.getProduct().getSerial().equals(product.getSerial())) {
				oi.setQuantity(oi.getQuantity() + quantity);
				increasedQuantity = true;
				break;
			}
		}

		if (!increasedQuantity) {
			order.getOrderItems().add(newOrderItem(order, product, quantity));
		}

		logger.trace("Product[{}] added to Order[{}]", product, order);
	}

	@Override
	public void updateItem(final Order order, final Product product, final int quantity) {
		if (checkNullability(order, product)) {
			return;
		}

		order.getOrderItems().removeIf(oi -> oi.getProduct().getSerial().equals(product.getSerial()));
		order.getOrderItems().add(newOrderItem(order, product, quantity));

		logger.trace("Product[{}] updated in Order[{}]", product, order);
	}

	@Override
	public void removeItem(final Order order, final Product product) {
		if (checkNullability(order, product)) {
			return;
		}

		order.getOrderItems().removeIf(oi -> oi.getProduct().getSerial().equals(product.getSerial()));
		logger.trace("Product[{}] removed from Order[{}]", product, order);
	}

	@Override
	public Order checkout(final Order order, final PaymentMethod paymentMethod) {
		if (!validate(order)) {
			logger.error("Order validation failed for checkout. Order: {}", order);
			throw new IllegalArgumentException("Order is not in a valid state for checkout");
		}

		order.setPaymentMethod(paymentMethod);
		order.setSubmitDate(new Date());
		order.setCost(giveFinalCost(order));
		order.setStatus(OrderStatus.COMPLETED);

		return create(order);

	}

	public Optional<Order> findWithCustomer(Long id) {
		return orderRepository.findWithCustomer(id);
	}

	public Optional<Order> findWithAllAssociations(Long id) {
		return orderRepository.findWithAllAssociations(id);
	}

	private boolean checkNullability(Order order, Product product) {
		if (order == null) {
			logger.warn("Order is null therefore it cannot be processed.");
			return true;
		}
		if (product == null) {
			logger.warn("Product is null therefore it cannot be added to an order.");
			return true;
		}
		return false;
	}

	private boolean validate(Order order) {
		return order != null && !order.getOrderItems().isEmpty() && order.getCustomer() != null;
	}

	private OrderItem newOrderItem(Order order, Product product, int quantity) {
		return OrderItem.builder().product(product).quantity(quantity).price(product.getPrice()).order(order).build();
	}

	private BigDecimal giveFinalCost(Order order) {

		BigDecimal finalCost = order.getOrderItems()
									   .stream()
									   .map(oi -> oi.getPrice().multiply(BigDecimal.valueOf(oi.getQuantity())))
									   .reduce(BigDecimal.ZERO, BigDecimal::add);


		return finalCost;
	}
}

