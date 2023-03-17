package main

import (
	"bytes"
	"encoding/json"
	"fmt"
	"io"
	"net/http"
)

func main() {
	m := make(map[string]interface{})
	m["author"] = "李白"
	b, _ := json.Marshal(m)
	reader := bytes.NewReader(b)

	request, _ := http.NewRequest("POST", "http://localhost:8082/poet", reader)
	request.Header.Set("Content-Type", "application/json;charset=utf-8")
	request.Header.Set("Authorization", "eyJhbGciOiJIUzUxMiJ9.eyJsb2dpbl91c2VyX2tleSI6ImY1NGFmN2UwLWY1M2YtNDlkNy1iZWM5LWEzMTZkM2E2ZTUwOSJ9.jRDJuRoVsCMEaT-SefzvkrgH9b6FMoArPqMfPvg44P4wq1GMzx6sLmxIMp79gztSuwWk8liIlkFaFN3iXJfC0g")
	resp, _ := http.DefaultClient.Do(request)
	defer resp.Body.Close()

	bt, _ := io.ReadAll(resp.Body)

	var m1 map[string]interface{}
	_ = json.Unmarshal(bt, &m1)
	fmt.Println(m1)
}
