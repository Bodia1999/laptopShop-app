package bohdan.papizhanskiy.laptops.controller;

import bohdan.papizhanskiy.laptops.dto.request.LaptopRequest;
import bohdan.papizhanskiy.laptops.dto.response.LaptopResponse;
import bohdan.papizhanskiy.laptops.exception.WrongInputException;
import bohdan.papizhanskiy.laptops.service.LaptopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/laptop")
public class LaptopController {

    @Autowired
    private LaptopService laptopService;

    @PostMapping
    public LaptopResponse save(@RequestBody LaptopRequest laptopRequest) throws WrongInputException {
        return laptopService.save(laptopRequest);
    }

    @GetMapping
    public List<LaptopResponse> findAll(){
        return laptopService.findAll();
    }

//    @GetMapping("/findAllByMake")
//    public List<LaptopResponse> findAllByMake(@RequestBody LaptopRequest laptopRequest) throws WrongInputException {
//        return laptopService.findAllByMake(laptopRequest);
//    }



    @PutMapping
    public LaptopResponse update(@RequestParam Long id, @RequestBody LaptopRequest laptopRequest) throws WrongInputException {
        return laptopService.update(id, laptopRequest);
    }
}
