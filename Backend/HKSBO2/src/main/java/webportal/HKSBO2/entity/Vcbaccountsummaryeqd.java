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
@Table(name = "vcbaccountsummaryeqd")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Vcbaccountsummaryeqd {
  @Id
  @Column(name = "clientid")
  private String ClientId;

  @Column(name = "tradedate")
  private String TradeDate;

  @Column(name = "aeid")
  private String AEID;

  @Column(name = "ledgerbal")
  private BigDecimal LedgerBal;
}
