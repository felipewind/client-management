export class MessageBusinessError {
    error: Error;
    status: number;
}

class Error {
    errorCode: string;
    errorMessage: string;        
}