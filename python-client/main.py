import json
import requests

obj = {
    "ci": "宸纶"
}

res = requests.get('http://127.0.0.1:8084/explain', params=obj)
print(res.json())

headers = {'Authorization': 'eyJhbGciOiJIUzUxMiJ9.eyJsb2dpbl91c2VyX2tleSI6ImY1NGFmN2UwLWY1M2YtNDlkNy1iZWM5LWEzMTZkM2E2ZTUwOSJ9.jRDJuRoVsCMEaT-SefzvkrgH9b6FMoArPqMfPvg44P4wq1GMzx6sLmxIMp79gztSuwWk8liIlkFaFN3iXJfC0g'}
body = {"ci": "宸纶"}

res = requests.post('http://127.0.0.1:8084/explain', data=json.dumps(body), headers=headers)
print(res.json())
