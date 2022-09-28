package com.dsevoluction.sales.services;

import com.dsevoluction.sales.entities.Cliente;
import com.dsevoluction.sales.entities.ItemOrder;
import com.dsevoluction.sales.entities.Order;
import com.dsevoluction.sales.entities.Product;
import com.dsevoluction.sales.entities.dtos.ItemOrderDTO;
import com.dsevoluction.sales.entities.dtos.OrderDTO;
import com.dsevoluction.sales.entities.enums.OrderStatus;
import com.dsevoluction.sales.repositories.ClienteRepository;
import com.dsevoluction.sales.repositories.ItemOrderRepository;
import com.dsevoluction.sales.repositories.OrderRepository;
import com.dsevoluction.sales.repositories.ProductRepository;
import com.dsevoluction.sales.services.exceptions.RegraNegocioException;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ItemOrderRepository itemOrderRepository;


    public Order insert(OrderDTO dto) {

        Integer idClient = dto.getCliente();
        Cliente cliente = clienteRepository.findById(idClient).orElseThrow(() -> new RegraNegocioException("codigo do cliente invalido"));

        Order order = new Order();
        order.setTotal(dto.getTotal());
        order.setDate(new Date());
        order.setCliente(cliente);
        order.setStatus(dto.getStatus());

        List<ItemOrder> itemOrders = convertItems(order, dto.getItems());
        orderRepository.save(order);
        itemOrderRepository.saveAll(itemOrders);
        order.setItemOrder(itemOrders);

        return order;
    }

    private List<ItemOrder> convertItems(Order order, List<ItemOrderDTO> items) {
        if (items.isEmpty()) {
            throw new RegraNegocioException("Não é possível realizar um pedido sem items.");
        }

        return items.stream().map(dto -> {
            Integer idProduct = dto.getProduto();

            Product product = productRepository.findById(idProduct).orElseThrow(()
                    -> new RegraNegocioException("codigo do produto não exite : " + idProduct));

            ItemOrder itemOrder = new ItemOrder();
            itemOrder.setQuantity(dto.getQuantity());
            itemOrder.setOrder(order);
            itemOrder.setProduct(product);
            return itemOrder;
        }).collect(Collectors.toList());
    }

    public Order informationOrder(Integer id){
        Optional<Order> order = orderRepository.findById(id);
        return order.orElseThrow(()-> new RegraNegocioException("id não existe " +id));
    }

    public void upDate(Integer id, Order order){
        Order obj = orderRepository.getReferenceById(id);
        upDateStatus(obj, order);
        orderRepository.save(obj);
    }

    private void upDateStatus(Order obj, Order order){
        obj.setStatus(order.getStatus());
    }
}