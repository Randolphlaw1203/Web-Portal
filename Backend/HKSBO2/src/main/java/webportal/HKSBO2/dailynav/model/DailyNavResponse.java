package webportal.HKSBO2.dailynav.model;

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
    "AEID",
    "LedgerBal",
    "MarketValueHKEX",
    "MarketValueMAMK",
    "MarketValueSZMK",
    "MarketValueUSEX",
    "MarketValueFUND",
    "MarketValueOther",
    "TotalMarketValue",
    "NetEquity"

})
public class DailyNavResponse {
  @JsonProperty("tradeDate")
  private String TradeDate;

  @JsonProperty("aeId")
  private String AEID;

  @JsonProperty("ledgerBal")
  private BigDecimal LedgerBal;

  @JsonProperty("marketValueHKEX")
  private BigDecimal MarketValueHKEX;

  @JsonProperty("marketValueMAMK")
  private BigDecimal MarketValueMAMK;

  @JsonProperty("marketValueSZMK")
  private BigDecimal MarketValueSZMK;

  @JsonProperty("marketValueUSEX")
  private BigDecimal MarketValueUSEX;

  @JsonProperty("marketValueFUND")
  private BigDecimal MarketValueFUND;

  @JsonProperty("marketValueOther")
  private BigDecimal MarketValueOther;

  @JsonProperty("totalMarketValue")
  private BigDecimal TotalMarketValue;

  @JsonProperty("netEquity")
  private BigDecimal NetEquity;
}
