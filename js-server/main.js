import path from 'path'
import { fileURLToPath } from 'url'
import express from 'express'
import arr from './json/poet300.json' assert {type: 'json'}

const __filename = fileURLToPath(import.meta.url)
const __dirname = path.dirname(__filename)

var app = express()

app.get('/poet', function (req, res) {
    let poet = []
    for (let i = 0; i < arr.length; i++) {
        if (arr[i].author === req.query.author) {
            poet.push(arr[i])
        }
    }
    res.setHeader('Content-Type', 'application/json; charset=utf8');
    res.end(JSON.stringify(poet))
})

var server = app.listen(8081, function () {
    var port = server.address().port
    console.log("访问端口为%s", port)
})