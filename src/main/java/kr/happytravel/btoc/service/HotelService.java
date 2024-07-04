package kr.happytravel.btoc.service;

import kr.happytravel.btoc.dao.HotelDao;
import kr.happytravel.btoc.dto.CntPerCountryList;
import kr.happytravel.btoc.dto.HotelDto;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class HotelService {
    private final Logger logger = LogManager.getLogger(this.getClass());

    private final HotelDao hotelDao;

    public List<CntPerCountryList> getCountByCountry(Map<String, Object> paramMap) throws Exception {
        return hotelDao.getCountByCountry(paramMap);
    }

    public List<HotelDto> getHotelList(Map<String, Object> paramMap) throws Exception {
        return hotelDao.getHotelList(paramMap);
    }
}
