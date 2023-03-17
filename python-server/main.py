import json
from fastapi import FastAPI, Request
import uvicorn
from typing import Dict

f = open('./json/ci.json', encoding='utf-8')
d = json.load(f)

app = FastAPI()

@app.get("/explanation")
async def explanation(request: Request):
    ci = request.query_params.get("ci")
    for i in d:
        if i['ci'] == ci:
            return i['explanation']


@app.post("/explanation")
async def explanation(request: Request, dict: Dict):
    obj = {}
    obj['Headers'] = request.headers
    obj['body'] = dict
    return obj

if __name__ == "__main__":
    uvicorn.run(app="main:app", port=8084, reload=True)
