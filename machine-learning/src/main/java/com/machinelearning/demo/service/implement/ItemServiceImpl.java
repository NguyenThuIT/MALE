package com.machinelearning.demo.service.implement;

import com.machinelearning.demo.api.dto.ItemDTO;
import com.machinelearning.demo.api.dto.created.ItemCreatedDTO;
import com.machinelearning.demo.api.mapper.ItemMapper;
import com.machinelearning.demo.domain.Item;
import com.machinelearning.demo.domain.Order1;
import com.machinelearning.demo.domain.Product;
import com.machinelearning.demo.exception.ResourceNotFoundException;
import com.machinelearning.demo.repository.ItemRepository;
import com.machinelearning.demo.repository.Order1Repository;
import com.machinelearning.demo.repository.ProductRepository;
import com.machinelearning.demo.service.ItemService;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;
    private final ItemMapper itemMapper;
    private final Order1Repository order1Repository;
    private final ProductRepository productRepository;

    public ItemServiceImpl(ItemRepository itemRepository, ItemMapper itemMapper, Order1Repository order1Repository, ProductRepository productRepository) {
        this.itemRepository = itemRepository;
        this.itemMapper = itemMapper;
        this.order1Repository = order1Repository;
        this.productRepository = productRepository;
    }

    @Override
    public Set<ItemDTO> getAllItem() {
        return itemRepository.findAll()
                .stream()
                .map(itemMapper::itemToItemDTO)
                .collect(Collectors.toSet());
    }

    @Override
    public ItemDTO getSingleItem(Integer itemId) {
        Optional<Item> optionalItem = itemRepository.findById(itemId);
        if (!optionalItem.isPresent()) {
            throw new ResourceNotFoundException("Item " + itemId + " not found");
        } else {
            return itemMapper.itemToItemDTO(optionalItem.get());
        }
    }

    @Override
    public ItemDTO addItem(ItemCreatedDTO itemCreatedDTO) {
        Optional<Order1> optionalOrder1 = order1Repository.findById(itemCreatedDTO.getOrderId());
        Optional<Product> optionalProduct = productRepository.findById(itemCreatedDTO.getProductId());
        if (optionalOrder1.isPresent() && optionalProduct.isPresent()) {

            Order1 order1 = optionalOrder1.get();
            Product product = optionalProduct.get();

            Item item = new Item();
            item.setAmount(itemCreatedDTO.getAmount());
            item.setCost(itemCreatedDTO.getCost());
            item.setOrder1(order1);
            item.setProduct(product);
            itemRepository.save(item);

            order1.getItems().add(item);
            product.getItems().add(item);

            order1Repository.save(order1);
            productRepository.save(product);
            return itemMapper.itemToItemDTO(item);
        } else {
            throw new ResourceNotFoundException("Order " + itemCreatedDTO.getOrderId() + " & Product " + itemCreatedDTO.getProductId() + " not found");
        }

    }

    @Override
    public void deleteItem(Integer itemId) {
        Optional<Item> optionalItem = itemRepository.findById(itemId);
        if (optionalItem.isPresent()) {
            Product product = optionalItem.get().getProduct();
            Order1 order1 = optionalItem.get().getOrder1();
            order1Repository.save(order1.removeItem(optionalItem.get()));
            productRepository.save(product.removeItem(optionalItem.get()));
            itemRepository.deleteById(itemId);
        } else {
            throw new ResourceNotFoundException("Item " + itemId + " not found");
        }
    }
}
