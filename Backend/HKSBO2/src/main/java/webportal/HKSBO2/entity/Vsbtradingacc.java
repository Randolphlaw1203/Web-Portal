package webportal.HKSBO2.entity;

import java.math.BigDecimal;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "vsbtradingacc")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Vsbtradingacc {
  @Id
  @Column(name = "clientid")
  private String ClientId;

  @Column(name = "tradedate")
  private String TradeDate;

  @Column(name = "marketid")
  private String MarketId;

  @Column(name = "instrumentid")
  private String InstrumentId;

  @Column(name = "instrumentname")
  private String InstrumentName;

  @Column(name = "instrumentchinesetname")
  private String InstrumentChineseName;

  @Column(name = "tobasecurrencyexchangerate")
  private BigDecimal TobaseCurrencyExchangeRate;

  @Column(name = "marketvalue")
  private BigDecimal MarketValue;

  @Column(name = "aeid")
  private String AEID;
}
