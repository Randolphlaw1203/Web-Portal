package webportal.HKSBO2.entity;

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
@Table(name = "scoperatorgrouprelation")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Scoperatorgrouprelation {

  @Id
  @Column(name = "operatorid")
  private String OperatorId;

  @Column(name = "operatorgroupid")
  private String OperatorGroupId;

}
