package kr.happytravel.btoc.dao;
import kr.happytravel.btoc.dto.CntPerCountryList;
import kr.happytravel.btoc.dto.PackageDTO;
import kr.happytravel.btoc.dto.Top5Package;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;
@Mapper
public interface PackageDao {
    // 국가별 등록된 패키지 수 조회
    List<CntPerCountryList> getCountByCountry(Map<String, Object> paramMap) throws Exception;

    List<Top5Package> getTop5Package(Map<String, Object> paramMap) throws Exception;

    List<PackageDTO> getPackageList(Map<String,Object> paramMap) throws Exception;
}
