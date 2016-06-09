package com.janusze.projektzespolowy.zgloszenie.api;

import com.janusze.projektzespolowy.util.enums.ETypPriorytetu;
import com.janusze.projektzespolowy.util.wrappers.SaveZgloszenieDTO;
import com.janusze.projektzespolowy.zgloszenie.dto.ZgloszenieDTO;
import com.janusze.projektzespolowy.zgloszenie.service.IZgloszenieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Tomasz Jodko on 2016-04-22.
 */
@RestController
@Transactional
@RequestMapping(value = "/projektzespolowy/zgloszenia")
public class ZgloszenieController {
    @Autowired
    IZgloszenieService zgloszenieService;

    @RequestMapping(value = "getById/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<ZgloszenieDTO> findZgloszenieById(@PathVariable("id") Long aId) {
        return new ResponseEntity<>(zgloszenieService.findZgloszenieById(aId), HttpStatus.OK);
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<ZgloszenieDTO>> findAllZgloszenia() {
        return new ResponseEntity<>(zgloszenieService.findAllZgloszenia(), HttpStatus.OK);
    }

    @RequestMapping(value = "getByUserId/{userId}", method = RequestMethod.GET)
    public ResponseEntity<List<ZgloszenieDTO>> findZgloszeniaByUserId(@PathVariable("userId") Long aUserId) {
        return new ResponseEntity<>(zgloszenieService.findByUserId(aUserId), HttpStatus.OK);
    }

    @RequestMapping(value = "getByUserAndProjektId/{userId},{projektId}", method = RequestMethod.GET)
    public ResponseEntity<List<ZgloszenieDTO>> findZgloszeniaByUserAndProjektId(@PathVariable("userId") Long aUserId,@PathVariable("projektId") Long aProjektId) {
        return new ResponseEntity<>(zgloszenieService.findByUserAndProjektId(aUserId,aProjektId), HttpStatus.OK);
    }

    @RequestMapping(value = "getByProjektId/{projektId}", method = RequestMethod.GET)
    public ResponseEntity<List<ZgloszenieDTO>> findZgloszeniaByProjektId(@PathVariable("projektId") Long aProjektId) {
        return new ResponseEntity<>(zgloszenieService.findByProjektId(aProjektId), HttpStatus.OK);
    }

    @RequestMapping(value = "getByPriorytetType/{priorytetType}", method = RequestMethod.GET)
    public ResponseEntity<List<ZgloszenieDTO>> findZgloszeniaByPriorytetType(@PathVariable("priorytetType")ETypPriorytetu aPriorytetType) {
        return new ResponseEntity<>(zgloszenieService.findByPriorytetType(aPriorytetType), HttpStatus.OK);
    }

    @RequestMapping(value = "/saveZgloszenie", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    @ResponseBody
    public ResponseEntity<ZgloszenieDTO> saveZgloszenie(@RequestBody SaveZgloszenieDTO aWrapper) {
        return new ResponseEntity<>(zgloszenieService.saveZgloszenie(aWrapper), HttpStatus.OK);
    }

    @RequestMapping(value = "/deleteById/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<Void> deleteZgloszenie(@PathVariable("id") Long aId) {
        zgloszenieService.deleteZgloszenie(aId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
