package com.example.controller;

import com.example.model.Smartphone;
import com.example.service.ISmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@RestController
@RequestMapping("/smartphones")
public class SmartphoneController {

    @Autowired
    private ISmartphoneService iSmartphoneService;

    @PostMapping
    public ResponseEntity<Smartphone> createSmartphone(@RequestBody Smartphone smartphone){
        return new ResponseEntity<>(iSmartphoneService.save(smartphone), HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public ModelAndView getAllSmartphonePage(){
        ModelAndView modelAndView = new ModelAndView("/phones/list");
        modelAndView.addObject("smartphones", iSmartphoneService.findAll());
        return modelAndView;
    }

    @GetMapping
    public ResponseEntity<Iterable<Smartphone>> allPhones(){
        return new ResponseEntity<>(iSmartphoneService.findAll(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Smartphone> deleteSmartphone(@PathVariable Long id) {
        Optional<Smartphone> smartphoneOptional = iSmartphoneService.findById(id);
        if (!smartphoneOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        iSmartphoneService.remove(id);
        return new ResponseEntity<>(smartphoneOptional.get(), HttpStatus.NO_CONTENT);
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editSmartphoneForm(@PathVariable Long id){
        Optional<Smartphone> smartphoneOptional = iSmartphoneService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/phones/edit");
        modelAndView.addObject(smartphoneOptional.get());
        return modelAndView;
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Smartphone> editSmartphone
            (@RequestBody Smartphone smartphoneUpdate){
        iSmartphoneService.save(smartphoneUpdate);
        return new ResponseEntity<>(HttpStatus.OK);
    }

//    @GetMapping("/edit/{id}")
//    public ModelAndView editSmartphoneForm(@PathVariable Long id){
//        Optional<Smartphone> smartphone = this.iSmartphoneService.findById(id);
//        ModelAndView modelAndView = new ModelAndView("/phones/edit");
//        modelAndView.addObject(smartphone.get());
//        return modelAndView;
//    }

//    @PatchMapping("/{id}")
//    public ResponseEntity<Smartphone> editSmartphone(@RequestBody Smartphone editSmartPhone){
//        this.iSmartphoneService.save(editSmartPhone);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }

}
