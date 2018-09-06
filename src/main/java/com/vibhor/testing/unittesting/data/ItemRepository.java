package com.vibhor.testing.unittesting.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vibhor.testing.unittesting.modal.Item;

public interface ItemRepository extends JpaRepository<Item, Integer>{

}
