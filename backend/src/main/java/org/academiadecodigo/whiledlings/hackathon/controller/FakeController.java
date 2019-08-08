package org.academiadecodigo.whiledlings.hackathon.controller;

import org.academiadecodigo.whiledlings.hackathon.persistence.model.FakeModel;
import org.academiadecodigo.whiledlings.hackathon.service.FakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/fake")
public class FakeController {

    private FakeService fakeService;


    @RequestMapping(method = RequestMethod.POST, path = {"/", ""})
    public ResponseEntity<?> addCustomer(@RequestBody FakeModel fakeModel, UriComponentsBuilder uriComponentsBuilder) {

        FakeModel savedFake = fakeService.save(fakeModel);

        UriComponents uriComponents = uriComponentsBuilder.path("/api/fake"+savedFake.getId()).build();

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(uriComponents.toUri());

        return new ResponseEntity<>(headers, HttpStatus.CREATED);

    }
    @Autowired
    public void setFakeService(FakeService fakeService) {
        this.fakeService = fakeService;
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/{id}"})
    public ResponseEntity<FakeModel> getFake(@PathVariable Integer id){
        FakeModel fakeModel = fakeService.getFake(id);
        return new ResponseEntity<FakeModel>(fakeModel,HttpStatus.OK);
    }
}
