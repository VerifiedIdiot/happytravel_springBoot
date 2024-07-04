package kr.happytravel.btoc.controller;

import kr.happytravel.btoc.dto.CntPerCountryList;
import kr.happytravel.btoc.dto.HotelDto;
import kr.happytravel.btoc.service.HotelService;
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
@RequestMapping("/hotel")
@RequiredArgsConstructor
public class HotelController {
    private final Logger logger = LogManager.getLogger(this.getClass());
    private final HotelService hotelService;

    @GetMapping("/hotel-list")
    public ResponseEntity<?> getHotelList(@RequestParam Map<String, Object> paramMap) {
        try {
            List<HotelDto> hotels = hotelService.getHotelList(paramMap);
            return ResponseEntity.ok(hotels);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/country-count")
    public ResponseEntity<?> getHotelCnt(@RequestParam Map<String, Object> paramMap) {
        try {
            logger.info("Received request with parameters: " + paramMap);
            List<CntPerCountryList> list = hotelService.getCountByCountry(paramMap);
            return ResponseEntity.ok(list);
        } catch (Exception e) {
            logger.error("An error occurred: " + e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(false);
        }
    }
}
