package webportal.HKSBO2.fundmarketvalue.model;

import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@JsonPropertyOrder({
    "TradeDate",
    "ClientId",
    "MarketValue",
    "InstrumentId",
    "InstrumentName",
    "InstrumentChineseName"
})
public class FundMarketValueResponse {

  @JsonProperty("tradeDate")
  private String TradeDate;

  @JsonProperty("clientId")
  private String ClientId;

  @JsonProperty("marketValue")
  private BigDecimal MarketValue;

  @JsonProperty("instrumentId")
  private String InstrumentId;

  @JsonProperty("instrumentName")
  private String InstrumentName;

  @JsonProperty("instrumentChineseName")
  private String InstrumentChineseName;

}
