package interfaces

import (
	"github.com/gin-gonic/gin"
	"message_service/application"
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

}

func (m *Message) GetAllMessages(c *gin.Context) {

}