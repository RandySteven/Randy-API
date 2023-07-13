package main

import (
	"github.com/gin-gonic/gin"
	"github.com/joho/godotenv"
	"log"
	"message_service/infrastructure/middleware"
	"message_service/infrastructure/persistence"
	"message_service/interfaces"
	"message_service/interfaces/routers"
	"os"
)

func init() {

}

/**
Main function to run the application
*/
func main() {

	err := godotenv.Load()
	if err != nil {
		log.Fatal("Error loading .env file")
	}

	/**
	Set the App & DB Configuration
	*/
	app_mode := os.Getenv("APP_ENV")
	dbdriver := os.Getenv("DB_DRIVER")
	host := os.Getenv("DB_HOST")
	password := os.Getenv("DB_PASSWORD")
	user := os.Getenv("DB_USER")
	dbname := os.Getenv("DB_NAME")
	port := os.Getenv("DB_PORT")
	log.Printf("dbDriver = %s \n "+
		"dbName = %s \n "+
		"dbUser = %s \n "+
		"dbPort = %s \n "+
		"dbHost = %s \n",
		dbdriver,
		dbname,
		user,
		port,
		host,
	)

	services, err := persistence.NewRepositories(
		dbdriver,
		user,
		password,
		port,
		host,
		dbname,
	)

	if err != nil {
		log.Fatal(err)
	}

	defer services.Close()
	services.Automigrate()

	if app_mode == "" {
		app_mode = "debug"
	}
	gin.SetMode(app_mode)

	messages := interfaces.NewMessage(services.Message)
	r := gin.New()
	r.Use(middleware.CORSMiddleware())
	v1 := r.Group("/v1")

	routers.MessageRouters(v1, messages)

	app_port := os.Getenv("APP_PORT")

	if app_port == "" {
		app_port = "8080"
	}
	log.Fatal(r.Run(":" + app_port))
}
