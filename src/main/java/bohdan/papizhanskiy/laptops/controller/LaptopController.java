package bohdan.papizhanskiy.laptops.controller;

import bohdan.papizhanskiy.laptops.dto.request.LaptopFilterRequest;
import bohdan.papizhanskiy.laptops.dto.request.LaptopRequest;
import bohdan.papizhanskiy.laptops.dto.request.PaginationRequest;
import bohdan.papizhanskiy.laptops.dto.response.DataResponse;
import bohdan.papizhanskiy.laptops.dto.response.LaptopResponse;
import bohdan.papizhanskiy.laptops.exception.WrongInputException;
import bohdan.papizhanskiy.laptops.service.LaptopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/laptop")
public class LaptopController {

    @Autowired
    private LaptopService laptopService;

    @PostMapping
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public LaptopResponse save(@RequestBody LaptopRequest laptopRequest) throws WrongInputException {
        return laptopService.save(laptopRequest);
    }

    @GetMapping
//    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public List<LaptopResponse> findAll(){
        return laptopService.findAll();
    }

//    @GetMapping("/findAllByMake")
//    public List<LaptopResponse> findAllByMake(@RequestBody LaptopRequest laptopRequest) throws WrongInputException {
//        return laptopService.findAllByMake(laptopRequest);
//    }



    @PutMapping
//    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public LaptopResponse update(@RequestParam Long id, @RequestBody LaptopRequest laptopRequest) throws WrongInputException {
        return laptopService.update(id, laptopRequest);
    }

    @DeleteMapping
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public void delete (@RequestParam Long id ) throws WrongInputException{
        laptopService.delete(id);
    }

    @PostMapping("/findOne")
//    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public LaptopResponse findOne (@RequestParam Long id) throws WrongInputException {
        return new LaptopResponse(laptopService.findOne(id));
    }

    @PostMapping("/filter")
    public DataResponse<LaptopResponse> findByFilter (@RequestBody LaptopFilterRequest laptopFilterRequest){
        return laptopService.findByFilter(laptopFilterRequest);
    }

    @PostMapping("/page")
    public DataResponse<LaptopResponse> getPage(@RequestBody PaginationRequest request){
        return laptopService.findAll(request);
    }
}
