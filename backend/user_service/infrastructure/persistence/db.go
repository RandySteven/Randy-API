package persistence

import (
	"fmt"
	"github.com/jinzhu/gorm"
	"message_service/domain/model/entity"
	"message_service/domain/repository"
)

type Repositories struct {
	User repository.UserRepository
	db   *gorm.DB
}

func NewRepositories(DbDriver, DbUser, DbPassword, DbPort, DbHost, DbName string) (*Repositories, error) {
	DBURL := fmt.Sprintf("%s:%s@tcp(%s:%s)/%s", DbUser, DbPassword, DbHost, DbPort, DbName)
	db, err := gorm.Open(DbDriver, DBURL)
	if err != nil {
		return nil, err
	}
	db.LogMode(true)
	return &Repositories{
		User: NewUserRepository(db),
		db:   db,
	}, nil
}

func (s *Repositories) Close() error {
	return s.db.Close()
}

func (s *Repositories) Automigrate() error {
	return s.db.AutoMigrate(
		&entity.User{},
	).Error
}
