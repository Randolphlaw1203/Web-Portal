package webportal.HKSBO.entity;

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

  @Column(name = "tradingaccseq")
  private String TradingaccSeq;

  @Column(name = "marketid")
  private String MarketId;

  @Column(name = "instrumentid")
  private String InstrumentId;

  @Column(name = "ledgerqty")
  private BigDecimal LedgerQty;

  @Column(name = "instrumentname")
  private String InstrumentName;

  @Column(name = "instrumentshortname")
  private String InstrumentShortName;

  @Column(name = "currencyid")
  private String CurrencyId;

  @Column(name = "closingprice")
  private BigDecimal closingPrice;

  @Column(name = "marketvalue")
  private BigDecimal MarketValue;

  @Column(name = "tobasecurrencyexchangerate")
  private BigDecimal ToBaseCurrencyExchangeRate;

}
