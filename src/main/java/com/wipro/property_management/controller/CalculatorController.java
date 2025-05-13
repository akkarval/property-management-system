package com.wipro.property_management.controller;

import com.wipro.property_management.dto.CalculatorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/calculator")
public class CalculatorController {

    //Passing parameters from Web using Request Params
    @GetMapping("/add/{numC}")
    public ResponseEntity<Double> add(@RequestParam("numA") Double num1, @RequestParam("numB") Double num2, @PathVariable("numC") Double num3) {
    double result;
        result =  num1+num2+num3;
        return new ResponseEntity<>(result, HttpStatus.ACCEPTED);

    }
    // Passing parameters from Web using Path variables
    @GetMapping("/subtract/{numA}/{numB}")
    public ResponseEntity<Double> subtract(@PathVariable("numA") Double num1, @PathVariable("numB") Double num2){
        double result;
        if(num1 > num2){
            result =  num1-num2;
        }else{
            result =  num2-num1;
        }
        return new ResponseEntity<>(result,HttpStatus.OK);
    }
    //  Using @RequestBody, mapping input parameters to DTO class fields

    @PostMapping("/multiply")
    public ResponseEntity<Double>  multiply(@RequestBody CalculatorDTO calculatorDTO){
        double result;
        result =  calculatorDTO.getNum1()*calculatorDTO.getNum2()*calculatorDTO.getNum3()*calculatorDTO.getNum4();

        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }


}
