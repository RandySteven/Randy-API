package routers

import (
	"github.com/gin-gonic/gin"
	"message_service/interfaces"
)

func MessageRouters(r *gin.RouterGroup, messages *interfaces.Message) {
	messageRouter := r.Group("/messages")
	messageRouter.GET("/", messages.GetAllMessages)
	messageRouter.POST("/", messages.AddMessage)
}
