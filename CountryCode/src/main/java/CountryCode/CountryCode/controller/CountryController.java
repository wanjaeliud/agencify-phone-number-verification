package CountryCode.CountryCode.controller;

import CountryCode.CountryCode.dto.CountryDto;
import CountryCode.CountryCode.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = {"*"}, maxAge = 4800, allowCredentials = "false")
@RestController
@RequestMapping("/api")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping("/countries")
    public ResponseEntity getAllCountryCodes() {
        List<CountryDto> countryDtoList = countryService.getAllCountryCodes();
        ResponseEntity entity = new ResponseEntity(countryDtoList, HttpStatus.OK);
        return entity;
    }
}
