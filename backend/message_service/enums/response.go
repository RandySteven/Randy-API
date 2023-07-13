package enums

type ResponseMessage string
type ResponseCode int

type Response struct {
	ResponseCode    ResponseCode
	ResponseMessage ResponseMessage
}

var OK *Response = &Response{
	200,
	"OK",
}

var POST *Response = &Response{
	201,
	"Created",
}

var BAD_REQUEST *Response = &Response{
	400,
	"Bad Request",
}

var NOT_FOUND *Response = &Response{
	404,
	"Not Found",
}

var GENERAL_ERROR *Response = &Response{
	500,
	"General Error",
}

var TIMEOUT *Response = &Response{
	504,
	"Timeout",
}
