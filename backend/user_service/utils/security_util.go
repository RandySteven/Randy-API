package utils

import (
	"encoding/base64"
	"message_service/domain/model/payload"
)

type SecurityUtil struct{}

var securityInstance *SecurityUtil

func (s *SecurityUtil) GetInstance() *SecurityUtil {
	return securityInstance
}

const REGEX = ""

func (s *SecurityUtil) PasswordEncryption(userPassword string) string {
	encoding := base64.StdEncoding.EncodeToString([]byte(userPassword))
	return encoding
}

func (s *SecurityUtil) UserRequestValidation(userRequest *payload.UserRequest) map[string]bool {
	validationMap := make(map[string]bool)

	if len(userRequest.GetUserName()) < 3 || len(userRequest.GetUserName()) > 32 {
		validationMap["userName"] = false
	}

	if len(userRequest.GetUserPassword()) < 8 || len(userRequest.GetUserPassword()) > 18 {
		validationMap["userPassword"] = false
	}

	return validationMap
}
