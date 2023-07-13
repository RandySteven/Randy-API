package repository

import "message_service/domain/entity"

type MessageRepository interface {
	AddMessage(message *entity.Message) (messageId string, err error)
	GetAllMessages() (messages []entity.Message, err error)
}
