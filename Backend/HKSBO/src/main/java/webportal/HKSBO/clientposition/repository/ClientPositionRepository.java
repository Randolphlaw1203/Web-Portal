package webportal.HKSBO.clientposition.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import webportal.HKSBO.entity.Vsbtradingacc;

@Repository
public interface ClientPositionRepository extends JpaRepository<Vsbtradingacc, String> {
  @Query(value = "SELECT " +
      "RTRIM(sct.subaccountid), " +
      "sct.subaccountname, " +
      "ta.marketid, " +
      "ta.instrumentid, " +
      "RTRIM(ta.instrumentname), " +
      "ta.ledgerqty, " +
      "ta.closingprice, " +
      "ta.marketvalue, " +
      "ta.currencyid " +
      "FROM vsbtradingacc ta " +
      "INNER JOIN sctradingacc sct " +
      "ON ta.clientid = sct.clientid " +
      "AND ta.tradingaccseq = sct.tradingaccseq " +
      "WHERE sct.subaccountid in :tradingid " +
      "AND ta.ledgerqty <> 0 order by sct.subaccountid", nativeQuery = true)
  List<Object[]> findDataByTradingID(@Param("tradingid") List<String> tradingid);
}
