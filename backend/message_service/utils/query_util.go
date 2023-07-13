package utils

import (
	"fmt"
	"github.com/jinzhu/gorm"
)

type QueryUtil struct {
	db *gorm.DB
}

func selectAll(tableName string) string {
	query := fmt.Sprintf("SELECT * FROM %s", tableName)
	return query
}
