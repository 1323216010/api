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

	request, _ := http.NewRequest("GET", "http://localhost:8082/poet", reader)
	request.Header.Set("Content-Type", "application/json;charset=utf-8")
	resp, _ := http.DefaultClient.Do(request)
	defer resp.Body.Close()

	bt, _ := io.ReadAll(resp.Body)

	var m1 []map[string]interface{}
	_ = json.Unmarshal(bt, &m1)
	fmt.Println(m1)
}
