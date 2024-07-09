package kr.happytravel.btoc.service;

import kr.happytravel.btoc.dao.PackageDao;
import kr.happytravel.btoc.dto.CntPerCountryList;
import kr.happytravel.btoc.dto.PackageDTO;
import kr.happytravel.btoc.dto.Top5Package;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class PackageService {
    private final Logger logger = LogManager.getLogger(this.getClass());

    private final PackageDao packageDao;

    public List<CntPerCountryList> getCountByCountry(Map<String, Object> paramMap) throws Exception {

        return packageDao.getCountByCountry(paramMap);
    }

    public List<Top5Package> getTop5Package(Map<String, Object> paramMap) throws Exception {

        return packageDao.getTop5Package(paramMap);
    }

    public List<PackageDTO> getPackageList(Map<String, Object> paramMap) throws Exception {
        if (paramMap.containsKey("limit") && paramMap.containsKey("offset")) {
            paramMap.put("limit", Integer.parseInt(paramMap.get("limit").toString()));
            paramMap.put("offset", Integer.parseInt(paramMap.get("offset").toString()));

            return packageDao.getPackageList(paramMap);
        } else {
            throw new IllegalArgumentException("Limit and Offset parameters are required for pagination.");
        }
    }

}
