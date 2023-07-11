package persistence

import (
	"fmt"
	"github.com/jinzhu/gorm"
	"message_service/domain/entity"
	"message_service/domain/repository"
)

type Repositories struct {
	Message repository.MesssageRepository
	db      *gorm.DB
}

func NewRepositories(DbDriver, DbUser, DbPassword, DbPort, DbHost, DbName string) (*Repositories, error) {
	DBURL := fmt.Sprintf("host=%s port=%s user=%s dbname=%s sslmode=disable password=%s", DbHost, DbPort, DbUser, DbName, DbPassword)
	db, err := gorm.Open(DbDriver, DBURL)
	if err != nil {
		return nil, err
	}
	db.LogMode(true)
	return &Repositories{
		Message: NewMessageRepository(db),
		db:      db,
	}, nil
}

func (s *Repositories) Close() error {
	return s.db.Close()
}

func (s *Repositories) Automigrate() error {
	return s.db.AutoMigrate(
		&entity.Message{},
	).Error
}
