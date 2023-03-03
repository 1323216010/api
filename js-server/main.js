var express = require('express');
var app = express();

var fs = require("fs");

app.get('/poet', function (req, res) {
    fs.readFile(__dirname + '/json/poet300.json', 'utf8', function (err, str) {
        arr = JSON.parse(str);
        let poet = []
        for(let i =0; i < arr.length; i++){
            if(arr[i].author === req.query.author) {
                poet.push(arr[i])
            }
        }
        res.setHeader('Content-Type', 'application/json; charset=utf8');
        res.end(JSON.stringify(poet));
    });
})

var server = app.listen(8081, function () {
    var port = server.address().port
    console.log("访问端口为%s", port)
})