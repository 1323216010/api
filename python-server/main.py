import json
from fastapi import FastAPI, Request
import uvicorn

f = open('./json/ci.json', encoding='utf-8')
d = json.load(f)

app = FastAPI()


@app.get("/explanation")
async def explanation(request: Request):
    ci = request.query_params.get("ci")
    for i in d:
        if i['ci'] == ci:
            return i['explanation']


if __name__ == "__main__":
    uvicorn.run(app="main:app", port=8084, reload=True)
