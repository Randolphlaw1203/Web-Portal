package webportal.HKSBO.accounttype.controller.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import webportal.HKSBO.accounttype.controller.AccountTypeOperation;
import webportal.HKSBO.accounttype.model.AccountTypeResponse;
import webportal.HKSBO.accounttype.repository.AccountTypeRepository;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/webportal/api/v1")
public class AccountTypeController implements AccountTypeOperation {
  @Autowired
  private AccountTypeRepository accountTypeRepository;

  @Override
  public List<AccountTypeResponse> countAccountType() {
    List<Object[]> results = accountTypeRepository.getAccountType();
    List<AccountTypeResponse> responseList = new ArrayList<>();

    for (Object[] row : results) {
      AccountTypeResponse response = new AccountTypeResponse();
      response.setMargin((Integer) row[0]);
      response.setCash((Integer) row[1]);
      response.setDVP((Integer) row[2]);
      responseList.add(response);
    }
    return responseList;
  }
}
