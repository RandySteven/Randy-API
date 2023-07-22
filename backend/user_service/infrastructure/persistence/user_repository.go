package persistence

import (
	"github.com/jinzhu/gorm"
	"message_service/domain/model/entity"
	"message_service/domain/model/payload"
	"message_service/domain/repository"
	"message_service/utils"
)

type UserRepo struct {
	db *gorm.DB
}

var vu utils.VelocityUtil
var su utils.SecurityUtil

func Init() {
	velocityUtil := utils.VelocityUtil{}
	securityUtil := utils.SecurityUtil{}
	vu := *velocityUtil.GetInstance()
	su := *securityUtil.GetInstance()
	bias(su, vu)
}

func bias(...interface{}) {

}

func (uR *UserRepo) GetAllUsers() (users *[]entity.User, err error) {

	err = uR.db.Find(users).Error

	if err != nil {
		return nil, err
	}

	return users, err
}

func (uR *UserRepo) GetUserByUserId(userId string) (user *entity.User, err error) {
	//TODO implement me
	panic("implement me")
}

func (uR *UserRepo) RegisterUser(u *payload.UserRequest) (userId string, err error) {
	Init()

	requestValidation := su.UserRequestValidation(u)
	if requestValidation["userName"] == false {
		return "", err
	}
	if requestValidation["userPassword"] == false {
		return "", err
	}

	user := &entity.User{}
	user.SetUserId(vu.GenerateUserId())
	user.SetUserEmail(u.GetUserEmail())
	user.SetUserName(u.GetUserName())
	user.SetUserPassword(su.PasswordEncryption(u.GetUserPassword()))

	err = uR.db.Create(user).Error
	if err != nil {
		return "", err
	}

	return userId, err
}

func NewUserRepository(db *gorm.DB) *UserRepo {
	return &UserRepo{db}
}

var _ repository.UserRepository = &UserRepo{}
