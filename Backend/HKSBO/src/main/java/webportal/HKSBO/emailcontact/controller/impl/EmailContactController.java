package webportal.HKSBO.emailcontact.controller.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import webportal.HKSBO.emailcontact.controller.EmailContactOperation;
import webportal.HKSBO.emailcontact.model.EmailContactResponse;
import webportal.HKSBO.emailcontact.repository.EmailContactRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/webportal/api/v1")
public class EmailContactController implements EmailContactOperation {

  @Autowired
  private EmailContactRepository emailContactRepository;

  @Override
  public List<EmailContactResponse> getEmailContactById(List<String> tradingid) {
    List<EmailContactResponse> responseList = new ArrayList<>();

    for (String id : tradingid) {
      List<Object[]> results = emailContactRepository.findDataByTradingID(id);

      for (Object[] row : results) {
        EmailContactResponse response = new EmailContactResponse();
        response.setClientId((String) row[0]);
        response.setSubAccountId((String) row[1]);
        response.setEmail((String) row[2]);
        responseList.add(response);
      }
    }

    return responseList;
  }
}
