package webportal.HKSBO2.omdc.model;

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
    "OperatorId",
    "OperatorName",
    "OperatorGroupId",
    "MarketData",
    "ActivationDate",
    "TerminationDate",
    "OperatorStatus"
})
public class OMDCResponse {
  @JsonProperty("tradeDate")
  private String TradeDate;

  @JsonProperty("operatorId")
  private String OperatorId;

  @JsonProperty("operatorName")
  private String OperatorName;

  @JsonProperty("operatorGroupId")
  private String OperatorGroupId;

  @JsonProperty("marketData")
  private Character MarketData;

  @JsonProperty("activationDate")
  private String ActivationDate;

  @JsonProperty("terminationDate")
  private String TerminationDate;

  @JsonProperty("operatorStatus")
  private Character OperatorStatus;

}
