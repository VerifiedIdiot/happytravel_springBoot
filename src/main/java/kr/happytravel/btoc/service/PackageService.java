package kr.happytravel.btoc.service;

import kr.happytravel.btoc.dao.PackageDao;
import kr.happytravel.btoc.dto.CntPerCountryList;
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
}
