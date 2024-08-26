import Papa from 'papaparse';
import moment from 'moment';
import { uploadFile } from "../../../API";

// Define a mapping of table titles to JSON keys
const columnsMap = [
  { title: "Trading A/C", key: "subAccountId" },
  { title: "Trading Name", key: "subAccountName" },
  { title: "Date", key: "date" },
  { title: "Market ID", key: "marketId" },
  { title: "Instrument ID", key: "instrumentId" },
  { title: "Instrument Name", key: "instrumentName" },
  { title: "Qty", key: "qty" },
  { title: "Closing Price", key: "closingPrice" },
  { title: "Market Value", key: "marketValue" },
  { title: "CCY", key: "ccy" },
];

const ExportToCSV = (data) => {
  // Group data by subAccountId
  const groupedData = data.reduce((acc, item) => {
    if (!acc[item.subAccountId]) {
      acc[item.subAccountId] = [];
    }
    acc[item.subAccountId].push(item);
    return acc;
  }, {});

  // Create and upload a CSV file for each subAccountId
  Object.keys(groupedData).forEach(async (subAccountId) => {
    // Generate the CSV data
    const csvData = groupedData[subAccountId].map(item => {
      const row = {};
      columnsMap.forEach(column => {
        row[column.title] = item[column.key];
      });
      return row;
    });

    // Convert to CSV
    const csv = Papa.unparse(csvData, {
      columns: columnsMap.map(column => column.title),
    });

    // Add BOM to the CSV content
    const csvWithBOM = '\uFEFF' + csv;

    // Create a blob from the CSV content
    const blob = new Blob([csvWithBOM], { type: 'text/csv;charset=utf-8;' });

    // Upload the blob to the server
    const formData = new FormData();
    const today = moment().format('YYYYMMDD');
    formData.append('file', blob, `${subAccountId}_Position_${today}.csv`);

    const response = await uploadFile(formData);
    if (response) {
      console.log(`CSV for ${subAccountId} uploaded successfully!`);
    } else {
      console.error(`Error uploading CSV for ${subAccountId}.`);
    }
  });
  alert('Export and Save Completed');
};

export default ExportToCSV;