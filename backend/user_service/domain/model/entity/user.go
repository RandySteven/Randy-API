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

	SetUserName(userName string)
	SetUserEmail(userEmail string)
	SetUserId(userId string)
	SetUserPassword(userPassword string)
	SetUserStatus(userStatus string)
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

func (u *User) SetUserName(userName string) {
	u.UserName = userName
}

func (u *User) SetUserEmail(userEmail string) {
	u.UserEmail = userEmail
}

func (u *User) SetUserPassword(userPassword string) {
	u.UserPassword = userPassword
}

func (u *User) SetUserStatus(userStatus string) {
	u.UserStatus = userStatus
}

func (u *User) SetUserId(userId string) {
	u.UserId = userId
}
