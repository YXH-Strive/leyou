package com.leyou.item.service;

import com.leyou.item.pojo.Item;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * @author YXH
 * @date 2020/3/26 - 20:38
 */
@Service
public class ItemService {
    public Item savaItem(Item item) {
        int id = new Random().nextInt(100);
        item.setId(id);
        return item;
    }
}
