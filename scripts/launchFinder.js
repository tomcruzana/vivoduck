const childProcess = require('child_process');

childProcess.exec('labelFinder.exe', function (err, stdout, stderr) { //lauch java app
    if (err) {
    console.error(err);
    return;
}
console.log(stdout);
process.exit(0);// exit process once it is opened
});

module.exports = childProcess;

