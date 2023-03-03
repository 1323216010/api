package main

import (
	"encoding/json"
	"github.com/gin-gonic/gin"
	"os"
	"path/filepath"
)

func main() {
	sep := string(os.PathSeparator)
	path, _ := filepath.Abs("..")
	path = path + sep + "go-server" + sep + "json" + sep + "poet300.json"
	data, _ := os.ReadFile(path)
	var m []map[string]interface{}
	_ = json.Unmarshal(data, &m)
	/*	fmt.Println(reflect.TypeOf(data))
		fmt.Println(path)*/

	r := gin.Default()

	r.GET("/poet", func(c *gin.Context) {
		var poet []map[string]interface{}
		for i := 0; i < len(m); i++ {
			if m[i]["author"] == c.Query("author") {
				poet = append(poet, m[i])
			}
		}
		c.JSON(200, poet)
	})

	r.Run(":8082")
}
