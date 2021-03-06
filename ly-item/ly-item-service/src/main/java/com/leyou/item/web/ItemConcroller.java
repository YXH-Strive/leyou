package com.leyou.item.web;

import com.leyou.common.enums.ExceptionEnum;
import com.leyou.common.exception.LyException;
import com.leyou.item.pojo.Item;
import com.leyou.item.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author YXH
 * @date 2020/3/26 - 20:44
 */
@RestController
@RequestMapping("item")
public class ItemConcroller {
    @Autowired
    private ItemService itemService;

    @PostMapping
    public ResponseEntity<Item> saveItem(Item item){
        if (item.getPrice() == null) {
            throw new LyException(ExceptionEnum.PRICE_CANNOT_BE_NULL);
            //throw new RuntimeException("价格不能为空");
            //return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        item = itemService.savaItem(item);
        return ResponseEntity.status(HttpStatus.CREATED).body(item);
    }
}
