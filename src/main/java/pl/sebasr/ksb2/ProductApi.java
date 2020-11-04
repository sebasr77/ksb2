package pl.sebasr.ksb2;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductApi {

    @GetMapping
    public String getProducts()
    {
        return "Hello GET";
    }

    @PostMapping
    public String addProducts()
    {
        return "Hello POST";
    }

    @PutMapping
    public String modProducts()
    {
        return "Hello PUT";
    }
}
