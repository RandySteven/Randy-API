package utils

import "github.com/gin-gonic/gin"

type ResponseHandler struct{}

func (rh *ResponseHandler) ResponseEncoder(c *gin.Context, statusCode int, status bool, errDetail map[string]string, dataName string, data interface{}) {
	response := make(map[string]interface{})
	response["success"] = status
	response["errorDetail"] = errDetail
	response[dataName] = data
	c.JSON(statusCode, response)
}
