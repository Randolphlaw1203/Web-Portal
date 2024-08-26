package webportal.HKSBO.sfc_rule22.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import webportal.HKSBO.entity.Psbclienttrade;

public interface SFCRule22Repository extends JpaRepository<Psbclienttrade, String> {
  @Query(value = "SELECT VARCHAR_FORMAT(TRANDATE, 'DD/MM/YYYY'), " +
      "CASE " +
      "WHEN BS = 'B' THEN 'Purchase' " +
      "WHEN BS = 'S' THEN 'Sale' " +
      "ELSE BS " +
      "END as BS, " +
      "CTD.QTY, CTD.PRICE " +
      "FROM PSBCLIENTTRADE CT " +
      "LEFT JOIN PSBCLIENTTRADEDETAIL CTD " +
      "ON CT.TRADEID = CTD.TRADEID " +
      "WHERE INSTRUMENTID IN :instrumentid ORDER BY CT.TRADEID,TRADESEQ", nativeQuery = true)
  List<Object[]> findDataByInstrumentId(@Param("instrumentid") List<String> instrumentid);
}
