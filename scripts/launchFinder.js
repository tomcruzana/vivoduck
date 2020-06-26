const childProcess = require('child_process');

childProcess.exec('labelFinder.txt', function (err, stdout, stderr) {
    if (err) {
    console.error(err);
    return;
}
console.log(stdout);
process.exit(0);// exit process once it is opened
});

