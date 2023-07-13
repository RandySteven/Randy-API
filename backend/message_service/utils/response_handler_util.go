package utils

import (
	"github.com/gin-gonic/gin"
	"message_service/enums"
)

type ResponseHandler struct{}

func (rh *ResponseHandler) ResponseEncoder(c *gin.Context, statusCode int, status bool, dataName string, data interface{}, httpResponse *enums.Response) {
	response := make(map[string]interface{})
	response["success"] = status
	response["responseCode"] = httpResponse.ResponseCode
	response["responseMessage"] = httpResponse.ResponseMessage
	response[dataName] = data
	c.JSON(statusCode, response)
}
