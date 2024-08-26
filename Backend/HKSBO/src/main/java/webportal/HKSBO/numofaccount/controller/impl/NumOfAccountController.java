package webportal.HKSBO.numofaccount.controller.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import webportal.HKSBO.numofaccount.controller.NumOfAccountOperation;
import webportal.HKSBO.numofaccount.model.NumOfAccountResponse;
import webportal.HKSBO.numofaccount.repository.NumOfAccountRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/webportal/api/v1")
public class NumOfAccountController implements NumOfAccountOperation {
  @Autowired
  private NumOfAccountRepository numOfAccountRepository;

  @Override
  public List<NumOfAccountResponse> countNumOfAccount() {
    List<Object[]> results = numOfAccountRepository.getNumOfAccount();
    List<NumOfAccountResponse> responseList = new ArrayList<>();

    for (Object[] row : results) {
      NumOfAccountResponse response = new NumOfAccountResponse();
      response.setMonth((String) row[0]);
      response.setNumOfAccounts((Integer) row[1]);
      responseList.add(response);
    }
    return responseList;
  }
}
