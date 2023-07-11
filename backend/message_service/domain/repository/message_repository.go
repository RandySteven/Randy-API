package repository

import "message_service/domain/entity"

type MesssageRepository interface {
	AddMessage(message *entity.Message) (messageId string, err error)
	GetAllMessages() (messages *[]entity.Message)
}
