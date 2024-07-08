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

    @GetMapping("/hotel-count")
    public ResponseEntity<?> getHotelCnt(@RequestParam(required = true) Map<String, Object> paramMap) {
        try {
            logger.info("Received request with parameters: " + paramMap);
            int result = hotelService.getHotelCnt(paramMap);
            if (result == 0) {
                logger.warn("HotelCnt not found with parameters: " + paramMap);
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(false);
            }
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            logger.error("An error occurred: " + e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(false);
        }
    }

    @GetMapping("/country-count")
    public ResponseEntity<?> getCountryCnt(@RequestParam Map<String, Object> paramMap) {
        try {
            logger.info("Received request with parameters: " + paramMap);
            List<CntPerCountryList> list = hotelService.getCountByCountry(paramMap);
            return ResponseEntity.ok(list);
        } catch (Exception e) {
            logger.error("An error occurred: " + e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(false);
        }
    }

    @GetMapping("/search")
    public ResponseEntity<?> searchHotels(
            @RequestParam(required = false) String country,
            @RequestParam(required = false) Integer minPrice,
            @RequestParam(required = false) Integer maxPrice,
            @RequestParam(required = false) String startDate,
            @RequestParam(required = false) String endDate
    ) {
        logger.info("searchHotels called with parameters: country={}, minPrice={}, maxPrice={}, startDate={}, endDate={}",
                country, minPrice, maxPrice, startDate, endDate);
        try {
            List<HotelDto> hotels = hotelService.getHotelList(country, minPrice, maxPrice, startDate, endDate);
            logger.info("Hotels found: {}", hotels.size());
            return ResponseEntity.ok(hotels);
        } catch (Exception e) {
            logger.error("Error occurred while searching for hotels: ", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal server error");
        }
    }



}
