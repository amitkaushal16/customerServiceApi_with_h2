package com.mindtree.exception;


public class ServiceException extends RuntimeException
{
  private int errorCode = 500;

  public ServiceException(int code, String message, Throwable parent)
  {
    super(message, parent);
    errorCode = code;
  }

  public int getErrorCode() { return errorCode; }
}
