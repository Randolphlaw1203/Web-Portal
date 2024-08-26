const emailService = require('../service/EmailService');

module.exports.sendEmail = (req, res) => {
  const { tradingid, email, subject, html, attachment } = req.query;

  const options = {
    from: '"Randolph Law"<randolphlawlaw@gmail.com>',
    to: email,
    subject: subject,
    html: html,
    attachments: []
  };

  if (attachment) {
    options.attachments.push({ path: attachment });
  }

  emailService.sendEmail(options, (err) => {
    if (err) {
      console.log(err);
      res.json([
        {
          subAccountId: tradingid,
          email: email,
          subject: subject,
          html: html,
          attachments: attachment,
          status: 'error',
          message: err.message
        }
      ]);
    } else {
      res.json([
        {
          subAccountId: tradingid,
          email: email,
          subject: subject,
          html: html,
          attachments: attachment,
          status: 'Success'
        }
      ]);
    }
  });
};