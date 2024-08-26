const multer = require('multer');
const moment = require('moment');
const fs = require('fs-extra');
const path = require('path');

// Configure multer for file uploads
const storage = multer.diskStorage({
  destination: async (req, file, cb) => {
    const today = moment().format('YYYYMMDD');
    //const dir = path.join('C:', 'Client position', today);
    const dir = path.join('Client position', today);

    // Ensure the directory exists
    await fs.ensureDir(dir);

    cb(null, dir);
  },
  filename: (req, file, cb) => {
    cb(null, file.originalname);
  },
});

const upload = multer({ storage }).single('file');

exports.uploadFile = (req, res) => {
  upload(req, res, (err) => {
    if (err) {
      return res.status(500).json({ error: err.message });
    }
    res.send('File uploaded successfully!');
  });
};