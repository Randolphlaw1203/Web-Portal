const fs = require('fs-extra');
const path = require('path');

exports.saveFileData = async (file) => {
  const logEntry = `${new Date().toISOString()} - ${file.originalname}\n`;
  const logFilePath = path.join('C:', 'uploads', 'upload-log.txt');

  // Ensure the log directory exists
  await fs.ensureDir(path.dirname(logFilePath));

  // Append the log entry to the log file
  await fs.appendFile(logFilePath, logEntry);
};