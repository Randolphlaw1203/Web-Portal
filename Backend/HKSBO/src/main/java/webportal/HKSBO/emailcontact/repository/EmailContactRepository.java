package webportal.HKSBO.emailcontact.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import webportal.HKSBO.entity.Scclientcontact;

@Repository
public interface EmailContactRepository extends JpaRepository<Scclientcontact, String> {
  @Query(value = "WITH overall_email AS (" +
      "SELECT clientid, number " +
      "FROM scclientcontact " +
      "WHERE contacttypeid = 'E' AND (DAILYSTATEMENT = 'Y' OR MONTHLYSTATEMENT = 'Y') AND " +
      "clientid = (SELECT clientid FROM sctradingacc WHERE subaccountid = :tradingid) " +
      "UNION " +
      "SELECT stc.clientid, number " +
      "FROM sctradingacccontact stc " +
      "INNER JOIN sctradingacc st ON stc.clientid = st.clientid AND stc.TRADINGACCSEQ = st.TRADINGACCSEQ " +
      "WHERE contacttypeid = 'E' AND (DAILYSTATEMENT = 'Y' OR MONTHLYSTATEMENT = 'Y') AND subaccountid = :tradingid) " +
      "SELECT RTRIM(oe.clientid), RTRIM(sct.subaccountid), LISTAGG(oe.number, ';') " +
      "FROM overall_email oe " +
      "INNER JOIN sctradingacc sct ON oe.clientid = sct.clientid " +
      "GROUP BY oe.clientid, sct.subaccountid " +
      "HAVING sct.subaccountid = :tradingid", nativeQuery = true)
  List<Object[]> findDataByTradingID(@Param("tradingid") String tradingid);
}
