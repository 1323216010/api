import requests

obj = {
    "ci": "宸仪"
}
res = requests.get('http://127.0.0.1:8084/explain', params=obj)


