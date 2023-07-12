package entity

import (
	"github.com/oklog/ulid/v2"
	"github.com/spf13/viper"
	"strings"
	"time"
)

type Message struct {
	ID        uint64    `gorm:"primary_key;auto_increment" json:"id"`
	MessageId string    `gorm:"size:100;not null" json:"messageId"`
	Message   string    `gorm:"size:100;not null;" json:"message"`
	CreatedAt time.Time `gorm:"default:CURRENT_TIMESTAMP" json:"createdAt"`
	DeletedAt time.Time `json:"deletedAt"`
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
