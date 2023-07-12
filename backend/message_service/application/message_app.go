package application

import (
	"message_service/domain/entity"
	"message_service/domain/repository"
)

type messageApp struct {
	mr repository.MessageRepository
}

func (m *messageApp) AddMessage(message *entity.Message) (messageId string, err error) {
	return m.mr.AddMessage(message)
}

func (m *messageApp) GetAllMessages() (messages *[]entity.Message, err error) {
	return m.mr.GetAllMessages()
}

var _ MessageAppInterface = &messageApp{}

type MessageAppInterface interface {
	AddMessage(message *entity.Message) (messageId string, err error)
	GetAllMessages() (messages *[]entity.Message, err error)
}
