package kr.happytravel.btoc.dao;
import kr.happytravel.btoc.dto.CntPerCountryList;
import kr.happytravel.btoc.dto.HotelDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;
@Mapper
public interface HotelDao {
    // 국가별 등록된 호텔 수 조회
    List<CntPerCountryList> getCountByCountry(Map<String, Object> paramMap) throws Exception;

    // 호텔 전체 조회 카운트
    int getHotelCnt(Map<String, Object> paramMap) throws Exception;

    // 호텔 전체 조회
    List<HotelDto> getHotelList(Map<String, Object> paramMap) throws Exception;

}
