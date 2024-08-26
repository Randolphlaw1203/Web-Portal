package webportal.HKSBO.clientposition.controller.impl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import webportal.HKSBO.clientposition.controller.ClientPositionOperation;
import webportal.HKSBO.clientposition.model.ClientPositionResponse;
import webportal.HKSBO.clientposition.repository.ClientPositionRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/webportal/api/v1")
public class ClientPositionController implements ClientPositionOperation {

  @Autowired
  private ClientPositionRepository clientPositionRepository;

  @Override
  public List<ClientPositionResponse> getClientPositionById(List<String> tradingid) {
    List<Object[]> results = clientPositionRepository.findDataByTradingID(tradingid);
    List<ClientPositionResponse> responseList = new ArrayList<>();

    for (Object[] row : results) {
      ClientPositionResponse response = new ClientPositionResponse();
      response.setSubAccountId((String) row[0]);
      response.setSubAccountName((String) row[1]);
      response.setMarketId((String) row[2]);
      response.setInstrumentId((String) row[3]);
      response.setInstrumentName((String) row[4]);
      response.setLedgerQty((BigDecimal) row[5]);
      response.setClosingPrice((BigDecimal) row[6]);
      response.setMarketValue((BigDecimal) row[7]);
      response.setCurrencyId((String) row[8]);
      response.setDate((LocalDate.now()));
      responseList.add(response);
    }
    return responseList;
  }

}
