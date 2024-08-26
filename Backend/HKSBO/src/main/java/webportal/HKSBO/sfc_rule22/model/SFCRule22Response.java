package webportal.HKSBO.sfc_rule22.model;

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
    "TranDate",
    "BS",
    "Qty",
    "Price"
})
public class SFCRule22Response {
  @JsonProperty("tranDate")
  private String TranDate;

  @JsonProperty("bs")
  private String BS;

  @JsonProperty("qty")
  private BigDecimal Qty;

  @JsonProperty("price")
  private BigDecimal Price;
}
