package payload

type UserRequest struct {
	UserName     string
	UserEmail    string
	UserPassword string
}

type IUserRequest interface {
	GetUserName() string
	GetUserEmail() string
	GetUserPassword() string

	SetUserName(userName string)
	SetUserEmail(userEmail string)
	SetUserPassword(userPassword string)
}

func (u *UserRequest) SetUserName(userName string) {
	u.UserName = userName
}

func (u *UserRequest) SetUserEmail(userEmail string) {
	u.UserEmail = userEmail
}

func (u *UserRequest) SetUserPassword(userPassword string) {
	u.UserPassword = userPassword
}

func (u *UserRequest) GetUserName() string {
	return u.UserName
}

func (u *UserRequest) GetUserEmail() string {
	return u.UserEmail
}

func (u *UserRequest) GetUserPassword() string {
	return u.UserPassword
}
