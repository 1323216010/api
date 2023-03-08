import json

from fastapi import FastAPI, Body

f = open('./json/ci.json', encoding='utf-8')
d = json.load(f)

app = FastAPI()


@app.get("/ci")
async def explanation(body=Body(...)):
    for i in d:
        if i['ci'] == body['ci']:
            return i['explanation']
