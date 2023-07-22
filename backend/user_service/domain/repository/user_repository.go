package repository

import (
	"message_service/domain/model/entity"
	"message_service/domain/model/payload"
)

type UserRepository interface {
	RegisterUser(u *payload.UserRequest) (userId string, err error)
	GetAllUsers() (users *[]entity.User, err error)
	GetUserByUserId(userId string) (user *entity.User, err error)
}
