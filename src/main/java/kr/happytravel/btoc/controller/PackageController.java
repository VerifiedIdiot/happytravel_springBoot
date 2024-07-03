package kr.happytravel.btoc.controller;

import kr.happytravel.btoc.dto.CntPerCountryList;
import kr.happytravel.btoc.service.PackageService;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/package")
@RequiredArgsConstructor
public class PackageController {

    private final Logger logger = LogManager.getLogger(this.getClass());
    private final PackageService packageService;

    @GetMapping("/country-count")
    public ResponseEntity<?> getPackageCnt(@RequestParam Map<String, Object> paramMap) {
        try {
            logger.info("Received request with parameters: " + paramMap);
            List<CntPerCountryList> list = packageService.getCountByCountry(paramMap);
            return ResponseEntity.ok(list);
        } catch (Exception e) {
            logger.error("An error occurred: " + e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(false);
        }
    }
}
