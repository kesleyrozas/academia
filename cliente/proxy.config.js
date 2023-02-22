
const proxy = [
  {
    context: ['/api'],
    secure: false,
    logLevel: 'debug',
    target: 'http://localhost:8080/'

  }
];
module.exports = proxy;
