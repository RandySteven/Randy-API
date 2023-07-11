package persistence

import (
	"github.com/jinzhu/gorm"
	"message_service/domain/entity"
	"message_service/domain/repository"
)

type MessageRepo struct {
	db *gorm.DB
}

func NewMessageRepository(db *gorm.DB) *MessageRepo {
	return &MessageRepo{
		db,
	}
}

var _ repository.MesssageRepository = &MessageRepo{}

func (m *MessageRepo) AddMessage(message *entity.Message) (messageId string, err error) {
	//TODO implement me
	err = m.db.Debug().Create(&message).Error
	if err != nil {
		return "Error pas masukin message", err
	}
	return message.MessageId, nil
}

func (m *MessageRepo) GetAllMessages() (messages *[]entity.Message) {
	//TODO implement me
	panic("implement me")
	err := m.db.Debug().Order("createdAt").Find(&messages).Error
	if err != nil {
		return messages
	}
	return messages
}
