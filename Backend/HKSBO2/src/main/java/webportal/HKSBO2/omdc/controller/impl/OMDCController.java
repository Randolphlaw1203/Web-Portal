package webportal.HKSBO2.omdc.controller.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import webportal.HKSBO2.omdc.controller.OMDCOperation;
import webportal.HKSBO2.omdc.model.OMDCResponse;
import webportal.HKSBO2.omdc.repository.OMDCRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/webportal/api/v1")
public class OMDCController implements OMDCOperation {
  @Autowired
  private OMDCRepository omdcRepository;

  @Override
  public List<OMDCResponse> getOMDC(String startdate, String enddate) {
    List<Object[]> results = omdcRepository.getOMDCByDate(startdate, enddate);
    List<OMDCResponse> responseList = new ArrayList<>();

    for (Object[] row : results) {
      OMDCResponse response = new OMDCResponse();
      response.setTradeDate((String) row[0]);
      response.setOperatorId((String) row[1]);
      response.setOperatorName((String) row[2]);
      response.setOperatorGroupId((String) row[3]);
      response.setMarketData((Character) row[4]);
      response.setActivationDate((String) row[5]);
      response.setTerminationDate((String) row[6]);
      response.setOperatorStatus((Character) row[7]);
      responseList.add(response);
    }
    return responseList;
  }
}