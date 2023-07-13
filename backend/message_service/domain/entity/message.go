package entity

import (
	"github.com/oklog/ulid/v2"
	"github.com/spf13/viper"
	"strings"
	"time"
)

type Message struct {
	ID        uint64     `gorm:"primary_key;auto_increment" json:"id"`
	MessageId string     `gorm:"size:100;not null" json:"messageId"`
	Message   string     `gorm:"size:100;not null;" json:"message"`
	CreatedAt time.Time  `json:"createdAt"`
	DeletedAt *time.Time `json:"deletedAt,omitempty "`
}

type Messages []Message

func generateMessageId() string {
	if viper.GetBool("SUITE_NAMING_LOWER_CASE_ID") {
		return strings.ToLower(ulid.Make().String())
	}
	return ulid.Make().String()
}

func (m *Message) BeforeSave() error {
	m.MessageId = "MSG" + generateMessageId()
	m.CreatedAt = time.Now()
	return nil
}

type PublicMessage struct {
	Message   string    `json:"message"`
	CreatedAt time.Time `json:"createdAt"`
}

func (m *Message) PublicMessage() *PublicMessage {
	return &PublicMessage{
		m.Message,
		m.CreatedAt,
	}
}

func (messages Messages) PublicMessages() []interface{} {
	result := make([]interface{}, len(messages))
	for index, message := range messages {
		result[index] = message.PublicMessage()
	}
	return result
}
