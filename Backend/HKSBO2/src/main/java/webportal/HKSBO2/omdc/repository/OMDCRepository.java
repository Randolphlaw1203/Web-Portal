package webportal.HKSBO2.omdc.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import webportal.HKSBO2.entity.Scoperator;

@Repository
public interface OMDCRepository extends JpaRepository<Scoperator, String> {
  @Query(value = "SELECT VARCHAR_FORMAT(SCO.TRADEDATE,'YYYY-MM-DD') AS TRADEDATE," +
      " RTRIM(SCO.OPERATORID)," +
      " RTRIM(SCO.OPERATORNAME)," +
      " RTRIM(SCR.OPERATORGROUPID)," +
      " CASE WHEN SCR.OPERATORGROUPID IN ('FO','IT', 'SALES','RISK','FO_NEWJOIN')" +
      " THEN 'Y'" +
      " ELSE 'N'" +
      " END AS MARKETDATA," +
      " isNULL(VARCHAR_FORMAT(SCO.CREATIONTIME,'YYYY-MM-DD'),'') AS ACTIVATIONDATE," +
      " CASE WHEN SCO.OPERATORSTATUS = 'F'" +
      " THEN VARCHAR_FORMAT(SCO.LASTMODIFIEDTIME,'YYYY-MM-DD')" +
      " ELSE ''" +
      " END AS TERMINATIONDATE," +
      " SCO.OPERATORSTATUS" +
      " FROM SCOPERATOR SCO" +
      " LEFT JOIN SCOPERATORGROUPRELATION SCR" +
      " ON SCO.OPERATORID = SCR.OPERATORID" +
      " AND SCR.TRADEDATE = SCO.TRADEDATE" +
      " WHERE SCO.OPERATORID NOT IN ('ITRADE01','TSCI_APP_U','TSCI_PC_U')" +
      " AND SCO.TRADEDATE BETWEEN :startdate AND :enddate" +
      " ORDER BY SCO.TRADEDATE,ACTIVATIONDATE,SCO.OPERATORID", nativeQuery = true)
  List<Object[]> getOMDCByDate(@Param("startdate") String startdate, @Param("enddate") String enddate);
}
