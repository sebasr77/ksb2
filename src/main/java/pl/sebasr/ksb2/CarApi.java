package pl.sebasr.ksb2;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cars")
public class CarApi {

    private final List<Car> carList;

    public CarApi() {
        carList = new ArrayList<>();

        carList.add(new Car(1L, "BMW", "M3", "black"));
        carList.add(new Car(2L, "Toyota", "RAV4", "white"));
        carList.add(new Car(3L, "Honda", "CRV", "gold"));
        carList.add(new Car(4L, "BMW", "M5", "black"));
    }

    @GetMapping(produces = {
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<List<Car>> getCars() {
        return new ResponseEntity<>(carList, HttpStatus.MULTI_STATUS);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable long id) {

        Optional<Car> first = carList.stream().filter(car -> car.getId() == id).findFirst();
        if (first.isPresent()) {
            return new ResponseEntity<>(first.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/color/{colorName}")
    public ResponseEntity<List<Car>> getCarByColor(@PathVariable String colorName) {

        List<Car> collect = carList.stream().filter(car -> car.getColor().equals(colorName)).collect(Collectors.toList());
        if (!collect.isEmpty()) {
            return new ResponseEntity<>(collect, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity addCar(@RequestBody Car newCar) {
        boolean add = carList.add(newCar);
        if (add) {
            return new ResponseEntity(HttpStatus.CREATED);
        }
        return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PutMapping
    public ResponseEntity updateCar(@RequestBody Car newCar) {
        Optional<Car> first = carList.stream().filter(car -> car.getId() == newCar.getId()).findFirst();

        if (first.isPresent()) {
            carList.remove(first.get());
            carList.add(newCar);
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity removeCar(@PathVariable long id) {
        Optional<Car> first = carList.stream().filter(car -> car.getId() == id).findFirst();
        if (first.isPresent()) {
            carList.remove(first.get());
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @PatchMapping("/{id}/{property}/{value}")
    public ResponseEntity modifyCar(@PathVariable long id, @PathVariable String property, @PathVariable String value) {
        Optional<Car> optionalCar = carList.stream().filter(car -> car.getId() == id).findFirst();
        if (!optionalCar.isPresent()) return new ResponseEntity(HttpStatus.NOT_FOUND);

        Car car = optionalCar.get();
        boolean updated = true;

        switch (property) {
            case "mark":
                car.setMark(value);
                break;
            case "model":
                car.setModel(value);
                break;
            case "color":
                car.setColor(value);
                break;
            default:
                updated = false;


        }
        if (updated)
            return new ResponseEntity(HttpStatus.OK);

        return new ResponseEntity(HttpStatus.NOT_FOUND);


    }
}
