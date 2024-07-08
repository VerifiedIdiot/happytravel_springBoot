package kr.happytravel.btoc.service;

import kr.happytravel.btoc.dao.HotelDao;
import kr.happytravel.btoc.dto.CntPerCountryList;
import kr.happytravel.btoc.dto.HotelDto;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class HotelService {
    private final Logger logger = LogManager.getLogger(this.getClass());

    private final HotelDao hotelDao;
    private final SqlSession sqlSession;

    public List<CntPerCountryList> getCountByCountry(Map<String, Object> paramMap) throws Exception {
        return hotelDao.getCountByCountry(paramMap);
    }

    public int getHotelCnt(Map<String, Object> paramMap) throws Exception {
        return hotelDao.getHotelCnt(paramMap);
    }

    public List<HotelDto> getHotelList(Map<String, Object> paramMap) throws Exception {

//        paramMap.put("limit", Integer.parseInt(paramMap.get("limit").toString()));
//        paramMap.put("offset", Integer.parseInt(paramMap.get("offset").toString()));

        return hotelDao.getHotelList(paramMap);
    }

    public List<HotelDto> getHotelList(String country, Integer minPrice, Integer maxPrice, String startDate, String endDate) {
        Map<String, Object> params = new HashMap<>();
        params.put("country", country);
        params.put("minPrice", minPrice);
        params.put("maxPrice", maxPrice);
        params.put("startDate", (startDate != null && !startDate.isEmpty()) ? startDate : null);
        params.put("endDate", (endDate != null && !endDate.isEmpty()) ? endDate : null);

        return sqlSession.selectList("getHotelList", params);
    }

}
