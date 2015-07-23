package com.mycompany;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bhavsarer on 7/15/15.
 */
@Controller
@RequestMapping("/orders")
//@Api(value="/orders",description = "Order Service which provides CRUD operation for Order Resource")
public class OrderController {

    private static List<Order> orders = new ArrayList<Order>();

    static {
        orders.add(new Order(1,"Order No. 1",100.12));
        orders.add(new Order(2,"Order No. 2",200.22));
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
//    @ApiOperation(value="/",notes = "Return All Orders !!!", response = List.class, responseContainer = "List")
    public List<Order> getAllOrders(){
        return orders;
    }

    @RequestMapping(value = "/{order-id}",method = RequestMethod.GET)
    @ResponseBody
    public Order getOrder(@PathVariable("order-id")String orderId, @RequestParam("order-no") String orderNo){
        for(Order o : orders){
            if(o.getId()==Integer.parseInt(orderId))
                return o;
        }
        return null;
    }

    // 1. POST request URI does not include unique identification of resource in path
    // 2. if resource is already existing with id provided associated with error, it will return duplicate error
    @RequestMapping(value = "",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    public void saveOrder(@RequestBody Order order){
        // as this is po
        orders.add(order);
    }

    // 1. PUT Request are idempotent, which means that resource will be created if not existing.
    // 2. If resource is existing it will perform update operation
    @RequestMapping(value = "/{order-id}",method = RequestMethod.PUT,consumes = MediaType.APPLICATION_JSON_VALUE)
    public void saveOrUpdateOrder(@PathVariable("order-id")String orderId, @RequestBody Order order){
        orders.add(order);
    }

    @RequestMapping(value="/{order-id}",method=RequestMethod.DELETE,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public OrderResp deleteOrder(@PathVariable("order-id")String orderId){
        Order rOrder = null;
        for(Order o : orders){
            if(o.getId() == Integer.parseInt(orderId)) {
                rOrder = o;
                orders.remove(rOrder);
                return new OrderResp("Order Deleted");
            }
        }
        throw new OrderNotFoundException();
    }
}
