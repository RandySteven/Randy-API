package entity

import "time"

type Message struct {
	ID        uint64    `gorm:"primary_key;auto_increment" json:"id"`
	MessageId string    `gorm:"size:100;not null" json:"messageId"`
	Message   string    `gorm:"size:100;not null;" json:"message"`
	CreatedAt time.Time `gorm:"default:CURRENT_TIMESTAMP" json:"createdAt"`
	DeletedAt time.Time `json:"deletedAt"`
}

type Messages []Message

func (m *Message) BeforeSave() {

}
