package entity

type User struct {
	ID           int64  `gorm:"" json:"ID"`
	UserId       string `gorm:"" json:"userId"`
	UserName     string `gorm:"" json:"userName"`
	UserEmail    string `gorm:"" json:"userEmail"`
	UserPassword string `gorm:"" json:"userPassword"`
	UserStatus   string `gorm:"" json:"userStatus"`
}

type IUser interface {
	GetUserName() string
	GetUserEmail() string
	GetUserId() string
	GetUserPassword() string
	GetUserStatus() string
}

func (u *User) GetUserName() string {
	return u.UserName
}

func (u *User) GetUserEmail() string {
	return u.UserEmail
}

func (u *User) GetUserId() string {
	return u.UserId
}

func (u *User) GetUserPassword() string {
	return u.UserPassword
}

func (u *User) GetUserStatus() string {
	return u.UserStatus
}
