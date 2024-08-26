package webportal.HKSBO.sfc_rule22.controller.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import webportal.HKSBO.sfc_rule22.controller.SFCRule22Operation;
import webportal.HKSBO.sfc_rule22.model.SFCRule22Response;
import webportal.HKSBO.sfc_rule22.repository.SFCRule22Repository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/webportal/api/v1")
public class SFCRule22Controller implements SFCRule22Operation {

  @Autowired
  private SFCRule22Repository sfcRule22Repository;

  @Override
  public List<SFCRule22Response> getSCFRule22ByInstrumentId(List<String> instrumentid) {
    List<Object[]> results = sfcRule22Repository.findDataByInstrumentId(instrumentid);
    List<SFCRule22Response> responseList = new ArrayList<>();

    for (Object[] row : results) {
      SFCRule22Response response = new SFCRule22Response();
      response.setTranDate((String) row[0]);
      response.setBS((String) row[1]);
      response.setQty((BigDecimal) row[2]);
      response.setPrice((BigDecimal) row[3]);
      responseList.add(response);
    }
    return responseList;
  }
}
