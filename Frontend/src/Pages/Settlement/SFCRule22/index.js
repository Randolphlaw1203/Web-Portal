import { useEffect, useState } from "react";
import { Typography, Button, Space, Input } from "antd";
import { listSFCRule22InstrumentIds, saveSFCRule22InstrumentIds } from "../../../API";
import SFCRule22Summary from "./SFCRule22Summary";
function SFCRule22() {

  // const [data, setData] = useState([]);
  const [instrumentid, setInstrumentId] = useState('');

  useEffect(() => {
    listSFCRule22InstrumentIds().then((data) => {
      // setData(data[0]);
      setInstrumentId(data[0].instrumentId);
      console.log(data[0]);
    });
  }, []);

  const saveInstrumentId = async () => {
    const data = await saveSFCRule22InstrumentIds(instrumentid);
    // setData(data);
    console.log(data);
    alert("Instrument ID Saved");
  };

  return (
    <div>
      <Typography.Title>SFC Rule 22</Typography.Title>
      <Space direction="vertical">
        <Space>
          <Typography.Text strong>Instrument Id:(5.HK, it is needed 00005. Use "," to separate)</Typography.Text>
          <Input style={{ width: '500px' }}
            value={instrumentid}
            onChange={e => setInstrumentId(e.target.value)} />
          <Button type="primary"
            onClick={saveInstrumentId}>Save Instrument ID</Button>
        </Space>
        <SFCRule22Summary instrumentid={instrumentid} />
      </Space>
    </div>
  )
} export default SFCRule22;