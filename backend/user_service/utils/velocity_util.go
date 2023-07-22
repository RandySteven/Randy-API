package utils

import (
	"math/rand"
	"time"
)

type VelocityUtil struct{}

var instance *VelocityUtil

func (vu *VelocityUtil) GetInstance() *VelocityUtil {
	return instance
}

func init() {
	rand.Seed(time.Now().UnixNano())
}

func (vu *VelocityUtil) GenerateId() string {
	alphabet := "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
	number := "0123456789"
	alphaNumeric := []rune(alphabet + number)
	b := make([]rune, 16)
	for i := range b {
		b[i] = alphaNumeric[rand.Intn(len(alphaNumeric))]
	}
	return string(b)
}

func (vu *VelocityUtil) GenerateUserId() string {
	return "USR" + vu.GenerateId()
}
