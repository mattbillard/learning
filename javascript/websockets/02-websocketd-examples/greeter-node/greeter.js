/**
 * INSTRUCTIONS
 * - Run 
 *    websocketd --port=8080 --devconsole node greeter.js 
 * - Go to http://localhost:8080 to interact with it
 */


process.stdin.setEncoding('utf8');

process.stdin.on('readable', function () {
  var chunk = process.stdin.read();
  if (chunk !== null) {
    process.stdout.write('data: ' + chunk);
  }
});