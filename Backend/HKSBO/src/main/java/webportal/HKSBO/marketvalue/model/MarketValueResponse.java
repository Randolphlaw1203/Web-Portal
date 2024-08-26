package webportal.HKSBO.marketvalue.model;

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
    "MarketId",
    "MarketValue_HKD"
})
public class MarketValueResponse {
  @JsonProperty("marketId")
  private String MarketId;

  @JsonProperty("marketValue_HKD")
  private BigDecimal MarketValue_HKD;

}
