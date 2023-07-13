package interfaces

import (
	"github.com/gin-gonic/gin"
	"log"
	"message_service/application"
	"message_service/domain/entity"
	"message_service/enums"
	"message_service/utils"
	"net/http"
)

type Message struct {
	messageApp application.MessageAppInterface
}

func NewMessage(messageApp application.MessageAppInterface) *Message {
	return &Message{
		messageApp: messageApp,
	}
}

func (m *Message) AddMessage(c *gin.Context) {
	var message entity.Message
	var rh utils.ResponseHandler
	status := false
	messageId, err := m.messageApp.AddMessage(&message)
	if err != nil {
		return
	} else {
		status = true
	}
	responseMessage := make(map[string]interface{})
	responseMessage["messageId"] = messageId
	responseMessage["message"] = message
	rh.ResponseEncoder(c, http.StatusCreated, status, "responseMessage", responseMessage, enums.POST)
}

func (m *Message) GetAllMessages(c *gin.Context) {
	var response *enums.Response = enums.OK
	var rh utils.ResponseHandler
	var messages entity.Messages
	var err error
	success := true
	log.Println(response)
	messages, err = m.messageApp.GetAllMessages()
	if err != nil {
		return
	}
	rh.ResponseEncoder(c, http.StatusOK, success, "messages", messages.PublicMessages(), response)
}
