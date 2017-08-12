package cn.sierac.api;

import cn.sierac.common.result.Result;
import cn.sierac.entity.Fruit;
import cn.sierac.service.FruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Jack on 2017/7/21.
 */
@RestController
@RequestMapping(value = "/fruits")
public class FruitController {

    @Autowired
    private FruitService fruitService;

    @GetMapping("getall")
    public Object getAll(){
        return  new ResponseEntity<>(new Result(HttpStatus.OK.value(), fruitService.getAll(), HttpStatus.OK), HttpStatus.OK);
    }

    @PostMapping(value="inup",headers = {"Accept=application/json"})
    public Object inOrUp(@RequestBody Fruit fruit){
        List<Fruit> fruitList = fruitService.getAll();
        for(Fruit f : fruitList){
            if(fruit.getId() == f.getId()){
                fruitService.updateFruit(fruit);
            }
            else if(fruit.getId()==null || fruit.getId() < 0){
                fruitService.insertFruit(fruit);
                break;
            }
        }
        return new ResponseEntity<>(new Result(HttpStatus.OK.value(), fruitService.getAll(), HttpStatus.OK), HttpStatus.OK);
    }

    @PostMapping(value="delete",headers = {"Accept=application/json"})
    public Object delete(@RequestBody Fruit fruit){
        if(fruit.getId() != null && fruit.getId() > 0) {
            fruitService.deleteFruit(fruit.getId());
        }
        return new ResponseEntity<>(new Result(HttpStatus.OK.value(), fruitService.getAll(), HttpStatus.OK), HttpStatus.OK);
    }

    @PostMapping(value="getByShop",headers = {"Accept=application/json"})
    public Object getByShop(@RequestBody Fruit fruit){
        return new ResponseEntity<>(new Result(HttpStatus.OK.value(), fruitService.getByShop(fruit.getSid()), HttpStatus.OK), HttpStatus.OK);
    }


}
