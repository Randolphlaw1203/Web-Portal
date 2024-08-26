package webportal.HKSBO.clientposition.model;

import java.math.BigDecimal;
import java.time.LocalDate;
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
    "SubAccountId",
    "SubAccountName",
    "Date",
    "MarketId",
    "InstrumentId",
    "InstrumentName",
    "LedgerQty",
    "ClosingPrice",
    "MarketValue",
    "CurrencyId"
})
public class ClientPositionResponse {
  @JsonProperty("subAccountId")
  private String SubAccountId;

  @JsonProperty("subAccountName")
  private String SubAccountName;

  @JsonProperty("date")
  private LocalDate Date;

  @JsonProperty("marketId")
  private String MarketId;

  @JsonProperty("instrumentId")
  private String InstrumentId;

  @JsonProperty("instrumentName")
  private String InstrumentName;

  @JsonProperty("qty")
  private BigDecimal LedgerQty;

  @JsonProperty("closingPrice")
  private BigDecimal ClosingPrice;

  @JsonProperty("marketValue")
  private BigDecimal MarketValue;

  @JsonProperty("ccy")
  private String CurrencyId;

}