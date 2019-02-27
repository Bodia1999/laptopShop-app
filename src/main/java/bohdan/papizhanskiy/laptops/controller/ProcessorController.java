package bohdan.papizhanskiy.laptops.controller;


import bohdan.papizhanskiy.laptops.dto.request.ProcessorRequest;
import bohdan.papizhanskiy.laptops.dto.response.ProcessorResponse;
import bohdan.papizhanskiy.laptops.exception.WrongInputException;
import bohdan.papizhanskiy.laptops.service.ProcessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/processor")
public class ProcessorController {

    @Autowired
    private ProcessorService processorService;


    @GetMapping
    public List<ProcessorResponse> findAll() {
        return processorService.findAll();
    }


    @PostMapping
    public ProcessorResponse save(@RequestBody ProcessorRequest processorRequest) {
        return processorService.save(processorRequest);
    }

    @DeleteMapping
    public void delete(Long id) throws WrongInputException {
        processorService.delete(id);
    }

    @PutMapping
    public ProcessorResponse update(ProcessorRequest processorRequest, Long id) throws WrongInputException {
        return processorService.update(processorRequest, id);
    }

}
