package persistence

import (
	"github.com/icrowley/fake"
	"github.com/jinzhu/gorm"
	"log"
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

var _ repository.MessageRepository = &MessageRepo{}

func (m *MessageRepo) AddMessage(message *entity.Message) (messageId string, err error) {
	log.Println(fake.GetLangs())
	fake.SetLang("en")
	if message.Message == "" {
		message.Message = fake.Words()
	}
	err = m.db.Create(message).Error
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
