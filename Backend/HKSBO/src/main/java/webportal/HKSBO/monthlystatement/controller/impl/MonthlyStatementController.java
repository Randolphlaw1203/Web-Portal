package webportal.HKSBO.monthlystatement.controller.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import webportal.HKSBO.monthlystatement.controller.MonthlyStatementOperation;
import webportal.HKSBO.monthlystatement.model.MonthlyStatementResponse;
import webportal.HKSBO.monthlystatement.repository.MonthlyStatementRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/webportal/api/v1")
public class MonthlyStatementController implements MonthlyStatementOperation {
  @Autowired
  private MonthlyStatementRepository monthlyStatementRepository;

  @Override
  public List<MonthlyStatementResponse> listMonthlyStatement() {
    List<Object[]> results = monthlyStatementRepository.getMonthlyStatement();
    List<MonthlyStatementResponse> responseList = new ArrayList<>();

    for (Object[] row : results) {
      MonthlyStatementResponse response = new MonthlyStatementResponse();
      response.setClientId((String) row[0]);
      response.setClientName((String) row[1]);
      response.setClientChineseName((String) row[2]);
      response.setAddressLine7((String) row[3]);
      response.setStatementDate((String) row[4]);
      responseList.add(response);
    }
    return responseList;
  }
}
