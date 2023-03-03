import path from 'path';
import {fileURLToPath} from 'url';
import express from 'express'
import fs from 'fs'

const __filename = fileURLToPath(import.meta.url);
const __dirname = path.dirname(__filename);

var app = express();

app.get('/poet', function (req, res) {
    fs.readFile(__dirname + '/json/poet300.json', 'utf8', function (err, str) {
        if(err) {
            console.log(err)
        }
        let arr = JSON.parse(str);
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