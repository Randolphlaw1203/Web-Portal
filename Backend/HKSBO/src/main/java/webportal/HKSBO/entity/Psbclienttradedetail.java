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
@Table(name = "psbclienttradedetail")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Psbclienttradedetail {
  @Id
  @Column(name = "tradeid")
  private String TradeId;

  @Column(name = "qty")
  private BigDecimal Qty;

  @Column(name = "price")
  private BigDecimal Price;

  @Column(name = "tradeseq")
  private BigDecimal TradeSeq;

}
