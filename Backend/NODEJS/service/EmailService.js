const nodemailer = require('nodemailer');

const mailTransport = nodemailer.createTransport({
  host: 'smtp.gmail.com',
  port: 465,
  secure: true,
  auth: {
    user: 'randolphlawlaw@gmail.com',
    pass: 'XXXXX'
  }
});

exports.sendEmail = (options, callback) => {
  mailTransport.sendMail(options, callback);
};