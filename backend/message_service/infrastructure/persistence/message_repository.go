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
	err = m.db.Debug().Create(&message).Error
	if err != nil {
		return "Error pas masukin message", err
	}
	return message.MessageId, nil
}

func (m *MessageRepo) GetAllMessages() (messages *[]entity.Message, err error) {
	err = m.db.Debug().Table("messages").Find(messages).Error
	if err != nil {
		return nil, err
	}
	return messages, err
}
